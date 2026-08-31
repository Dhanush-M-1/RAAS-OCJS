import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationTable {

	public static int conv(int num, int base) {
		String ans = "";
		while (num != 0) {
			ans = (num % base) + ans;
			num /= base;
		}
		return Integer.parseInt(ans);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		int[][] ans = new int[k - 1][k - 1];
		for (int i = 0; i < k - 1; i++) {
			ans[0][i] = (i + 1);
			ans[i][0] = (i + 1);
		}
		for (int i = 1; i < k - 1; i++) {
			for (int j = 1; j < k - 1; j++) {
				int tmp = ans[0][j] * ans[i][0];
				ans[i][j] = conv(tmp, k);
			}
		}

		for (int i = 0; i < k - 1; i++) {
			for (int j = 0; j < k - 1; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
