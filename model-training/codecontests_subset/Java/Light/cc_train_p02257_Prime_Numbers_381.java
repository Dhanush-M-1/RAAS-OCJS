import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int count = 0;
		for (int i = 0; i < n; i++) {
			int v = scn.nextInt();
			boolean bol = true;
			if (v == 2) {
				count++;
				continue;
			} else if (v % 2 == 0) {
				continue;
			}
			for (int j = 3; j <= Math.sqrt((double)v); j++) {
				if (v % j == 0) {
					bol = false;
					break;
				}
			}
			if (bol) {
				count++;
			}
		}
		System.out.println(count);
	}
}

