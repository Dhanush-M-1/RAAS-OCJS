
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
 public class Code
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		for(int i1=0;i1<a;i1++)
		{
		  String s=in.next();int n=s.length();
		  char[] ar=new char[n+1];
		  for(int i=0;i<n;i++)
		  ar[i]=s.charAt(i);
		  ar[n]='.';
		  if(n==1)
		  {
		      System.out.println(0);
		  }
		  else if(n==2 )
		  {
		      if(s.charAt(0)==s.charAt(1))
		      {
		          System.out.println(1);
		      }
		      else
		      System.out.println(0);
		  }
		  else
		  {
		      int c=0;
		      for(int i=0;i<n-1;i++)
		      {
		          if(ar[i]==ar[i+1] && ar[i]!='?' && ar[i]!='*')
		          {
		              c++;
		              ar[i+1]='*';
		          }
		          if(ar[i]==ar[i+2] && ar[i]!='?' && ar[i]!='*')
		          {
		              c++;
		              ar[i+2]='?';
		          }
		      }
		      System.out.println(c);
		  }
}
}
}
