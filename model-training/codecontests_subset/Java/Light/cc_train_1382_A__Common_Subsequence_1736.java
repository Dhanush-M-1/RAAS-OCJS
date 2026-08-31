import java.util.*;
import java.io.*;

public class CommonSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		outer: for (int t = 0; t < T; t++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			str = new StringTokenizer(br.readLine());
			boolean[] arr1 = new boolean[10000];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(str.nextToken());
				arr1[x] = true;
			}
			str = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int x = Integer.parseInt(str.nextToken());
				if (arr1[x]) {
					System.out.println("YES");
					System.out.println("1 " + x);
					continue outer;
				}
			}
			System.out.println("NO");
		}
	}
}
