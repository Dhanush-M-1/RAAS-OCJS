// practice with rainboy
import java.io.*;
import java.util.*;

public class CF893D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		int[] pp = new int[n];
		for (int i = 0, p = 0; i < n; i++)
			pp[i] = p += aa[i];
		int[] qq = new int[n];
		qq[n - 1] = pp[n - 1];
		for (int i = n - 2; i >= 0; i--)
			qq[i] = Math.max(pp[i], qq[i + 1]);
		if (qq[0] > d) {
			System.out.println(-1);
			return;
		}
		int sum = 0, cnt = 0;
		for (int i = 0, p = 0; i < n; i++) {
			int a = aa[i];
			if ((p += a) > d) {
				System.out.println(-1);
				return;
			}
			if (a == 0 && p < 0) {
				int r = d - qq[i] - sum;
				if ((p += r) < 0) {
					System.out.println(-1);
					return;
				}
				sum += r;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
