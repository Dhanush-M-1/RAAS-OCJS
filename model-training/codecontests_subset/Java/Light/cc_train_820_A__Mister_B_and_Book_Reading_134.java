import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		int v0 = input.nextInt();
		int v1 = input.nextInt();
		int a = input.nextInt();
		int l = input.nextInt();
		int j = 0, k = 0, i = 0;
		while (i < c) {
			if (v0 + a * j > v1) {
				i += v1;
			} else {
				i += (v0 + a * j);

			}
			k++;
			j++;
			if (i >= c) {
				break;
			}
			i -= l;

		}
		System.out.println(k);
	}
}
