
/**
 * @author: Mehul Raheja
 */

import java.util.*;
import java.io.*;

public class Bark{

    /*
        Runtime = O()
     */
    static int N, M, K;
    static String s,s1;
    static StringTokenizer st;
    static int[] d;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        boolean a = false;
        boolean b = false;
        for (int i = 0; i < N; i++) {
            s1 = br.readLine();
            if(s.equals(s1)){
                a = true;
                b = true;
            }
            if(s.charAt(0) == s1.charAt(1)){
                a = true;
            }
            if(s.charAt(1) == s1.charAt(0)){
                b = true;
            }
        }
        
        System.out.println((a&&b)?"YES":"NO");
    }    
}
