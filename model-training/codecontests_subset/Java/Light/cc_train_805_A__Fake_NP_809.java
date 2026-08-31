import java.util.Scanner;

public class FakeNP {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int l = scanner.nextInt();
		int r = scanner.nextInt();
		if (l == r) {
			System.out.println(r);
			return;
		} else {
			System.out.println(2);
		}
	}
}