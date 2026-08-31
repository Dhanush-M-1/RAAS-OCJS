/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<Integer> ();
		ArrayList<Integer> b=new ArrayList<Integer> ();
		int i;
		for(i=0;i<n;i++)
		a.add(sc.nextInt());
		for(i=0;i<n-1;i++)
		{
			if(a.get(i)>a.get(i+1))
			{
				if((a.get(i)-a.get(i+1)-k)>0)
			        b.add((a.get(i)-a.get(i+1)-k));
		}
		}
		if(b.size()==0)
		System.out.println("0");
		else
		System.out.println(Collections.max(b));
	}
}