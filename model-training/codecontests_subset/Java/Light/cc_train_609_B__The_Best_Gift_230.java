import java.io.*;
import java.util.*;

public class CF609B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] cc = new int[m];
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken()) - 1;
			cc[a]++;
		}
		int sum = 0;
		for (int i = 0; i < m; i++)
			for (int j = i + 1; j < m; j++)
				sum += cc[i] * cc[j];
		System.out.println(sum);
	}
}
