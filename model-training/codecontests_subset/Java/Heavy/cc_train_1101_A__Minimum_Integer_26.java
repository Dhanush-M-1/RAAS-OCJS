/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	try {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    while(t-->0){
	        String s[]=br.readLine().split(" ");
	        int l=Integer.parseInt(s[0]);
	        int r=Integer.parseInt(s[1]);
	        int d=Integer.parseInt(s[2]);
	        
	        int ans=0;
	        boolean flag=false;
	        if(d>r || d<l)
	            System.out.println(d);
	        else{
	            System.out.println((r/d+1)*d);
	        }
	       
	    }
	} catch(Exception e) {
	return;}
	}
}
