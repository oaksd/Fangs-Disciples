/*
 * GetTemp.java
 * 
 * Copyright 2017  <pi@raspberrypi>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


/**
 * Gathers temperature from temperv14 Thermometer and writes that temp to
 * a txt file
 * 
 * @author (Sean Oak) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
/*
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
*/
public class GetTemp
{

    /**
     * Main method, will run getTemp every 5 seconds, and 
     * thus will write current temp to a txt file every 5 seconds
     */
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {
      int i = 4;
      //FileWriter fw = new FileWriter("temp_3.txt",true);
      //BufferedWriter bw = new BufferedWriter(fw);
      //PrintWriter out = new PrintWriter(bw);
      PrintWriter writer = new PrintWriter(new FileOutputStream(new File("/var/www/html/temp.html"),true));
        //File htmlFile = new File("documents/temp.html");
        
        //double limit = 0;
        
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                    getTemp(writer);
                    writer.close();
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
		 if(limit > 76.0){
			 // Recipient's email ID needs to be mentioned.
			  String to = "oaksd@miamioh.edu";

			  // Sender's email ID needs to be mentioned
			  String from = "oak.s1416@gmail.com";

			  // Assuming you are sending email from localhost
			  String host = "localhost";

			  // Get system properties
			  Properties properties = System.getProperties();

			  // Setup mail server
			  properties.setProperty("mail.smtp.host", host);

			  // Get the default Session object.
			  Session session = Session.getDefaultInstance(properties);

			  try {
				 // Create a default MimeMessage object.
				 MimeMessage message = new MimeMessage(session);

				 // Set From: header field of the header.
				 message.setFrom(new InternetAddress(from));

				 // Set To: header field of the header.
				 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				 // Set Subject: header field
				 message.setSubject("ALERT: FSB Server Room Temp");

				 // Now set the actual message
				 message.setText("Room temperature is over 76 Degrees Fahrenheit");

				 // Send message
				 Transport.send(message);
				 System.out.println("Sent message successfully....");
			  }catch (MessagingException mex) {
				 mex.printStackTrace();
			  }
		}	
        */
    }

    /*
     * Writes current temp taken from terminal ("temperv14") to a file
     */
    public static void getTemp(PrintWriter writer) throws java.io.IOException, java.lang.InterruptedException
    {
        String[] args = new String[] {"/bin/bash", "-c", "sudo temperv14", "with", "args"};
        Process proc = new ProcessBuilder(args).start();
        
        
       // PrintWriter writer = new PrintWriter("temp_"+ i++ +".txt","UTF-8");
        
        BufferedReader reader =  
              new BufferedReader(new InputStreamReader(proc.getInputStream()));
              
        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            writer.append(line + "<br>");
            writer.close();

        }
        
        // writer.close();
        //bw.close();
        proc.waitFor();   
    }

    
}



