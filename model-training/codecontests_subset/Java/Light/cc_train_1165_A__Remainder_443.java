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
		int x = s.nextInt();
		int y = s.nextInt();
		s.nextLine();
		String val = s.nextLine();
		int ans = 0;
		for(int i=n-1;i>=n-x;i--){
			char c = val.charAt(i);
			if (i == n-y-1) {
				if (c == '0')
					ans++;
			}
			else if (c == '1')
				ans++;
		}
		System.out.println(ans);
	}
}