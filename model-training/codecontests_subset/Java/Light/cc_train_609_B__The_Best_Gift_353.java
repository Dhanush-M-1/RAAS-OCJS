import java.util.Scanner;

public class Gift {
		static Scanner stdin = new Scanner(System.in);
	public static void main(String[] args) {
		int n = stdin.nextInt();
		int m = stdin.nextInt();
		int temp;
		int[] genre = new int[m + 1];
		for (int i = 0; i < n; i++) {
			temp = stdin.nextInt();
			genre[temp]++;
		}
		
		int result = 0;
		for (int i = 1; i <= m - 1; i++) {
			for (int j = i + 1; j <= m; j++) {
				result += genre[i] * genre[j];
				// System.out.println(result);
			}
		}
		
		System.out.println(result);
	}
}
