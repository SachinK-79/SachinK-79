
package filesanddir;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DirectoryFilesInfo {
    
   
   private  String file_name;  // complete path

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setDirectory_name(String directory_name) {
        this.directory_name = directory_name;
    }
   private  String directory_name;
   private  long size;
   private  FileTime date_created;
   private  FileTime date_accessed;
   private  FileTime date_modified;
   private  String extension;
   static SimpleDateFormat sd;

         DirectoryFilesInfo()
        {
            sd= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        }
         
         
    // Check if file exist , check for complete path
        public Boolean File_Exist()
        {
                 File file= new File(file_name) ;
                 Boolean flag;
                  if(file.exists())
                  {
                      flag=true;
                  }   
                  else
                  {
                      flag=false;
                  }
                  return flag;
        }
        
        public String File_Name()
        {
            File file= new File(file_name);
              return file.getName();
        }
        
        public Boolean Directory_Exist()
        {
            Boolean flag;
            File dir= new File(directory_name);
              if(dir.isDirectory())
              {
                  flag=true;
              }
              else
              {
                  flag=false;
              }
              
              return flag;
        }
        
        public long Get_size_File()
        {
            File file= new File(file_name) ;
           if(file.exists())
            return file.length();
           else
               return -1;
        }
        
        public FileTime Date_Created_File()
        {
            //FileTime _date_created=null;
          try
          {   
            Path path= Paths.get(file_name);
            BasicFileAttributes attribute= Files.readAttributes(path, BasicFileAttributes.class);
            date_created= attribute.creationTime();
         
          }
          catch(Exception ex)
          {
              
          }
             return date_created;     
        }
        
       public FileTime Date_Accessed_File()
        {
            //FileTime _date_created=null;
          try
          {   
            Path path= Paths.get(file_name);
            BasicFileAttributes attribute= Files.readAttributes(path, BasicFileAttributes.class);
            date_accessed= attribute.lastAccessTime();
          }
          catch(Exception ex)
          {
              
          }
             return date_accessed ;     
        }
       
       public FileTime Date_Modified_File()
       {
          try
          {   
            Path path= Paths.get(file_name);
            BasicFileAttributes attribute= Files.readAttributes(path, BasicFileAttributes.class);
            date_modified= attribute.lastAccessTime();
          }
          catch(Exception ex)
          {
              
          }
             return date_modified;
        }
       
       public String GetExtension()
       {
             File file= new File(file_name) ;
             if(file.exists())
             {
                if(file.getName().indexOf(".")==-1)
                    extension="";
                else
                    extension= file.getName().substring(file.getName().length()-3,file.getName().length());
             }
                return extension;
       }
   
   
     
       
}
