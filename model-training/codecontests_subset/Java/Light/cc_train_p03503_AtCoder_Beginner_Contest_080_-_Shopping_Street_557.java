import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int f[][] = new int[n][10];
		int p[][] = new int[n][11];

		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");

			for (int j = 0; j < 10; j++) {
				f[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");

			for (int j = 0; j < 11; j++) {
				p[i][j] = Integer.parseInt(str[j]);
			}
		}

		long ans = Long.MIN_VALUE;
		for (int bit = 0; bit < Math.pow(2, 10); bit++) {
			boolean flag[] = new boolean[10];

			boolean tf = false;
			for (int i = 0; i < 10; i++) {
				if ((bit & (1 << i)) != 0) {
					flag[i] = true;
					tf = true;
				}
			}

			if (!tf) {
				continue;
			}

			long sum = 0;
			for (int i = 0; i < n; i++) {
				int count = 0;
				for (int j = 0; j < 10; j++) {
					if (!flag[j])
						continue;
					if (f[i][j] == 1) {
						count++;
					}
				}
				sum += p[i][count];
			}
			ans = Math.max(ans, sum);
		}

		System.out.println(ans);
	}
}
