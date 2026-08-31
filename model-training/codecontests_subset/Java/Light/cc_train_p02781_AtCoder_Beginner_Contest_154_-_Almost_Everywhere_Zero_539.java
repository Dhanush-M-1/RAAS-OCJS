import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int k = sc.nextInt();
		sc.close();

		int[] numbers = IntStream.range(0, n.length()).map(i -> Integer.parseInt(n.substring(i, i + 1))).toArray();
		int[][] c1 = new int[n.length()][Math.max(k, n.length()) + 1];
		int[][] c2 = new int[n.length()][Math.max(k, n.length()) + 1];

		c1[0][0] = 1;
		c1[0][1] = numbers[0] - 1;
		c2[0][1] = 1;
		for (int i = 1; i < n.length(); i++) {
			for (int j = 0; j < n.length(); j++) {
				if (numbers[i] == 0) {
					c1[i][j] += c1[i - 1][j];
					c1[i][j + 1] += c1[i - 1][j] * 9;
					c2[i][j] += c2[i - 1][j];
				} else {
					c1[i][j] += c1[i - 1][j] + c2[i - 1][j];
					c1[i][j + 1] += c1[i - 1][j] * 9 + c2[i - 1][j] * (numbers[i] - 1);
					c2[i][j + 1] += c2[i - 1][j];
				}
			}
		}

		System.out.println(c1[n.length() - 1][k] + c2[n.length() - 1][k]);
	}
}
