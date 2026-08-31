import java.io.*;
import java.util.*;

public class CF990B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Integer[] aa = new Integer[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(aa);
		int ans = n;
		for (int i = 0, cnt = 1; i < n - 1; i++)
			if ((int) aa[i + 1] == (int) aa[i])
				cnt++;
			else {
				if (aa[i + 1] <= aa[i] + k)
					ans -= cnt;
				cnt = 1;
			}
		System.out.println(ans);
	}
}
