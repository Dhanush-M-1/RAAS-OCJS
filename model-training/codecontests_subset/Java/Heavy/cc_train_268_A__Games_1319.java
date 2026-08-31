/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scan =new Scanner(System.in);
	    int n =scan.nextInt();
	    int[][] ar=new int[n][2];
	    int ans=0;
	    int[] kr=new int[101];
	    int[] asr=new int[101];
	  
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<2;j++)
	        {
	            ar[i][j]=scan.nextInt();
	        }
	    }
	    for(int i =0;i<n;i++)
	    {
	        kr[ar[i][0]]++;
	        
	    }
	
	    for(int i =0;i<n;i++)
	    {
	        asr[ar[i][1]]++;
	        
	    }
	    for(int i=0;i<101;i++)
	    {
	        if(kr[i]>0&&asr[i]>0)
	        {
	            ans+=kr[i]*asr[i];
	        }
	    }
	    System.out.print(ans);
	    
	}
}
