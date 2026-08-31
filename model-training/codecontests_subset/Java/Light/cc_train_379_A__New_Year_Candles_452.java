import java.util.Scanner;

public class BurningCandles {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt(), c = 0, h = 0;
		in.close();

		while (a-- > 0) {
			c++;
			if (c % b == 0) {
				a++;
				c = 0;
			}
			h++;
		}
		System.out.println(h);
	}
}
