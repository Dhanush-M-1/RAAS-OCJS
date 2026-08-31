import java.util.Scanner;
public class E3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int r1 = input.nextInt();
		int r2 = input.nextInt();
		int c1 = input.nextInt();
		int c2 = input.nextInt();
		int d1 = input.nextInt();
		int d2 = input.nextInt();
		double c = (c1 - r1 + d2)  / 2;
		double a = (d1 - r2 + c1) / 2;
		double b = r1 - a;
		double d = r2 - c;
		if(a == (int)a && b == (int) b && c == (int) c && d == (int) d && a > 0 && b >0 && c >0 && d > 0 && a != b && a != c && a != d && b != c && b != d && c != d && a < 10&& b < 10&& c < 10 && d < 10) {
			System.out.println((int) a + " " + (int) b);
			System.out.println((int)c + " " + (int)d);
		}
		else {
			System.out.println(-1);
		}
	}

}
