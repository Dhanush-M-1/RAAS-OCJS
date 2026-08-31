import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int vals[] = new int[n];

		for(int i = 0; i < vals.length; i++) {
			vals[i] = sc.nextInt();
		}

		int count = 0;
		for(int i = 0; i < vals.length; i++) {
			if(isPrime(vals[i])) {
				count++;
			}
		}
		System.out.println(count);
		
	}

	public static boolean isPrime(int x) {
		if(x == 2) {
			return true;
		} else if(x < 2 || x % 2 == 0) {
			return false;
		} else {
			int i = 3;
			while(i <= Math.sqrt(x)) {
				if(x % i == 0) {
					return false;
				}
				i += 2;
			}
			return true;
		}
	}
}

