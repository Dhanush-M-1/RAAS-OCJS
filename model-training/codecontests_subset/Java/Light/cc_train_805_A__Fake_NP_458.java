import java.util.Scanner;

public class Fake_NP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		if (y == x) {
			System.out.print(x);
		} else {
			System.out.print(2);
		}
	}
}
