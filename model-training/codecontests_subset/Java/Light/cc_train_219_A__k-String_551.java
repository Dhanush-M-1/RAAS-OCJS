/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int n,i,j,k,l,c=0;
		n=in.nextInt();
		in.nextLine();
		String s=in.nextLine();
		String ans="";
		l=s.length();
		int[] a=new int[26];
		for (i=0;i<l;i++)
		{
		    char ch=s.charAt(i);
		    a[ch-'a']++;
		}
		for (i=0;i<26;i++)
		{
		    if (a[i]%n!=0)
		    {
		        c++;
		        break;
		    }
		}
		if (c>0)
		System.out.println(-1);
		else
		{
		    for (i=0;i<26;i++)
		    {
		        for (j=0;j<a[i]/n;j++)
		        {
		            ans=ans+((char)('a'+i));
		        }
		    }
		    for (k=0;k<n;k++)
		    {
		        System.out.print(ans);
		    }
		}
	}
}
