import java.io.*;
import java.util.*;

public class CF664B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] minus = new boolean[100];
		st.nextToken();
		int n = 0;
		int k = 1, kp = 1, km = 0;
		while (true) {
			String op = st.nextToken();
			if (op.equals("=")) {
				n = Integer.parseInt(st.nextToken());
				break;
			}
			if ((minus[k++] = op.equals("-")))
				km++;
			else
				kp++;
			st.nextToken();
		}
		if (kp * 1 - km * n > n || kp * n - km * 1 < n) {
			System.out.println("Impossible");
			return;
		}
		int[] aa = new int[k];
		for (int i = 0; i < k; i++)
			aa[i] = minus[i] ? 1 : n;
		int sum = kp * n - km * 1;
		for (int i = 0; i < k; i++)
			if (sum > n) {
				int d = Math.min(sum - n, n - 1);
				sum -= d;
				if (minus[i])
					aa[i] += d;
				else
					aa[i] -= d;
			}
		StringBuilder sb = new StringBuilder();
		sb.append(aa[0]);
		for (int i = 1; i < k; i++)
			sb.append((minus[i] ? " - " : " + ") + aa[i]);
		sb.append(" = " + n);
		System.out.println("Possible");
		System.out.println(sb);
	}
}
