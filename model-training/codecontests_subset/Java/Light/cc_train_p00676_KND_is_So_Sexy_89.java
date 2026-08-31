import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int l = sc.nextInt();
			int x = sc.nextInt();
			double b = (l + x) / 2.0;
			double h = Math.sqrt(b * b - l * l / 4.0);
			double h2 = Math.sqrt(l * l - a * a / 4.0);
			System.out.println(l * h + a * h2 / 2.0);
		}
	}
}