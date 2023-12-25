

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class reader {
   String[] Company;
   String[] Job_Title;
   String[] Job_Category;
   String[] Job_Location;
   String[] Education;
   String[] Discipline;
   String[] Required_Skills;
   String[] Desired_Skills;
   String[] Years_of_Experience;

   public reader (String fileName){
      try{
         Path pathToFile = Paths.get(fileName);
         BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(pathToFile)));
         reader.readLine();
         String line;
         String[] attributes;
         int i = 0;
         while (reader.readLine()!=null)
            i++;
         reader = new BufferedReader(new FileReader(String.valueOf(pathToFile)));
         Company = new String[i];
         Job_Title = new String[i];
         Job_Category = new String[i];
         Job_Location = new String[i];
         Education = new String[i];
         Discipline = new String[i];
         Required_Skills = new String[i];
         Desired_Skills = new String[i];
         Years_of_Experience = new String[i];
         i = 0;
         reader.readLine();
         while ((line=reader.readLine())!=null){
            attributes = line.split(",");
            Company[i] = attributes[0];
            Job_Title[i] = attributes[1];
            Job_Category[i] = attributes[2];
            Job_Location[i] = attributes[3];
            Education[i] = attributes[4];
            Discipline[i] = attributes[5];
            Required_Skills[i] = attributes[6].toLowerCase();
            Desired_Skills[i] = attributes[7].toLowerCase();
            Years_of_Experience[i] = attributes[8];
            i++;
         }
      }
      catch(IOException ioe) {
         ioe.printStackTrace();
      }
   }
}
