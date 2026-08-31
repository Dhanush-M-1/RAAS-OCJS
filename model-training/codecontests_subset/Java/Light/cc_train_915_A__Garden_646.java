import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int i;
		int a[]=new int[n];
		for(i=0;i<n;i++)
		  a[i]=sc.nextInt();
		 
		int min=Integer.MAX_VALUE;
			for(i=0;i<n;i++)
         	{
 			        
			        if(k%a[i]==0)
			        {
			         if(k/a[i] <min)
			            min=k/a[i];
			         
			           
			        }
         	
			        
			    // System.out.println(p);
			}  
			    
			    
			    
	       System.out.println(min);
		
		
	}
}