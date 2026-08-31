import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int R = sc.nextInt();
		int C = sc.nextInt();
		int Y1 = sc.nextInt();
		int X1 = sc.nextInt();
		int Y2 = sc.nextInt();
		int X2 = sc.nextInt();
		int h = Math.abs(Y2 - Y1);
		h = Math.min(h, R - h);
		int w = Math.abs(X2 - X1);
		w = Math.min(w, C - w);
		BigInteger ans = BigInteger.ONE;
		for (int i = 0; i < h; ++i) {
			ans = ans.multiply(BigInteger.valueOf(h + w - i)).divide(BigInteger.valueOf(i + 1));
		}
		if (h * 2 == R) {
			ans = ans.shiftLeft(1);
		}
		if (w * 2 == C) {
			ans = ans.shiftLeft(1);
		}
		System.out.println(ans.mod(BigInteger.valueOf(100000007)));
	}

}