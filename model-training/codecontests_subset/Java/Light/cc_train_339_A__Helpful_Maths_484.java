/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
       Scanner ob=new Scanner(System.in);
       String str=ob.nextLine();
       int a[]=new int[4];
       String s1="";
       if(str.length()==1)
       {
           System.out.println(str);
       }
       else
       {
           for(int i=0;i<str.length();i++)
           {
               char x=str.charAt(i);
               if(x>48 && x<=51)
               a[x-49]++;
           }
           int k=0;
           for(int i=0;i<=str.length();i++)
           {
               if(a[k]>0)
               {
                   s1=s1+(k+1)+"+";
                   a[k]--;
               }
               else
               {
                   k++;
                  if(k>=3)
                  break;
               }
           }
           System.out.println(s1.substring(0,s1.length()-1));
       }
	}
}
