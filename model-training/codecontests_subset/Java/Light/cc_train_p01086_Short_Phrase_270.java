import java.util.Scanner;

public class Main {
	static final int[] HAIKU = { 5, 7, 5, 7, 7 };

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				break;
			int[] w = new int[n];
			for (int i = 0; i < n; i++)
				w[i] = scan.next().length();

			int count = 1;
			int index = 0;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				int j = i;
				while (j < w.length) {
					sum += w[j];
					if (sum >= HAIKU[index])
						break;
					j++;
				}
				if (sum == HAIKU[index]) {
					i = j;
					index++;
				} else {
					i = count - 1;
					count++;
					index = 0;
				}
				if (index == HAIKU.length) {
					System.out.println(count);
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		new Main().run();
	}
}