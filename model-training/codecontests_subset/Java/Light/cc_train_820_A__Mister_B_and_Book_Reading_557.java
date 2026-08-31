/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ar[]=br.readLine().split(" ");
		int c=Integer.parseInt(ar[0]);
		int v0=Integer.parseInt(ar[1]);
		int v1=Integer.parseInt(ar[2]);
		int a=Integer.parseInt(ar[3]);
		int l=Integer.parseInt(ar[4]);
		int x=0;
		int days=0;
		int k=v0-l;
		while(c>x){
			if(days==0){
				x=x+v0;
			}else{
				x=x+Math.min(k+a*days,v1-l);
			}
			days++;
		}
		System.out.println(days);
	}
}