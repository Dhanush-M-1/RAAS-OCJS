/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

public class GFG {
    
    
	public static void main (String[] args) {
		//System.out.println("GfG!");
		
		Scanner sc=new Scanner(System.in);
		
		int q=sc.nextInt();
		for(int j=0;j<q;j++)
		{
		    int l=sc.nextInt();
		    int r=sc.nextInt();
		    int d=sc.nextInt();
		    
		    if(d<l || d>r)
		    {
		        System.out.println(d);
		    }
		    else
		    {
		        int x=(r/d+1)*d;
		        System.out.println(x);
		    }
		}
		
		
	}
}