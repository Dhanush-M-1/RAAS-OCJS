import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(isPrime(a)) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isPrime(int a) {
		if(a == 2) {
			return(true);
		} else if(a < 2 || a % 2 ==0) {
			return(false);
		} else {
			for(int i = 3; i <= Math.sqrt(a); i++) {
				if(a % i == 0) {
					return(false);
				}
			}
			return(true);
		}
	}
}

