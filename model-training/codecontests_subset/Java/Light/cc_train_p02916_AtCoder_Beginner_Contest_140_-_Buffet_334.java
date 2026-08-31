
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int b = 0;
			int[] c = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b += sc.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				c[i] = sc.nextInt();
			}

			int result = 0;
			int before = -50;
			for(int num : a) {
				if(num - before == 1) {
					result += c[before - 1];
				}
				before = num;
			}

			System.out.println(result + b);
		}
	}
}
