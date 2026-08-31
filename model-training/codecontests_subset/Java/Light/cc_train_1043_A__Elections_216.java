import java.util.Arrays;
import java.util.Scanner;

public class Elections {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		if (n == 1)
			System.out.println(2 * a[0]+1);
		else {
			Arrays.sort(a);
			int max = a[n - 1];
			int sum = 0;
			int res = 0;
			for (int i = 0; i < n; i++) {
				sum += a[i];
				res += max - a[i];
			}
			while (res <= sum) {
				res += n;
				max++;
			}
			System.out.println(max);
		}
	}
}