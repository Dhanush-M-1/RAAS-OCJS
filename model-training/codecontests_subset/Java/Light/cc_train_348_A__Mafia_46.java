import java.io.*;
import java.util.*;

public class CF349C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] aa = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += aa[i];
			if (max < aa[i])
				max = aa[i];
		}
		long r = (sum + n - 2) / (n - 1);	// ceiling of sum / (n - 1)
		if (r < max)
			r = max;
		System.out.println(r);
	}
}
