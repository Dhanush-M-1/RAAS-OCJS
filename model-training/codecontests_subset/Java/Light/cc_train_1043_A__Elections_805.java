import java.util.Scanner;

public class Elections_1043A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int sum = 0, max = 0;
		for (int i = 0; i < n; i++) {
			int num = input.nextInt();
			sum += num;
			if (num > max) {
				max = num;
			}
		}
		System.out.println(Math.max(max, (2 * sum / n) + 1));
		input.close();
	}
}