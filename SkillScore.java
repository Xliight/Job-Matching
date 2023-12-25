

import java.util.*;
import static java.util.Collections.reverseOrder;
import java.util.Arrays;  
import java.util.List;  
import java.util.ArrayList;

public class SkillScore {
   String[] myDocs;
   ArrayList<String> termList;
   ArrayList<ArrayList<Doc>> docLists;
   ArrayList<List<String>> skill_list;
   ArrayList<String> req_termList;
   double[] docLengthVec;
   HashMap<Integer, Double> skills_cs;
   double[] queryLengthVec;
   
   public SkillScore(String[] docs,String query) {
      myDocs = docs;
      termList = new ArrayList<String>();
      docLists = new ArrayList<ArrayList<Doc>>();
      skill_list = new ArrayList<List<String>>();
      ArrayList<Doc> docList;
      
      int N = myDocs.length;
      docLengthVec = new double[N];
      queryLengthVec = new double[N];
      
      for(int i = 0; i < myDocs.length; i++) {
         String[] tokens = myDocs[i].split(";");
         String token;
         
         String[] query1 = query.split(",");
         List<String> token1 = Arrays.asList(tokens);
         skill_list.add(token1);
         //String token;
         
        // for(int a = 0; a < query1.length; a++){
          //  if(token1.contains(query1[a])){
               //queryLengthVec[i] += Math.pow(w_t,2);
            //}
         //}
         
         for(int j = 0; j < tokens.length; j++) {
            token = tokens[j];
            
            if(!termList.contains(token)) {
               termList.add(token);
               docList = new ArrayList<Doc>();
               Doc doc = new Doc(i, 1); 
               docList.add(doc); 
               docLists.add(docList);
            }
            else {
               int index = termList.indexOf(token);
               docList = docLists.get(index);
               boolean match = false; 
               for(Doc doc : docList) {
                  if(doc.docId == i) { 
                     doc.tw++;
                     match = true;
                     break;
                  }
               }
               
               if(!match) {
                  Doc doc = new Doc(i, 1);
                  docList.add(doc);
               }
            }
         }
      } 
      
      for(int i = 0; i < termList.size(); i++) {
         docList = docLists.get(i);
         int df = docList.size(); 
         Doc doc;
         
         for(int j = 0; j < docList.size(); j++) {
            doc = docList.get(j);
            double tfidf = (1 + Math.log(doc.tw)) * Math.log(N / (df * 1.0));
            docLengthVec[doc.docId] += Math.pow(tfidf, 2);
            doc.tw = tfidf;
            docList.set(j, doc);
         }
      }
      
      for(int i = 0; i < N; i++) {
         docLengthVec[i] = Math.sqrt(docLengthVec[i]);
      }
      
      String[] query1 = query.split(",");
      rankSearch(query1);
   }
   
   public void rankSearch(String[] query) {
      skills_cs = new HashMap<Integer, Double>();
      ArrayList<Doc> docList;
      int N = myDocs.length;
      List<String> a = new ArrayList<String>();
      
      for(String term : query) {
         int index = termList.indexOf(term);
         if(index < 0)
             continue;
         
         docList = docLists.get(index);
         double w_t = Math.log((myDocs.length * 1.0) / docList.size()); 
         Doc doc1;
         for (int i = 0; i < docList.size(); i++){
            doc1 = docList.get(i);
            queryLengthVec[doc1.docId] += Math.pow(w_t,2);
         }
         Doc doc;
         
         for(int j = 0; j < docList.size(); j++) {
            doc = docList.get(j);
            
            double score = w_t * doc.tw; 
            if(!skills_cs.containsKey(doc.docId)) { 
               skills_cs.put(doc.docId, score); 
            }
            else {
               score += skills_cs.get(doc.docId); 
               skills_cs.put(doc.docId, score);
            }
            
         } 
      } 
      
      for(int k = 0; k < N; k++) 
         queryLengthVec[k] = Math.sqrt(queryLengthVec[k]);
      Iterator<Integer> k = skills_cs.keySet().iterator();
      while (k.hasNext()){
         Integer key = k.next();
         double score = skills_cs.get(key);
         score = score/(queryLengthVec[key]*docLengthVec[key]);
         skills_cs.put(key, score);
      }
      
   }
   
   public String toString() {
      String matrixString = new String();
      ArrayList<Doc> docList;
      
      for(int i = 0; i < termList.size(); i++){
         matrixString += String.format("%-15s", termList.get(i));
         docList = docLists.get(i);
         
         for(int j = 0; j < docList.size(); j++)
            matrixString+= docList.get(j) + "\t";
         
         matrixString += "\n";
      }
      
      return matrixString;
   }
}
