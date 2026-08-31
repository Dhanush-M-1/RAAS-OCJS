import java.io.*;
import java.util.*;

public class cool {
	public static void main(String args[]) {
		Scanner in;
		try {
			in = new Scanner(new File("input.txt"));
		}
		catch (Exception e) {
			in = new Scanner(System.in);
		}
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		long[] b = new long[n - 1];
		for (int i = 0; i < n - 1; i++) {
			b[i] = in.nextInt();
		}
		long[] c = new long[n - 2];
		for (int i = 0; i < n - 2; i++) {
			c[i] = in.nextInt();
		}
		int tot = 0;
		for (int i = 0; i < n; i++) {
			tot += a[i];
		}
		int hi = 0;
		for (int i = 0; i < n - 1; i++) {
			hi += b[i];
		}
		int bye = 0;
		for (int i = 0; i < n - 2; i++) {
			bye += c[i];
		}

		System.out.println(tot - hi);
		System.out.println(hi - bye);
	}
}