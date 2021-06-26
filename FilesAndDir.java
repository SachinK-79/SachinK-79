
package filesanddir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class DirectoryAndFilesInfo
{
    
    
    public void CopyDirectory()
    {
        
          DirectoryInfo objDirectoryInfo= new DirectoryInfo();
          Boolean flag_copy=objDirectoryInfo.CopyDirectory();
           if(flag_copy)
           {
               System.out.println("Directory copied. Ok");
           }
           else
           {
               System.out.println("Directory could not be copied");
           }
            
    }
    
    public void Directory_Info_Details()
    {
        String directory_path;   // Complete Directory path.....
        String option_type;     //  input the option type...
        //System.out.println("This is Directory Information Details");
        DirectoryInfo objDirectoryInfo= new DirectoryInfo();
             Scanner s = new Scanner(System.in);
        System.out.println("Please enter the Directory path");
           directory_path=s.nextLine();
        System.out.println("Enter the required option(DIR,FIL)");
            option_type=s.nextLine();
           objDirectoryInfo.setDirectory_Path(directory_path);
           ArrayList<String> filesList=objDirectoryInfo.GetDirectoryFilesInfo(option_type);
           System.out.println("Total no. of files are"+ filesList.size() );
           if(filesList!=null)
           {
               for(String file :filesList)
               {
                   System.out.println("File Info"+file);
               }
           }
    }
    
    public void File_Info_Details()          // class to display different option details.
    {
        String ans;
        int option;
        String file_path;
        Scanner s = new Scanner(System.in);
        DirectoryFilesInfo objDirFile= new DirectoryFilesInfo();
        System.out.println("Enter the file Path");
        file_path=s.nextLine();
        System.out.println("Your selected file path is"+ file_path);
        objDirFile.setFile_name(file_path);
        if(objDirFile.File_Exist())
        {
            System.out.println("File Path Exist");
            System.out.println("File Details");
            System.out.println("Name of the file is"+ objDirFile.File_Name() );
            System.out.println("Extension of the file is"+ objDirFile.GetExtension() );
            System.out.println("Size of the file is"+ objDirFile.Get_size_File());
            System.out.println("Creation Date of File  is"+ objDirFile.Date_Created_File());
            System.out.println("Modified Date of File  is"+ objDirFile.Date_Modified_File());
            System.out.println("Last Acces of of File  is"+ objDirFile.Date_Accessed_File());
            
             // Check if the User wants to store data in log file.
             // If yes pass the object objDirFile to Log object
            System.out.println("Do you want to store the data in the log file. Yes,No");
             ans=s.nextLine();
              if(ans.equals("Yes"))
              {
                   Logs.CreateLog(objDirFile);
              }
        }
        else
            System.out.println("File does not exist");
    }
}
public class FilesAndDir {

    
    public static void main(String[] args) {
         
         char ans;
         int option;
         Scanner input= new Scanner(System.in);
         DirectoryAndFilesInfo objDirFileInfo= new DirectoryAndFilesInfo();
         do
         {
             System.out.flush();
             System.out.println("Main menu screen");
             System.out.println("option=1 FilesInfo");
             System.out.println("option=2 DirectoryInfo");
             System.out.println("option=3 Copy Directory");
             option= input.nextInt();
             switch(option)
             {
                 case 1:
                      objDirFileInfo.File_Info_Details();
                      break;
                 case 2:
                     objDirFileInfo.Directory_Info_Details();
                     break;
                 case 3:
                     objDirFileInfo.CopyDirectory();
                     break;
             }
             System.out.println("Do You want to continue(Y\\N):");
              ans=input.next().charAt(0);
         }while(ans=='y' || ans=='Y');
                }
    
       }
 