import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int n, i, result = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] colors = new int[n * 2];
		for (i = 0; i < n * 2; i += 2) {
			colors[i] = sc.nextInt();
			colors[i + 1] = sc.nextInt();
		}
		for (i = 0; i < n * 2; i += 2) {
			for (int j = 0; j < n * 2; j += 2) {
				if (i == j)
					continue;
				if (colors[i + 1] == colors[j])
					result++;

			}
		}
		System.out.println(result);
	}
}