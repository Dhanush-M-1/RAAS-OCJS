import java.io.IOException;
import java.util.Scanner;

public class AAA {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int perc = sc.nextInt();
		int req = (int) Math.ceil((perc / 100.0) * n);
		if (req - x > 0)
			System.out.println(req - x);
		else
			System.out.println(0);
	}
}
