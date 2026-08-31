import java.util.Scanner;

public class Meow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			sum += num;
		}
		int div = sum / 5;
		if (sum % 5.0 == 0 && sum > 0) {
			System.out.println((int) div);
		} else {
			System.out.println(-1);
		}

	}
}
