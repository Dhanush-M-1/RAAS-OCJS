/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		boolean[] arr = new boolean[m];
		
		for(int i=0 ;i<m ; i++ )
			arr[i] = false;
	
		for(int i=0 ; i<n ;i++){
			int num = s.nextInt();
			for(int j=0 ; j<num ; j++){
				arr[s.nextInt()-1] = true;
			}
		}
		boolean flag = true;
		
		for(int i=0 ; i<m ;i++){
			if(!arr[i]){
				flag = false;
				break;
			}
		}
		if(flag)
		System.out.println("YES");
		
		else
		System.out.println("NO");
	}
}