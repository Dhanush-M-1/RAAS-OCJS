import java.util.*;
import java.io.*;
 
public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] a = new long[n];
		long sum = 0;
		long max = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			sum += a[i];
			max = Math.max(max, a[i]);
		}
		System.out.println(Math.max((long) (sum + n - 2) / (long) (n-1), max));
	}
}