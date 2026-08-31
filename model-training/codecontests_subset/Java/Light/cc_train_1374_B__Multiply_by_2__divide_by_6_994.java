import java.io.*;

public class P1374B_MultiplyBy2DivideBy6 {
	public static void main(String[] subhani) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			solution(n);
		}
	}

	public static void solution(int n) {
		int moves = 0;
		while (n > 1) {
			if (n % 6 == 0)
				n /= 6;
			else
				n *= 2;
			moves++;
		}
		if (n == 1)
			System.out.println(moves);
		else
			System.out.println(-1);
	}
}