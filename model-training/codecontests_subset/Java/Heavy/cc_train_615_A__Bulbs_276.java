/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class CodeForces
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] bulbs = new int[m];
        
        for (int i = 0; i < n; ++i){
            int g = sc.nextInt();
            for (int j = 0; j < g; ++j){
                int num = sc.nextInt();
                num--;
                bulbs[num] = 1;
            }
        }
        
        boolean ok = true;
        for (int i = 0; i < m; ++i){
            if (bulbs[i] == 0){
                ok = false;
                break;
            }
        }
        
        if (ok == true){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
