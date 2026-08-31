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
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		String num = sc.nextLine();
		num = num.substring(n - x, num.length());
		int cnt = 0;
		int t = num.length() - y - 1;
		for(int i = 0; i<num.length(); i++){
		    char c = num.charAt(i);
		    if(c == '0' && i == t)cnt++;
		    else if(c == '1' && i != t)cnt++;
		}
		out.println(cnt);
		out.flush();
	}
}
