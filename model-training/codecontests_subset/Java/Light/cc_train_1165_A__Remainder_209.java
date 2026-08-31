/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.lang.*;
import java.math.*;
public class Main
{
    static int xr(int x, int y) 
{ 
    return (x | y) &  
           (~x | ~y); 
} 
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int x=sc.nextInt();
	int y=sc.nextInt();
	String s=sc.next();
	char[]b=new char[x];
	String p=s.substring(s.length()-x,s.length());
	int count=0;
	if(p.charAt(p.length()-y-1)=='0')
	count++;
	for(int i=0;i<p.length();i++)
	{
	    if(i!=p.length()-y-1)
	    {
	        if(p.charAt(i)=='1')
	        count++;
	    }
	}
    
	// for(int i=0;i<b.length;i++)
	System.out.println(count);
	}
}
