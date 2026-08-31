import java.util.Scanner;

public class Main {

	public static boolean checkPrimeNum(int x) {
		int border = (int)Math.sqrt(x) + 1;

		for(int i = 2; i < border; i++) {
			if(x % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int x;
		int count = 0;

		for(int i = 0; i < num; i++) {
			x = scan.nextInt();
			if(checkPrimeNum(x)) {
				count++;
			}
		}

		System.out.println(count);

	}
}

