/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int looplim=sc.nextInt();
		for(int iter=0;iter<looplim;iter++)
		{   String res="";
		int count=0;
		    int n=sc.nextInt();
		    sc.nextLine();
		    String[] arr = new String[n];
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextLine();
		    //Check 0,1 and 1,0 to be same,
		    //also check n-1,n-2 to be same as n-2,n-1
		    //if not in any case, we change the elft side  ka 0 to 1, and right side ka 1 to 0
		    if(arr[0].charAt(1)==arr[1].charAt(0))
		    {
		        char c=arr[0].charAt(1);
		        if(arr[n-1].charAt(n-2)==c)
		        {count++; res+=Integer.toString(n)+" "+Integer.toString(n-1)+"\n";}
		        if(arr[n-2].charAt(n-1)==c)
		        {count++; res+=Integer.toString(n-1)+" "+Integer.toString(n)+"\n";}
		    }
		    
		    else if(arr[n-1].charAt(n-2)==arr[n-2].charAt(n-1))
		    {
		        char c=arr[n-1].charAt(n-2);
		        if(arr[0].charAt(1)==c)
		        {count++; res+="1 2\n";}
		        if(arr[1].charAt(0)==c)
		        {count++; res+="2 1\n";}
		    }
		    else
		    {
		        if(arr[0].charAt(1)=='1')
		        {count++; res+="1 2\n";}
		        if(arr[1].charAt(0)=='1')
		        {count++; res+="2 1\n";}
		        if(arr[n-1].charAt(n-2)=='0')
		        {count++; res+=Integer.toString(n)+" "+Integer.toString(n-1)+"\n";}
		        if(arr[n-2].charAt(n-1)=='0')
		        {count++; res+=Integer.toString(n-1)+" "+Integer.toString(n)+"\n";}
		        
		        
		        
		        
		    }
		    
		    
		    
		    
		    System.out.println(count);
		    System.out.print(res);
		    
		    //your code goes here
		}
		
		
	}
}
