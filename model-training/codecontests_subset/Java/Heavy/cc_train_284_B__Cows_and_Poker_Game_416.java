/* package codechef; // don't place package name! */

import java.util.Scanner;
import java.util.Arrays;
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try {
		    Scanner sc = new Scanner(System.in);
		    int n,i,c;
		    n=sc.nextInt();
		    sc.nextLine();
		    String s = sc.nextLine();
		    int a [] = new int[3];
		    c=0;
		    for(i=0;i<n;i++){
		        if(s.charAt(i)=='A')
		        a[0]++;
		        else if(s.charAt(i)=='I')
		        a[1]++;
		        else
		        a[2]++;
		    }
		    if(a[1]==0)
		     System.out.println(a[0]);
		     else {
		         a[1] = (a[1]>1)?(0):1;
		     System.out.println(a[1]);
		     }
		} catch(Exception e) {
		}
	}
}
