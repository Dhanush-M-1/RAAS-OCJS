/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    int c=sc.nextInt();
		    int op1=Math.min(b,c/2);
		    int count=0;
		    b=b-op1;
		    count=op1*3;
		    if(b>=2)
		    {
		        int op2=Math.min(b/2,a);
		        count+=op2*3;
		    }
		    System.out.println(count);
		}
	}
}