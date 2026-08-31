import java.util.*;
import java.io.IOException;

public class Main{
   public static void main(String[] args) {
    	try {

            java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));

            String[] inpStringArr = r.readLine().split(" ");
            int total =0;
            for(String i : inpStringArr){
                total+=Integer.parseInt(i);
            }
            int result = total/5;
	 
            if((total!=0) && (result*5 == total))
                System.out.println(result);
            else
                System.out.println("-1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}