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
		String rb=sc.nextLine();
		int m,n,c,k=0,l=rb.length(),i,j;
		char ch;
		m=n=c=0;
		for(i=0;i<l;i++)
		{
			ch=rb.charAt(i);
			if(ch=='?')c++;
			if(ch=='+')m++;
			if(ch=='-')n++;
			if(ch=='=')
			{
				k=Integer.parseInt(rb.substring(i+2,l));
				break;
			}
		}
		if((m*k<n)||((m+1)>(n+1)*k))
		{
			System.out.println("Impossible");
		}
		else
		{
			System.out.println("Possible");
			String ans="";
			int f,c1,c2;
			if(m==n)
			{
				ans+=k;
				for(i=1;i<l;i++)
				{
					ch=rb.charAt(i);
					if(ch=='?')
					{
						ans+="1";
					}
					else ans+=ch;
				}
			}
			else if(m<n)
			{
				f=0;
				ans+=k;
				c1=n/m;
				c2=n%m;
				for(i=1;i<l;i++)
				{
					ch=rb.charAt(i);
					if(ch=='?')
					{
						if(rb.charAt(i-2)=='+')
						{
							if(f<c2)
							{
								ans+=(c1+1)+"";
								f++;
							}
							else ans+=c1+"";
						}
						else
						ans+="1";
					}
					else
					ans+=ch;
				}
			}
			else
			{
				c1=((n+1)*k)/(m+1);
				c2=((n+1)*k)%(m+1);
				f=0;
				if(f<c2)
				{
					ans+=(c1+1)+"";
					f++;
				}
				else
				ans+=c1+"";
				for(i=1;i<l;i++)
				{
					ch=rb.charAt(i);
					if(ch=='?')
					{
						if(rb.charAt(i-2)=='+')
						{
							if(f<c2)
							{
								ans+=(c1+1)+"";
								f++;
							}
							else ans+=c1+"";
						}
						else
						ans+=k+"";
					}
					else
					ans+=ch;
				}
			}
			System.out.println(ans);
		}
	}
}