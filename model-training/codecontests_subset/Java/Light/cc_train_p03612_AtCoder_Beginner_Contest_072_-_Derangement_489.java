import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = 0;
		int flagNum = 0;
		Boolean flag = false;

		for (int i = 1; i <= n; i++) {

			int m = sc.nextInt();

			// System.out.println("i: " + i + ", m=" + m);

			if (m == i) {
				if (flagNum == m - 1 && flag) {
					flag = false;
					continue;
				}
				count++;
				flagNum = i;
				flag = true;
				continue;
			}
			flag = false;

		}

		System.out.println(count);

		sc.close();

	}

}
