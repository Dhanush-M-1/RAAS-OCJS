import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BestGift {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] book = new int[n];
		int[] bucket = new int[m + 1];
		int[] res = new int[m + 1];
		long ans = 0;
		for (int i = 0; i <= n - 1; ++i) {
			book[i] = scanner.nextInt();
			bucket[book[i]]++;
		}
		res[res.length - 1] = bucket[bucket.length - 1];
		for (int i = bucket.length - 2; i >= 2; --i) {
			res[i] = res[i + 1] + bucket[i];
		}
		// System.out.println(Arrays.toString(bucket));
		// System.out.println(Arrays.toString(res));
		for (int i = 1; i <= bucket.length - 2; ++i) {
			ans = ans + (bucket[i] * res[i + 1]);
		}
		writer.print(ans);
		writer.flush();
		scanner.close();
	}
}
