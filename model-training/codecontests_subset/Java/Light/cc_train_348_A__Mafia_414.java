import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C348C {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] s = bf.readLine().trim().split(" ");
		int[] a = new int[n];
		long sum = 0, max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
			sum += a[i]; if (max < a[i]) max = a[i];
		}
		long ans = sum / ( n - 1 ) + (sum % (n - 1) == 0 ? 0 : 1);
		System.out.println(Math.max(max, ans));
	}

}
