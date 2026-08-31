/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Name of the class has to be "Main" only if the class is public. */
public class main
{
	public static void main (String[] args) throws IOException
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		String line1=br.readLine();
		int a=Integer.parseInt(line);
		int b=Integer.parseInt(line1);
		int m=(a+b)/2;
		int sum=0;
		if(a<=b){
		for(int i=a;i<=m;i++){
			sum=sum+i-a;
		}
		for(int i=m;i<=b;i++){
			sum=sum+i-m;
		}
		}
		else{
		    for(int i=b;i<=m;i++){
			sum=sum+i-b;
		}
		for(int i=m;i<=a;i++){
			sum=sum+i-m;
		}
		}
		System.out.println(sum);
	}
}