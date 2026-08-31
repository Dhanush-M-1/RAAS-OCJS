
import java.util.*;
import java.math.*;
import java.io.*;

public class submitting {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int[] integers = new int[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			integers[i] = Integer.parseInt(st.nextToken());
		}

		int[] numDigits = new int[n];
		for (int i = 0; i < n; i++) {
			int tester = integers[i];
			while (tester > 0) {
				numDigits[i]++;
				tester /= 10;
			}
		}

		int[] countDigits = new int[10];
		for (int i = 0; i < n; i++) {
			countDigits[numDigits[i] - 1]++;
		}

		BigInteger x = BigInteger.valueOf(0);
		for (int i = 0; i < n; i++) {
			int[] digits = new int[numDigits[i]];
			for (int j = 0; j < numDigits[i]; j++) {
				digits[j] = integers[i] % 10;
				integers[i] = integers[i] / 10;
			}
			for (int j = 0; j < numDigits[i]; j++) {
				for (int k = 0; k < 10; k++) {
					if (k < j) {
						x = x.add(BigInteger.valueOf(2 * countDigits[k] * digits[j])
								.multiply(BigInteger.TEN.pow(k + j + 1)));
					} else {
						x = x.add(BigInteger.valueOf(11 * countDigits[k] * digits[j])
								.multiply(BigInteger.TEN.pow(2 * j)));
					}
				}
			}
		}

		System.out.println(x.mod(BigInteger.valueOf(998244353)).intValue());

		sc.close();
	}
}