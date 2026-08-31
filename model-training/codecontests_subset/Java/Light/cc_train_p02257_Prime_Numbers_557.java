import java.util.Scanner;


public final class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		
		int count=0;
		for (int i=0;i<n;i++) {
			if (isPrime(scan.nextInt()))count++;
		}
		System.out.println(count);
	}
	static boolean isPrime(int n) {
		if (n<2) return false;
		for (int i=2;i*i<=n;i++) {
			if (n%i==0) return false;
		}
		return true;
	}
}