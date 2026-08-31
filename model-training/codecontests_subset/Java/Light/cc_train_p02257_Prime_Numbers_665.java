import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(isPrime(scan.nextInt())) {
				cnt++;
			}
		}
		scan.close();
		System.out.println(cnt);
	}
	static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		if(n % 2 == 0) {
			return false;
		}
		for(int i = 3; i <= (int)Math.sqrt(n); i+= 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
