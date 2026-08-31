import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main{
	public static int[] arrayToInt(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static int parseo(String cad, int index) {
		return Integer.parseInt(cad.split(" ")[index]);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bufer = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.parseInt(bufer.readLine());

		if (n == 1 || n == 2) {System.out.println(n);return;}
		if (n % 2 != 0) {
			BigInteger res = BigInteger.valueOf(n)
					.multiply(BigInteger.valueOf(n - 1))
					.multiply(BigInteger.valueOf(n - 2));
			System.out.println(res);
		} else if (n % 2 == 0 && n % 3 != 0) {
			BigInteger res = BigInteger.valueOf(n)
					.multiply(BigInteger.valueOf(n - 1))
					.multiply(BigInteger.valueOf(n - 3));
			System.out.println(res);
		} else if (n % 2 == 0 && n % 3 == 0) {
			BigInteger res = BigInteger.valueOf(n - 1)
					.multiply(BigInteger.valueOf(n - 2))
					.multiply(BigInteger.valueOf(n - 3));
			System.out.println(res);
		}

	}

}
