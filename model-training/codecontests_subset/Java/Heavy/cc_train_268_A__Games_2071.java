/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;


public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		
		for(int i=0;i<n;i++) {
		    a[i] = sc.nextInt();
		    b[i] = sc.nextInt();
		}
		
		int count=0;
		
		
		for(int i=0;i<n;i++) {
		    for(int j=0;j<n;j++) {
		        if(i!=j && a[i]==b[j])
		        {
		            count++;
		        }
		    }
		}
		
		System.out.println(count);
		
	}
}
