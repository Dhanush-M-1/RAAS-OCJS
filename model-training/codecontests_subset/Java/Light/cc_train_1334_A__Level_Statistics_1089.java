/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int[] p = new int[n];
		    int[] q = new int[n];
		    for (int i = 0; i < n; i++) {
		        p[i] = sc.nextInt();
		        q[i] = sc.nextInt();
		    }
		    isValid(p, q, n);
		}
	}
	
	public static void isValid(int[] p, int[] q, int n) {
	    for (int i = 0; i < n; i++) {
	        if (q[i] > p[i]) {
	            System.out.println("NO");
	            return;
	        } else if (i != 0 && (p[i - 1] > p[i] || q[i - 1] > q[i] || (q[i] - q[i - 1]) > (p[i] - p[i - 1]))) {
	            System.out.println("NO");
	            return;
	        }
	    }
	    System.out.println("YES");
	}
}
