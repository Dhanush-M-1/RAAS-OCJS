/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class S {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		double a=in.nextDouble();
		double b=in.nextDouble();
		double c=in.nextDouble();
		
		if(a==0 && b==0 && c==0)
		{
		    System.out.println(-1);
		}
		else if(a==0 && b==0 && c!=0)
		{
		    System.out.println(0);
		}
		else if(a==0)
		{
		    System.out.println(1);
		    System.out.printf("%.10f\n",(-c*1.0)/b);
		}
		else if(((b*b)-(4*a*c))<0)
		{
		    System.out.println(0);
		}
	    else if(((b*b)-(4*a*c))==0)
	    {
	        System.out.println(1);
	        System.out.printf("%.10f\n",(double)(-b/(2*a)));
	    }
		else
		{
		    double z=Math.sqrt((double)((b*b)-(4*a*c)));
		    double x=(-b+z)/(2*a);
		    double y=(-b-z)/(2*a);
		    System.out.println(2);
		    if(x>y)
		    {
		        System.out.format("%.10f\n",y);
		        System.out.format("%.10f\n",x);
		    }
		    else
		    {
		        System.out.format("%.10f\n",x);
		        System.out.format("%.10f\n",y);
		    }
		    
		}
	}
}