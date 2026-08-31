import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int l = sc.nextInt();
			if (l == 0) {
				break;
			}
			int month = -1;
			int sum = 0;
			for (int i = 1; i <= 12; i++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				sum += n - m;
				if (l <= sum && month < 0) {
					month = i;
				}
			}
			if (month < 0) {
				System.out.println("NA");
			} else {
				System.out.println(month);
			}
		}
	}
}