import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int count = 0;
		ArrayList<Integer> primeAr = new ArrayList<Integer>();
		
		for (int i = 0; i < length; i++) {
			int num = sc.nextInt();
			if (!primeAr.contains(num) && isPrime(num)) {
				count++;
				primeAr.add(num);
			}
		}
		System.out.println(count);
	}
	
	public static boolean isPrime(int i) {
		
		boolean prime = true;
		for (int j = 2; j <= Math.pow(i, 0.5); j++) {
			if (i % j == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}