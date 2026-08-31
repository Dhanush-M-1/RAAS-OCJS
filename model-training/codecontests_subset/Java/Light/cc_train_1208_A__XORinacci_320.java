

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Solove solove = new Solove();
		solove.main(in);
	}

}

class Solove {

	public void main(Scanner in) {
		int q = in.nextInt();

		while (q-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int other = a ^ b;
			int n = in.nextInt();
			if (n % 3 == 0) {
				System.out.println(a);
			} else if (n % 3 == 1) {
				System.out.println(b);
			} else {
				System.out.println(other);
			}
		}
	}
}
