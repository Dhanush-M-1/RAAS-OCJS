import java.util.Scanner;

public class InitialBet {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int c1 = in.nextInt(), c2 = in.nextInt(), c3 = in.nextInt(), c4 = in.nextInt(), c5 = in.nextInt(),
				s = c1 + c2 + c3 + c4 + c5;
		in.close();
		System.out.println(s % 5 == 0 && s != 0 ? s / 5 : -1);
	}
}
