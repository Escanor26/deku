package lab_Activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class userInputandOutput
{

    
    public static final InputStreamReader ISR = new InputStreamReader(System.in);
    public static BufferedReader read = new BufferedReader(ISR);
    
    public static void Out (Object printResult )
    {
        System.out.print    (printResult);
    }
    public static void Outln (Object printResult )
    {
        System.out.println    (printResult);
    }
   
    
    public static int Integer() throws  IOException
    {
        return  Integer.parseInt(read.readLine());
    }
    public static double Double() throws  IOException
    {
        return  Double.parseDouble(read.readLine());
    }
    public static char Char() throws IOException
    {
        return (char) read.readLine().charAt(0);
    }
    public static String STRING() throws IOException
    {
        return read.readLine();
    }
}
