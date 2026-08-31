/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		String s = scan.next();
		char [] charArray = s.toCharArray();
		int [] array = new int[n];
		for(int i=0; i<n; i++){
			array[i] = (int)charArray[i]-48;
		}
		int counter=0;
		for(int i=0;i<x;i++){
			if(i==y){
				if(array[n - i -1] != 1){
					counter++;
				}
			}
			else{
				if(array[n - i -1] != 0){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}