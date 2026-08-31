import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForcesA {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int ar[] = new int[n];
		boolean pos[] = new boolean[1000000];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			pos[ar[i]] = true;
		}

		int minn = 10000000;
		int maxx = -1;

		int l = 1;
		int r = 1000000;
		for (int i = 2; i <= 1000000 - 1; i++) {
			if (pos[i]) {
				int min = Math.min(i - 1, 1000000 - i);
				if (min > maxx)
					maxx = min;
			}
		}

		System.out.println(maxx);

	}

}
