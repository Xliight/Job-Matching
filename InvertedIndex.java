

import java.util.*;

public class InvertedIndex {
   String[] myDocs; 
   ArrayList<String> termList; 
   ArrayList<ArrayList<Integer>> docLists; 
   
   public InvertedIndex(String[] docs) {
      myDocs = docs; 
      termList = new ArrayList<String>();
      docLists = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> docList; 
      
      for(int i = 0; i < myDocs.length; i++) {
         String[] tokens = myDocs[i].split(";"); 
         
         for(String token : tokens) {
            if(!termList.contains(token)) { 
               termList.add(token); 
               docList = new ArrayList<Integer>(); 
               docList.add(new Integer(i)); 
               docLists.add(docList); 
            }
            else { 
               int index = termList.indexOf(token); 
               docList = docLists.get(index);
               
               if(!docList.contains(new Integer(i))) { 
                  docList.add(new Integer(i)); 
                  docLists.set(index, docList); 
               }
            }
         }
      }
   }
   
   public String toString() {
      String matrixString = new String();
      ArrayList<Integer> docList;
      
      for(int i = 0; i < termList.size(); i++) {
         matrixString += String.format("%-15s", termList.get(i));
         docList = docLists.get(i);
         
         for(int j = 0; j < docList.size(); j++) {
            matrixString += docList.get(j) + "\t";
         }
         
         matrixString += "\n";
      }
      
      return matrixString;
   }
   
   public ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
      ArrayList<Integer> mergedList = new ArrayList<Integer>();
      int id1 = 0, id2 = 0; 
      
      while(id1 < l1.size() && id2 < l2.size()) {
         if(l1.get(id1).intValue() == l2.get(id2).intValue()) { 
            mergedList.add(l1.get(id1));
            id1++;
            id2++;
         }
         else if(l1.get(id1) < l2.get(id2)) 
            id1++;
         else 
            id2++;
      }
      return mergedList;
   }
}