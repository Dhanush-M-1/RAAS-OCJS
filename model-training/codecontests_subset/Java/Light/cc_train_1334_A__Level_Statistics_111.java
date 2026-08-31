import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem85A {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());


			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer aT = new StringTokenizer(reader.readLine());
				a[i] = Integer.parseInt(aT.nextToken());
				b[i] = Integer.parseInt(aT.nextToken());
			}

			boolean correct = true;
			for (int i = 0; i < n; i++) {
				if (b[i] > a[i]) {
					correct = false;
					break;
				}
			}
			if (correct) {
				for (int i = 1; i < n; i++) {
					int playDiff = a[i] - a[i - 1];
					int clearDiff = b[i] - b[i - 1];

					if (playDiff < 0 || clearDiff < 0) {
						correct = false;
						break;
					}
					if (clearDiff > playDiff) {
						correct = false;
						break;
					}
				}
			}
			writer.println(correct ? "YES" : "NO");


		}

		reader.close();
		writer.close();
	}
}
