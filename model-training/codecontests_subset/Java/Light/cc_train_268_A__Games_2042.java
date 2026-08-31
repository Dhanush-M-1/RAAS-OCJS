import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int gust[] = new int[101];

		int[] home = new int[n];

		for (int i = 0; i < n; i++) {

			int c1 = in.nextInt();
			int c2 = in.nextInt();

			home[i] = c1;

			if (gust[c2] >= 1)
				gust[c2] = gust[c2] + 1;
			else
				gust[c2] = 1;

		}

		int s = 0;
		for (int i = 0; i < n; i++) {
			s += gust[home[i]];

		}

		System.out.println(s);

	}
}
