import java.util.Scanner;

public class Main {
	
	static int[] memo = new int[45];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			if (isPrime(a)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static boolean isPrime(int a) {
		if (a <= 1) return false;
		
		if (a != 2 && a%2 == 0) return false;
		
		int max = (int) Math.sqrt(a)+1;
		for (int i = 3; i < max; i++) {
			if (a%i == 0) return false;
		}
		return true;
	}
}

