
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			int h = scanner.nextInt();
			int m = scanner.nextInt();
			int s = scanner.nextInt();
			if (h == -1 && m == -1 && s == -1) {
				break;
			}
			int sc = 7200 - (h * 3600 + m * 60 + s);
			int sc3 = sc * 3;
			System.out.println(String.format("%02d:%02d:%02d", sc / 3600,
					sc / 60 % 60, sc % 60));
			System.out.println(String.format("%02d:%02d:%02d", sc3 / 3600,
					sc3 / 60 % 60, sc3 % 60));
		}
	}
}