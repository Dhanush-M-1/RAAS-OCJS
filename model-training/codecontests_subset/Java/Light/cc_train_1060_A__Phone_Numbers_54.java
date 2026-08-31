/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int m = s.length();
		int x = 0;
		for(int i = 0;i<m;i++){
			if(s.charAt(i)=='8'){
				x++;
			}
		}
		int ans = Math.min(x, m/11);
		System.out.println(ans);
	}
}