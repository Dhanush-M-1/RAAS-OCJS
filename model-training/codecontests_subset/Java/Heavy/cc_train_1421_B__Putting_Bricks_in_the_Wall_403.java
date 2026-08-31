/* package whatever; // don't place package name! */

import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int test = sc.nextInt();
    	while(test-- > 0) {
    		int n = sc.nextInt();
    		char[][] r_id = new char[n][n];
    		for(int i = 0; i<n; i++) {
    			String str = sc.next();
    			r_id[i] = str.toCharArray();
    		}
    		if(r_id[0][1] == '0' && r_id[1][0] == '0' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '0') {
    			System.out.println(2);
    			System.out.println((n-1+1) + " " + (n-2+1));
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '0' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '0') {
    			System.out.println(2);
    			System.out.println((0+1) + " " + (1+1));
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '1' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '1') {
    			System.out.println(2);
    			System.out.println((0+1) + " " + (1+1));
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '0' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '1') {
    			System.out.println(2);
    			System.out.println((0+1) + " " + (1+1));
    			System.out.println((n-1+1) + " " + (n-2+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '1' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '0') {
    			System.out.println(2);
    			System.out.println((1+1) + " " + (0+1));
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '1' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '1') {
    			System.out.println(2);
    			System.out.println((n-1+1) + " " + (n-2+1));
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '1' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '0') {
    			System.out.println(1);
    			System.out.println((n-1+1) + " " + (n-2+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '1' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '1') {
    			System.out.println(1);
    			System.out.println((1+1) + " " + (0+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '1' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '1') {
    			System.out.println(1);
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '0' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '1') {
    			System.out.println(1);
    			System.out.println((0+1) + " " + (1+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '0' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '1') {
    			System.out.println(1);
    			System.out.println((n-1+1) + " " + (n-2+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '0' && r_id[n-1][n-2] == '1' && r_id[n-2][n-1] == '0') {
    			System.out.println(1);
    			System.out.println((n-2+1) + " " + (n-1+1));
    		}else if(r_id[0][1] == '1' && r_id[1][0] == '0' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '0') {
    			System.out.println(1);
    			System.out.println((1+1) + " " + (0+1));
    		}else if(r_id[0][1] == '0' && r_id[1][0] == '1' && r_id[n-1][n-2] == '0' && r_id[n-2][n-1] == '0') {
    			System.out.println(1);
    			System.out.println((0+1) + " " + (1+1));
    		}else{
    			System.out.println(0);
    		}
		// your code goes here
	}
	}
}