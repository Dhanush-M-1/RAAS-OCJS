/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		int c=Integer.parseInt(s[2]);
		int d=Integer.parseInt(s[3]);
		if(n<=4){System.out.println(-1);return;}
		else if(k<n+1){System.out.println(-1);return;}
		StringBuilder sb1=new StringBuilder("");
		StringBuilder sb2=new StringBuilder("");
		sb1.append(a+" "+c);
		sb2.append(c+" "+a);
		for(int i=1;i<=n;i++){
			if(i!=a && i!=b && i!=c && i!=d){
				sb1.append(" "+i);
				sb2.append(" "+i);
			}
		}
		sb1.append(" "+d+" "+b);
		sb2.append(" "+b+" "+d);
		System.out.println(sb1);
		System.out.println(sb2);
	}
}