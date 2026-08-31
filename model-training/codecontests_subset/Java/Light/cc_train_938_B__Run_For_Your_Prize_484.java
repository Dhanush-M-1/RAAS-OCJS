import java.io.*;
import java.util.*;

public class CF938B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 1, b = 1000000;
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		int ans = Math.min(aa[n - 1] - a, b - aa[0]);
		for (int i = 1; i < n; i++)
			ans = Math.min(ans, Math.max(aa[i - 1] - a, b - aa[i]));
		System.out.println(ans);
	}
}
