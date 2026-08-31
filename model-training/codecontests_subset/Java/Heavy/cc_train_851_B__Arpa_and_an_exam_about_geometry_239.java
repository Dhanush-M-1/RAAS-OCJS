/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	  Scanner in = new Scanner(System.in);
	   long ax = in.nextLong();
	    long ay = in.nextLong();
		 long bx = in.nextLong();
		  long by = in.nextLong();
		   long cx = in.nextLong();
		    long cy = in.nextLong();
		     System.out.println(((bx - ax) * (cy - ay) == (cx - ax) * (by - ay)) || ((ax - bx) * (ax - bx) + (ay - by) * (ay - by) != (cx - bx) * (cx - bx) + (cy - by) * (cy - by)) ? "No" : "Yes");  
	}
}