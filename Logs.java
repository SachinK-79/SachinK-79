
package filesanddir;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;

public class Logs {
    
       private static  Boolean Create_Log_File(String Log_File_Path)
       {
           File file= new File(Log_File_Path);
            Boolean flag_file_ok=true;
            Boolean file_ok=true;
           try
           {
                flag_file_ok= file.createNewFile();
                if(flag_file_ok)
                {
                    System.out.println("File Created");
                }
                else
                {
                    System.out.println("File already exist");
                }
           }
           catch(Exception ex)
           {
               System.err.println("Error Creating file"+ ex.getMessage());
               file_ok=false;
           }
               return file_ok;
       }
      
      public static  void  CreateLog(DirectoryFilesInfo objDirectoryFilesInfo )
      {
          Boolean flag;
          String log_path="d:/JavaLogs/";
          String log_file;
          String log_path_file;
       
          if(objDirectoryFilesInfo!=null)
          {
              //log_file="lg"
              Date currentDate= new Date();
              SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy");
              String date=dateFormat.format(currentDate);
              log_file="lg"+ date +".txt";
             log_path_file= Paths.get(log_path, log_file).toString(); 
              System.out.println("Date is"+date);
              System.out.println("File Information from logs");
              System.out.println("Name"+ objDirectoryFilesInfo.File_Name());
              System.out.println("Log file "+ log_path_file);
            Boolean log_ok=  Create_Log_File(log_path_file);
              if(log_ok)
              {
                   try{    
                         FileWriter fw=new FileWriter(log_path_file);    
                         fw.write("File Accesses Details");
                        
                         fw.write("File Name:"+ objDirectoryFilesInfo.File_Name());
                         fw.write("File Extension:"+ objDirectoryFilesInfo.GetExtension());
                         fw.write("Date Created is"+ objDirectoryFilesInfo.Date_Modified_File());
                         fw.write("Date Accessed is"+ objDirectoryFilesInfo.Date_Accessed_File());
                         fw.write("Date Modified is"+ objDirectoryFilesInfo.Date_Modified_File());
                         fw.close();    
              }catch(Exception e){System.err.println("error writing to log"+e.getMessage());}   
             }
              else
              {
                  System.out.println("");
              }
          }
          else
          {
              System.out.println("Error for logs");
          }
      }
    
}
