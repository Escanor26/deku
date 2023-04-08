package lab_Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static lab_Activity.userInputandOutput.*;


public class FileWriterz   
{
    public static String[] takeGetLine = new String[100];
    public static FileWriter Writer;
    public static File file;
    public static BufferedReader readFile;
    public static String accType = "";
    public static void main (String [] writer) throws IOException
    {
        String filePath = "C:\Users\onlin\OneDrive\Desktop\final\\storeDatabase.txt";
        file = new File(filePath);
        int attempt = 3;
        userLogin(attempt);
        
    }
    
    public static void userLogin(int attempt) throws IOException
    {
        Out("\n\nEnter Username :: "); String username = STRING();
        Out("Enter Password :: ");  String password = STRING();
        
        if ("ADMIN".equals(username) && "ADMIN".equals(password))
        {
            accType = "ADMIN";
            selection(accType);
        }
        else
        {
            attempt --;
           Outln("\nInvalid Username or Password !!!\n");  
           Out("You have '" +attempt+ "' attempt left\n");
           if(attempt>0)
           userLogin(attempt);
           else
           {
               Out("\nPLease try again later, Program will closed automatically!!!\n");
               System.exit(0);
           }
        }
    }
    
    public static void addData() throws IOException
    {
        Out("\n***********************************\n");
        Out("Enter row id :: ");               int ID = Integer();
        Out("Enter Item Name  :: ");       String itemName = read.readLine();
        Out("Enter Item Quantity  :: ");   int itemQuantity = Integer();
        Out("Enter Item Prize  :: ");        double itemPrize = Double();
         Out("\n***********************************\n");
         try
            {
                Writer = new FileWriter("storeDatabase.txt", true);
                Writer.write(ID + ",\t" + itemName + ",\t" + itemQuantity + ",\t" + itemPrize + ",");
                Writer.write(System.getProperty("line.separator"));
                Writer.close();
            }
            catch(IOException e){
                Out(e);
            }  addMoreItem();
    }
    
    public static void addMoreItem() throws IOException
    {
        Out("Do you want to add more item ? ('Y/N') :: "); char YN = Char();
        switch (YN) 
        {
            case 'Y': addData();  break;
            case 'N': selection(accType); break;
            default:  
                Outln("\nINVALID USER INPUT !!! ");
                addMoreItem();
            break;
        }
    }
    
    public static void retrieveData() throws IOException
    {
                
        readFile = new BufferedReader(new FileReader(file));
        String getLine = "", temp ;
        while ((temp = readFile.readLine()) != null)
        {
            getLine += "\n" + (temp.trim());
        }
        takeGetLine = getLine.split(",");
        Out("\n***********************************");
        for(String Display : takeGetLine)
        {
            Out(Display);
        }  Outln("\n***********************************");
            selection(accType);
    }
    

    
    
    
    public static void selection(String account) throws IOException
    {
        if ("ADMIN".equals(accType))
        {
            Out("\n***********************************\n");
            Out("Press 1 to Add data into Database text file.\n");
            Out("Press 2 to retrieve data in Database text file.\n");
            Out("Press 3 to Update data in Database text file.\n");
            Out("Press 4 to Delete data in Database text file.\n");
            Out("Press 5 to Log out current user.\n");
            Out("Please Select a number :: "); int select = Integer();
            Out("\n***********************************");
            switch (select) 
            {
                case 1:     addData();          break;
                case 2:     retrieveData();     break;
                case 5:     logOutUser();       break;
                default:
                    Outln("\nInvalid entry !!!");
                    System.exit(0);
                 break;
            }
        }
        
    }
    
    
    public static void logOutUser() throws IOException
    {
        userLogin(3);
    }
}
