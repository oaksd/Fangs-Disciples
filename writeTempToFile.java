
/**
 * Write a description of class DisplayTemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class DisplayTemp
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DisplayTemp
     */
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {

        getTemp();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void getTemp() throws java.io.IOException, java.lang.InterruptedException
    {
        String[] args = new String[] {"/bin/bash", "-c", "temperv14", "with", "args"};
        Process proc = new ProcessBuilder(args).start();
        
        BufferedReader reader =  
              new BufferedReader(new InputStreamReader(proc.getInputStream()));
              
        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();   

    }
              
}

