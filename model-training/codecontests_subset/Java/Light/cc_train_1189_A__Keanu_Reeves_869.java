import java.io.*;
import java.util.*;

public class Solution7 {
    public static boolean isGood(String str) {
        int zeros = 0, ones = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '0')
                zeros++;
            else
                 ones++;
        }

        return (zeros != ones);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = Integer.parseInt(br.readLine().trim());
        
       // while(t > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();
            if(isGood(str)) {
                System.out.println("1");
                System.out.println(str);
            } else {
                System.out.println("2");
                System.out.println(str.substring(0,1)+" "+str.substring(1));
            }
            //String inp[] = br.readLine().trim().split("\\s");
            //int arr[] = new int[n];

            //System.out.println();
            //t--;
       // }
    }
}
