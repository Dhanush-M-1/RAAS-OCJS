/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int cantidad=sc.nextInt();
		char vec[] = sc.next().toCharArray();
		int c,c2;
		c = c2 =0;
		
		for(int i =0;i<cantidad;i++){
			if(vec[i]=='A')c++;
			if(vec[i]=='I')c2++;
		}
		if(c2==0)
		System.out.println(c);
		else if(c2==1)
		System.out.println(1);
		else 
		System.out.println(0);
	}
}