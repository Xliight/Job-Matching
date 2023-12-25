

import java.util.*;

public class YearsOfExp{
   HashMap<Integer, Double> YEscore;
      
   public YearsOfExp(String[] exp,String Applicant_YE, ArrayList<Integer> edu_dis) {
      YEscore = new HashMap<Integer, Double>();
      double score; 
      
      for(int i = 0 ; i < exp.length ; i++){
         if(edu_dis.contains(i)){
            if(Integer.parseInt(Applicant_YE)>=Integer.parseInt(exp[i])){
               score = 1.0;
               YEscore.put(i, score);
            }
            else{
               score = 1.0/(Integer.parseInt(exp[i])-Integer.parseInt(Applicant_YE));
               YEscore.put(i, score);
            }
         }
      }
   }
}