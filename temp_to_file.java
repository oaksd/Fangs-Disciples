import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
  
        while(in.hasNext()){
            try{
                PrintWriter writer = new PrintWriter("temp_log_test_3-28.txt", "UTF-8");
                writer.println(in+" ");
                writer.close();
            } catch (IOException e) {
               System.out.println("IOException");
            }
        }
        in.close();
    }
}