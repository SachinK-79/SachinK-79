
package filesanddir;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectoryInfo {

   
    private String Directory_Path;
    
    
    
    public Boolean CopyDirectory()
    {
        String source_path;
        String destination_path;
        
          Scanner s = new Scanner(System.in);
         System.out.println("Enter the source directory");
         source_path=s.nextLine();
         System.out.println("Enter the Destination directory");
         destination_path=s.nextLine();
         destination_path=s.nextLine();
                Boolean flag_copy_directory=false;
                Path sourceDirectory= Paths.get(source_path);
                Path destinationDirectory=Paths.get(destination_path);
                try
                {
                    Files.copy(sourceDirectory, destinationDirectory);
                    flag_copy_directory=true;
                }
                catch(Exception ex)
                {
                    
                }
                     return flag_copy_directory;
    }
    
     public void setDirectory_Path(String Directory_Path) {
        this.Directory_Path = Directory_Path;
                                                          }
    
    public Boolean DirectoryExist()
    {
        Path path= Paths.get(Directory_Path);
        boolean isDir= Files.isDirectory(path);
           if(isDir)
           {
               System.out.println("File is a Directory");
           }
           else
           {
               System.out.println("Directory does not exist");
           }
            return isDir;
    }
    
       public ArrayList<String> GetDirectoryFilesInfo(String option_type)
       {
          ArrayList<String> InfoList ;
          if(DirectoryExist())
          {    
             InfoList=AddFileDetails(option_type);
          }
          else
          {
              InfoList=null;
          }
               return InfoList;
       }
       
       
       private ArrayList<String> AddFileDetails(String option_type)
       {
         ArrayList<String> InfoList  = new ArrayList<String>();
           Path dir=Paths.get(Directory_Path);
           try(DirectoryStream<Path> stream= Files.newDirectoryStream(dir))
           {
               for(Path file_path: stream){
                   System.out.println(file_path.getFileName());   
                File file= new File(file_path.toString());
               if(option_type.equalsIgnoreCase("FIL"))
               {
                 if(file.isFile())
                 {
                   InfoList.add(file_path.getFileName().toString());
                 }
               }
               else if(option_type.equalsIgnoreCase("DIR"))
               {
                  if(file.isDirectory())
                  {
                      InfoList.add(file_path.getFileName().toString());
                  }
               }
             }
           }catch(IOException | DirectoryIteratorException x)
           {
               System.err.println();
               InfoList=null;
           }
             return InfoList;
       }
       
}
