import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] e = new int[n];
		for (int i = 0; i < n; i++)
			e[i] = scan.nextInt();

		int r = 0;
		for (int i = 0; i < n; i++)
			if (isPrime(e[i]))
				r++;
		System.out.println(r);

		scan.close();
		System.exit(0);
	}

	private static boolean isPrime(int x) {
		double max=Math.sqrt(x);
		for (int i = 2; i <= max; i++)
			if (x % i == 0)
				return false;
		return true;
	}
}