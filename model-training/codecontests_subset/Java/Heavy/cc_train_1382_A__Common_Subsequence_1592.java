import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TaskA {

	private static Scanner in = new Scanner(System.in);
	private static PrintWriter w = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t1 = Integer.parseInt(in.nextLine());
		outer: while (t1-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i<n; i++)
				set.add(in.nextInt());
			int ans = -1;
			for(int j = 0; j<m; j++) {
				int temp = in.nextInt();
				if(set.contains(temp)) {
					ans = temp;
				}
			}
			w.println(ans==-1? "NO" : ("YES\n" + 1 + " " + ans));
		}
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