import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	 {
	     int n=sc.nextInt();
	     int m=sc.nextInt();
	     int [] a=new int[n];
	     for(int i=0;i<n;i++)
	      a[i]=sc.nextInt();
	     int [] b=new int[m];
	     for(int i=0;i<m;i++)
	      b[i]=sc.nextInt();
	      
	     boolean res=false;
	     int ans=0;
	      
	     for(int i=0;i<n;i++)
	     {
	         for(int j=0;j<m;j++)
	         {
	             if(a[i]==b[j])
	             {
	                 res=true;
	                 ans=a[i];
	                 break;
	             }
	         }
	         if(res==true)
	          break;
	     }
	     if(res==false)
	      System.out.println("NO");
	     else
	     {
	      System.out.println("YES");
	      System.out.print(1+" "+ans);
	      System.out.println();
	     }
	 }
	}
}
