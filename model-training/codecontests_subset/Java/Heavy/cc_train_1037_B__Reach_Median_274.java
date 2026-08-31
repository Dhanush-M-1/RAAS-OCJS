import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class median
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 int s=sc.nextInt();
	 
	 int[] a=new int[n];
	 for(int i=0;i<n;i++) a[i]=sc.nextInt();
	 
	 Arrays.sort(a);
	 
	 if(a[n/2]<s){
	  long ans=0;	
	  for(int i=n/2;i<n;i++)
	   if(a[i]<s) ans+=s-a[i];
	//System.out.println(Arrays.toString(a));
	   System.out.println(ans);
	 }
	 else if(a[n/2]>s){
	  long ans=0;
	  
	  for(int i=n/2;i>=0;i--)
	   if(a[i]>s) ans+=a[i]-s;
	  //System.out.println(Arrays.toString(a)); 
	   System.out.println(ans);
	 }
	 else System.out.println(0);
	}
}