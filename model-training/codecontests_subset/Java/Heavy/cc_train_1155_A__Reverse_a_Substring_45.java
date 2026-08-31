/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int len = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		char arr[] = s.toCharArray();
		Arrays.sort(arr);
		for(int i = len - 1; i >= 0; i--){
		    if(arr[i] != s.charAt(i)){
		        out.println("YES");
		        out.println((s.indexOf(arr[i]) + 1) + " " + (i + 1));
		        out.flush();
		        return;
		    }
		}
		out.println("NO");
		out.flush();
	}
}
