/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(input.readLine());
			int pp = 0;
			int pc = 0;
			boolean res = true;
			for(int j=0;j<n;j++) {
				String[] s = input.readLine().split(" ");
				int p = Integer.parseInt(s[0]);
				int c = Integer.parseInt(s[1]);
				if(p-pp<c-pc||p<c||p-pp<0||c-pc<0) {
					res = false;
				}
				pp = p;
				pc = c;
			}
			if(res==true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}