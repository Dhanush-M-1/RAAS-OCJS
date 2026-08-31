/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(bf.readLine());
	while(t-->0)
	{
	    String []s=bf.readLine().split(" ");
	    int n=Integer.parseInt(s[0]);
	    int m=Integer.parseInt(s[1]);
	    String s1=bf.readLine();
	    String []s2=bf.readLine().split(" ");
	    int arr[]=new int[26];
	    int sang[]=new int[n];
	    for(int i=0;i<m;i++)
	    {
	        int min=Integer.parseInt(s2[i]);
	        sang[min-1]++;
	    }
	    for(int i=n-2;i>=0;i--)
	    {
	        sang[i]+=sang[i+1];
	    }
	    
	    for(int i=0;i<s1.length();i++)
	    {
	        int r=s1.charAt(i);
	        arr[r-'a']+=1+sang[i];
	    }
	    
	    for(int z=0;z<26;z++)
	    {
	        System.out.print(arr[z]+" ");
	    }
	  System.out.print("\n"); 
	}
	
	}
}