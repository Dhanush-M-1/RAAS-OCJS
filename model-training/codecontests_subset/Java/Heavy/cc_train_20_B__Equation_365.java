import java.util.Scanner;

public class CF_020B {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		long a = read.nextInt();
		long b = read.nextInt();
		long c = read.nextInt();
		long d = b * b - 4 * a * c;
		if (a == 0) {
			if (b == 0 && c == 0)
				System.out.println(-1);
			else if (b == 0)
				System.out.println(0);
			else {
				System.out.println(1);
				System.out.println((double)-c / b);
			}
		}
		else {
			if (d < 0)
				System.out.println(0);
			else if (d == 0) {
				System.out.println(1);
				System.out.println(-b / (2 * a));
			}
			else {
				System.out.println(2);
				if (a > 0) {
					System.out.println((-b - Math.sqrt(d)) / (2 * a));
					System.out.println((-b + Math.sqrt(d)) / (2 * a));
				}
				else {
					System.out.println((-b + Math.sqrt(d)) / (2 * a));
					System.out.println((-b - Math.sqrt(d)) / (2 * a));
				}
			}
		}
		read.close();
	}

}