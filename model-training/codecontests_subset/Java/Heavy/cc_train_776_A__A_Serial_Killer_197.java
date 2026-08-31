/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String[] str1 = new String[2];
		String[] str2 = new String[2];
		str1[0] = sc.next();
		str1[1] = sc.next();
		
		System.out.println(str1[0] + " " + str1[1]);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++){
		    str2[0] = sc.next();
		    str2[1] = sc.next();
		    
		    if(str2[0].equals(str1[0]))
		        str1[0] = str2[1];
		    else
		        str1[1] = str2[1];
		    
		    System.out.println(str1[0] + " " + str1[1]);
		}
		
	}
}
