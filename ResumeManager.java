import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

class ResumeManager{
    String resumeFile="resume.txt";

    void setResumeData(int playerRow, int playerCol, int enemyRow, int enemyCol,int playerHealth,int enemyHealth,int coins,int enemikilled,int score){
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(resumeFile))){
            writer.write(playerRow+" "+playerCol+" "+enemyRow+" "+enemyCol+" "+playerHealth+" "+enemyHealth+" "+coins+" "+enemikilled+" "+score);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    int[] getResumeData(){
            try(BufferedReader reader = new BufferedReader(new FileReader(resumeFile))){
            String resumeData = reader.readLine();
            String resumeDataList[] = resumeData.split(" ");

            int resumeIntArray[] = new int[resumeDataList.length];
            for (int i = 0; i < resumeDataList.length; i++) {
                resumeIntArray[i] = Integer.parseInt(resumeDataList[i]);
            }

        return resumeIntArray;

        }catch(IOException e){
            e.printStackTrace();
            return new int[0];
        }
    }

    boolean resumeStatus(){
        try{
            Path path = Path.of(resumeFile);
            long size = Files.size(path);
            if(size==0){
                return false;
            }else{
                return true;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    void clearResumeFile(){
      try(BufferedWriter writer=new BufferedWriter(new FileWriter(resumeFile))){
        writer.write("");
      } catch(IOException e){
        e.printStackTrace();
      }
    }
}