import java.io.PrintWriter;
import java.util.Scanner;

public class R85A {

	static PrintWriter output;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		output = new PrintWriter(System.out);
		int n = sc.nextInt();
		for (int i=0; i<n ;i++) {
			int times = sc.nextInt();
			int[][] pairs = new int[times][2];
			for (int j=0; j<times; j++) {
				pairs[j][0] = sc.nextInt();
				pairs[j][1] = sc.nextInt();
			}
			solve(times, pairs);
		}
		sc.close();
		output.close();
	}

	private static void solve(int times, int[][] pairs) {
		if (pairs[0][0] < pairs[0][1]) {
			output.write("NO\n");
			return;
		}
		for (int i=1; i<times; i++) {
			if (pairs[i][0] < pairs[i][1] || pairs[i][0] < pairs[i-1][0] || pairs[i][1] < pairs[i-1][1] ||
					(pairs[i][0]-pairs[i-1][0] < pairs[i][1]-pairs[i-1][1])) {
				output.write("NO\n");
				return;
			}
		}
		output.write("YES\n");
	}

}
