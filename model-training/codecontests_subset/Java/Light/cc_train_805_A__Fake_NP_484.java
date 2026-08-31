import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		if (r - l == 0) {
			System.out.println(l);
		} else if (r - l > 100) {
			System.out.println(2);
		} else {
			int twos = 0;
			int threes = 0;
			for (int i = l; i <= r; i++) {
				if (i % 2 == 0)
					twos++;
				if (i % 3 == 0)
					threes++;
			}
			if (twos > threes)
				System.out.println(2);
			else
				System.out.println(3);

		}

	}
}
