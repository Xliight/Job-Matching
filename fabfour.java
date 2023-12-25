

import java.util.*;
import static java.util.Collections.reverseOrder;

public class fabfour {
	HashMap<Integer, Double> Totalscore;
	public static String[] companyName;
	public static String[] jobTitle;
	public static String[] jobCategory;
	public static String[] jobLocation;
	
	public fabfour(String EDU, String DIS, String YEARS, String SKILLS) {
      Totalscore = new HashMap<Integer, Double>();
      ArrayList<Integer> edu_index;
      ArrayList<Integer> dis_index;
      ArrayList<Integer> edu_dis;
      
      reader read;
      read = new reader("Dataset.csv");
      companyName = read.Company;
      jobTitle = read.Job_Title;
      jobCategory= read.Job_Category;
      jobLocation= read.Job_Location;
      String[] requiredskills = read.Required_Skills;
      String[] desiredskills = read.Desired_Skills;
      String[] education = read.Education;
      String[] discipline = read.Discipline;
      String[] exp = read.Years_of_Experience; 

      InvertedIndex edu;
      edu = new InvertedIndex(education);
      //String edu_query = query[0];
      String edu_query = EDU;
      edu_index= edu.docLists.get(edu.termList.indexOf(edu_query));
      

      
      DisciplineScore dis;
      String dis_query = DIS;
      //String dis_query = query[1];
      dis = new DisciplineScore(discipline,dis_query,edu_index);
      
      SkillScore RS;
      String RSquery = SKILLS.toLowerCase();
      //String RSquery = query[2];
      RS = new SkillScore(requiredskills,RSquery);
      
      SkillScore DS;
      String DSquery = SKILLS.toLowerCase();
      //String DSquery = query[3];
      DS = new SkillScore(desiredskills,DSquery);
   
      YearsOfExp YE;
      String YEquery = YEARS;
      //String YEquery = query[4];
      YE = new YearsOfExp(exp,YEquery,edu_index);
      
      double disscore;
      double reqscore;
      double desscore;
   
      for (int i : edu_index) {
         if(dis.DisScore.get(i)==null)
            disscore = 0;
         else
            disscore = dis.DisScore.get(i);
         if(RS.skills_cs.get(i)==null)
            reqscore = 0;
         else
            reqscore = RS.skills_cs.get(i);
         if(DS.skills_cs.get(i)==null)
            desscore = 0;
         else
            desscore = DS.skills_cs.get(i);
         double score = Math.round(((disscore*.15)+(reqscore*0.5) + (desscore*0.2) + (YE.YEscore.get(i)*0.15))*100*100.0)/100.0;
         Totalscore.put(i,score);
      }
      System.out.println(edu);
   }
}

class Doc {
   int docId;
   double tw; 
   
   public Doc(int did, double weight) {
      docId = did;
      tw = weight;
   }
   
   public String toString() {
      String docIdString = docId + ": " + tw;
      return docIdString;
   }
}