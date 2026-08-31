/*package whatever //do not write package name here */

import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = 0;
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n - 1];
		for(int i = 0;i < n;i++)
		a[i] = sc.nextInt();
		for(int i = 0;i < n;i++)
		b[i] = sc.nextInt();
		for(int i = 0;i < n - 1;i++)
		c[i] = sc.nextInt();
		s += b[a[0] - 1];
		for(int i = 1;i < n;i++)
		{
		    s += b[a[i] - 1];
		    if(a[i] - a[i - 1] == 1)
		    s += c[a[i] - 2];
		}
		System.out.println(s);
	}
}