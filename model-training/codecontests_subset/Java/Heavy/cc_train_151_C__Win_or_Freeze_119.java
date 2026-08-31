import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Error test 10
public class C {

	private void processInput() throws IOException {
		Scanner in = new Scanner(System.in);

		long q = in.nextLong();
		go(q);

		in.close();
	}

	private void go(long n) {

		if (n == 1 || isPrime(n)) {
			System.out.printf(Locale.ENGLISH, "%d\n%d\n", 1, 0);
			return;
		}

		List<Long> factors = factorize(n);

		if (factors.size() > 2) {
			long rr = n;
			for (int i = 0; i < factors.size() - 2; i++) {
				rr /= factors.get(i);
			}
			System.out.printf(Locale.ENGLISH, "1\n%d\n", rr);
		} else {
			System.out.printf(Locale.ENGLISH, "2\n");
		}
	}

    private boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}

		for (long i = 3; i*i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}


    public List<Long> factorize(long N) {

    	List<Long> list = new ArrayList<Long>();
		long tmp = N;
    	while (tmp % 2 == 0) {
    		list.add(2L);
    		tmp = tmp / 2;
    	}
		long i = 3;
		while (i * i <= tmp) {
			if (tmp % i == 0) {
				list.add(i);
				tmp = tmp / i;
			} else {
				i+=2;
			}
		}
		if (tmp != 1) {
			list.add(tmp);
		}
		return list;
    } 


	public static void main(String[] args) throws Exception {
		C a = new C();
		a.processInput();
	}
}