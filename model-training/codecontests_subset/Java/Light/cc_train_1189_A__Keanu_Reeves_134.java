/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner AA = new Scanner(System.in);
		int N= AA.nextInt();
		String C =AA.next();
		char[] c_arr = C.toCharArray();
		int num_0=0;
		int num_1=0;
		
		for(int i=0;i<N;i++){
			if(c_arr[i]=='1'){
				num_1++;	
			}
			else{
				num_0++;
			}
		}
		if(num_1!=num_0){
			System.out.println("1");
			System.out.println(C);
		}
		else{
			System.out.println("2");
			System.out.print(c_arr[0]+" ");
			for(int i=1;i<N;i++){
				System.out.print(c_arr[i]);
			}
			System.out.println();
		}
		
	}
}