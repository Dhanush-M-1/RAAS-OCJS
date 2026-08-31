/* package whatever; // don't place package name! */

import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class classb
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int []arr=new int [3];
		for(int i=0;i<3;++i)arr[i]=0;
		String s=sc.next();
		for(int i=0;i<n;++i){
			if(s.charAt(i)=='A')
				arr[0]++;
			else if(s.charAt(i)=='F')
				arr[1]++;
			else
				arr[2]++;
		}
		int ans=0;
		if(arr[2]<2){
			ans+=arr[2];
			if(arr[2]==0)
			ans+=arr[0];
			
		}
		System.out.println(ans);
		
	}
}