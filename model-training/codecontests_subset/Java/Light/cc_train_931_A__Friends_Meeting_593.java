import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A931 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		int aasdf = scan.nextInt();
		int basdf = scan.nextInt();
		int a = Math.min(aasdf, basdf);
		int b = Math.max(aasdf, basdf);
		int n = b - a;
		if (n % 2 == 0) {
			int c = 0;
			for (int i = 0; i < n / 2; i++) {
				c += i + 1;
			}
			System.out.println(c * 2);
		} else {
			int c = 0;
			for (int i = 0; i < n / 2; i++) {
				c += i + 1;
			}
			System.out.println(c * 2 + n / 2 + 1);
		}
	}

}