import java.util.Scanner;


public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int prime = 0;
		for (int i = 0; i < n; i++) {
			int p = scan.nextInt();
			if(is_prime(p)) prime += 1;
		}
		System.out.println(prime);
	}
	boolean is_prime(int p) {
		if (p == 2) return true;
		if (p < 2 || (p&1) == 0) return false;
		int i = 3;
		while (i <= Math.sqrt(p)) {
			if (p % i == 0) return false;
			i = i + 2;
		}
		return true;
	}
	public static void main(String[] args) {
		new Main().run();
	}
}