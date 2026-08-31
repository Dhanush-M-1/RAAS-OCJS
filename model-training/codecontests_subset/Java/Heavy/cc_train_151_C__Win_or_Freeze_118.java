import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long g = sc.nextLong();
		if (g == 1 || isPrime(g)) {
			System.out.println("1\n" + 0);
		} else {
			List<Long> list = primeFactors(g);
			boolean status = false;
			long num = 0;
			for (int i = list.size() - 1; !status && i >= 0; i--) {
				if (!isPrime(list.get(i))) {
					status = true;
					num = list.get(i);
				}
			}
			if (status) {
				System.out.println("1\n" + num);
			} else {
				System.out.println(2);
			}
		}
	}

	private static boolean isPrime(long g) {
		if (g == 1)
			return false;

		for (long i = 2; i <= Math.sqrt(g); i++)
			if (g % i == 0) {
				return false;
			}
		return true;
	}

	public static Vector<Long> primeFactors(long numbers) {
		long n = numbers;
		Vector<Long> factors = new Vector<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		Vector<Long> factors2 = new Vector<Long>();
		for (int i = factors.size() - 1; i >= 0; i--) {
			long first = factors.get(i);
			for (int j = factors.size() - 1; j >= 0; j--)
				if (i != j) {
					long mul = first * factors.get(j);
					if (mul < numbers) {
						factors2.add(mul);
					}
				}
		}
		for (int i = 0; i < factors2.size(); i++)
			factors.add(factors2.get(i));

		return factors;
	}
}
