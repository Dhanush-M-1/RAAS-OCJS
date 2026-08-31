import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(isPrimeNum(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// 素数判定
	public static boolean isPrimeNum(int n) {
		if(n == 2) {
			return true;
		}
		if(n < 2 || n % 2 == 0) {
			return false;
		}
		for(int i = 3; i <= Math.sqrt(n); i += 2) { //「合成数xはp<=√xを満たす素因子pをもつ」
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
