/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t--!=0){
            // String s = br.readLine();
            // boolean[] pre = new boolean[3];
            // int[] arr = new int[3];
            double n = Double.parseDouble(br.readLine());
            double l = 1/(Math.sin((Math.PI/2)/(2*n))*2);
            
            System.out.println(l);
            
            // System.out.println(ans);
        }
	}
}
