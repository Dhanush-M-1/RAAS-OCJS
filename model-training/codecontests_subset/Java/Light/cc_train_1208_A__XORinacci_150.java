/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		while(t-->0){
			int a=sc.nextInt(),b=sc.nextInt(),k=sc.nextInt();
			if(k%3==0)sb.append(a+"\n");
			if(k%3==1)sb.append(b+"\n");
			if(k%3==2)sb.append((a^b)+"\n");
		}
		System.out.println(sb);
	}
}