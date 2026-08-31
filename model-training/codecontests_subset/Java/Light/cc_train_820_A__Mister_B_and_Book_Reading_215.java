/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class practice
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner hb=new Scanner(System.in);
		PrintWriter w=new PrintWriter(System.out);
		
		int c=hb.nextInt();
		int v=hb.nextInt();
		int vmax=hb.nextInt();
		int a=hb.nextInt();
		int l=hb.nextInt();
		
		int count=1;
		int total=v;
		while(total<c)
		{
			total-=l;
			v=v+a;
			if(v>vmax)
				v=vmax;
			total+=v;
			count++;
		}
		w.print(count);
		w.close();
	}
}