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
		int n=sc.nextInt();
		String s=sc.next();
		int[] f=new int[26];
		Arrays.fill(f,-1);
		for(int i=n-1;i>=0;i--){
			for(int j=s.charAt(i)-'a'-1;j>=0;j--){
				if(f[j]>=0){
					System.out.println("YES\n"+(i+1)+" "+f[j]);
					System.exit(0);
				}
			}
			if(f[s.charAt(i)-'a']==-1)f[s.charAt(i)-'a']=i+1;
		}
		System.out.println("NO");
	}
}