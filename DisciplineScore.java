

import java.util.*;

public class DisciplineScore{
   HashMap<Integer, Double> DisScore;

   public DisciplineScore(String[] discipline, String dis_query, ArrayList<Integer> edu_index){
      DisScore = new HashMap<Integer, Double>();
      
      for(int i = 0 ; i < discipline.length ; i++){
         if(edu_index.contains(i)){
            String[] tokens = discipline[i].split(";");
            if(Arrays.asList(tokens).contains(dis_query)){
               DisScore.put(i, 1.0);
            }
           else if(Arrays.asList(tokens).contains("Any"))
               DisScore.put(i, 1.0);
            else{
               DisScore.put(i, 0.0);
            }
         }
      }
   }
}