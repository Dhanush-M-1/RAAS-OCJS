import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			num[i]  = scan.nextInt();
		}

		int count = 0;
		
		for (int i = 0; i < n; i++) {
			if (num[i] % 2 == 0 && num[i] > 2) continue;
			boolean isPrime = true;
			for (int j = 3; j * j <= num[i]; j += 2) {
				if (num[i] % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) count++;
		}
		
		System.out.println(count);
		scan.close();
	}

}