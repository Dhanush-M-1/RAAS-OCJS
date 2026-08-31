import java.util.Scanner;
import java.lang.Math;

// ALDS1_1_C
public class Main {
	boolean primeJudge(int a) {
		double sqrt = Math.sqrt(a) + 1;
		if (a < 2) return false;
		if (a == 2) return true;
		if (a % 2 == 0) return false;
		for (int i = 3; i < sqrt; i+=2) {
			if (a % i == 0) return false;
		}
		return true;
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (primeJudge(sc.nextInt())) count++;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
