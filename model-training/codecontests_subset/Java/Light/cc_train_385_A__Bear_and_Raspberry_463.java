/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class BearAndRaspberry
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		int n = sc.nextInt();
		int m = n;
		int[] arr = new int[m];
		int max = -10;
		int c = sc.nextInt();
	
			for(int i = 0 ;i < m ;i++){
				arr[i] = sc.nextInt();
			}
			for(int i = 0; i<m-1; i++){
				if(arr[i]-arr[i+1]>max){
					max = arr[i]-arr[i+1];
					a = arr[i];
					b = arr[i+1];
				}	
			}
		if((a-b-c)<0)
			System.out.println("0");
		else	
		System.out.println(a-b-c);
	}
}