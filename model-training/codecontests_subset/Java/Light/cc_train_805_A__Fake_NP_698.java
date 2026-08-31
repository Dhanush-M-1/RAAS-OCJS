import java.util.Scanner;

public class FakeNP {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();

		if (l == r) {
			System.out.print(l);
		} else {
			System.out.print(2);
		}

		sc.close();
	}
}
