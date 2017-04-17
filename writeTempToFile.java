
/**
 * Gathers temperature from temperv14 Thermometer and writes that temp to
 * a txt file
 * 
 * @author (Sean Oak) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class DisplayTemp
{

    /**
     * Main method, will run getTemp every 5 seconds, and 
     * thus will write current temp to a txt file every 5 seconds
     */
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {
      
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                getTemp();
            } 
            catch (java.io.IOException e){
                System.out.println("IOException " + e);
            }
            catch (java.lang.InterruptedException e){
                /// do nothing
            }
        }
        }, 0, 5000);
        
        
        /*
        Runnable fiveInterval = new Runnable() {
            public void run() {
                getTemp();
        };
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(fiveInterval,0,5,TimeUnit.SECONDS);
        */
        /*
        Timer timer = new Timer();
        timer.schedule(new FiveInterval(),0,5000);
    */
    }

    /*
     * Writes current temp taken from terminal ("temperv14") to a file
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

