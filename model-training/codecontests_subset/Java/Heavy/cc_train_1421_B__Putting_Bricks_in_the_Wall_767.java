import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(buf.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<t;i++)
		{
		   int n=Integer.parseInt(buf.readLine());
		   String arr[][]=new String[n][n];
		   for(int j=0;j<n;j++)
		   {
		       String st[]=(buf.readLine().trim()).split("");
		       for(int z=0;z<n;z++)
		       {
		           arr[j][z]=st[z];
		       }
		   }
		   String f1=arr[0][1],s1=arr[1][0],f2=arr[n-2][n-1],s2=arr[n-1][n-2];
		   int ct=0;
		   String st1="",st2="";
		   if(f1.charAt(0)=='1' && s1.charAt(0)=='1')
		   {
		       if(f2.charAt(0)!='0')
		       {
		           st1=(n-1)+" "+(n);
		           ct++;
		       }
		       if(s2.charAt(0)!='0')
		       {
		           st2=(n)+" "+(n-1);
		           ct++;
		       }
		      
		   }
		   else if(f1.charAt(0)=='0' && s1.charAt(0)=='0')
		   {
		       if(f2.charAt(0)!='1')
		       {
		           st1=(n-1)+" "+(n);
		           ct++;
		       }
		       if(s2.charAt(0)!='1')
		       {
		            st2=(n)+" "+(n-1);
		           ct++;
		       }
		   }
		   else
		   {
		       if(f2.charAt(0)=='0' && s2.charAt(0)=='0')
		       {
		           if(f1.charAt(0)=='0')
		           {
		               st1=1+" "+2;
		               ct++;
		           }
		           else
		           {
		               st1=2+" "+1;
		               ct++;
		           }
		       }
		       else if(f2.charAt(0)=='1' && s2.charAt(0)=='1')
		       {
		           if(f1.charAt(0)=='1')
		           {
		                st1=1+" "+2;
		               ct++;
		           }
		           else
		           {
		               st1=2+" "+1;
		               ct++;
		           }
		       }
		       else
		       {
		           if(f2.charAt(0)=='0')
		           {
		               st1=(n-1)+" "+(n);
		              ct++;
		           }
		           else
		           {
		               st1=(n)+" "+(n-1);
		           ct++;
		           }
		           if(f1.charAt(0)=='1')
		           {
		               st2=1+" "+2;
		               ct++;
		           }
		           else
		           {
		               st2=2+" "+1;
		               ct++;
		           }
		       }
		   }
		    sb.append(ct+"\n");
		       if(st1.length()!=0)
		       sb.append(st1+"\n");
		       if(st2.length()!=0)
		       sb.append(st2+"\n");
		}
		System.out.println(sb);
	}
}
