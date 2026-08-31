import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskA {

	private static Scanner in = new Scanner(System.in);
	private static PrintWriter w = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t1 = Integer.parseInt(in.nextLine());
//		outer: while (t1-- > 0) {
			String s = in.next();
			int a = -1, b = -1;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) > s.charAt(i + 1)) {
					a = i+1;
					b = i + 2;
					break;
				}
			}
			w.println(a == -1 ? "NO" : "YES\n" + a + " "+ b);
//		}
		w.flush();
		w.close();
	}

	private static void solve(int ind, String[] sArr, StringBuilder sb) {

	}

	private static void shuffleArray(int[] arr) {
		int n = arr.length;
		Random rnd = new Random();
		for (int i = 0; i < n; ++i) {
			int tmp = arr[i];
			int randomPos = rnd.nextInt(n);
			arr[i] = arr[randomPos];
			arr[randomPos] = tmp;
		}
	}

	private static void shuffleArray(long[] arr) {
		int n = arr.length;
		Random rnd = new Random();
		for (int i = 0; i < n; ++i) {
			long tmp = arr[i];
			int randomPos = i + rnd.nextInt(n - i);
			arr[i] = arr[randomPos];
			arr[randomPos] = tmp;
		}
	}
}