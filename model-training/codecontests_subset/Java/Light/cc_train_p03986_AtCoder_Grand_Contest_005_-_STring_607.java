import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String X = sc.next();
		sc.close();

		int min = 0;
		int cur = 0;
		for (int i = 0; i < X.length(); i++) {
			switch (X.charAt(i)) {
			case 'S':
				cur++;
				break;
			case 'T':
				cur--;
				min = Math.min(min, cur);
				break;

			default:
				break;
			}
		}

		System.out.println(-min * 2);
	}
}
