import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String inp[] = sc.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);
		inp = sc.readLine().split(" ");
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(inp[i]);
		}

		int temp = 1;

		while (k > temp) {
			k = k - temp;
			temp++;
		}
		System.out.println(a[k-1]);
	}
}