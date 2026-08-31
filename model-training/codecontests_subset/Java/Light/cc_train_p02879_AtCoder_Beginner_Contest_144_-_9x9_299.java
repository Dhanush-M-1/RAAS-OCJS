import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int A = scn.nextInt();
		int B = scn.nextInt();
		boolean ans = (A <10) && (0 < A) && (0 < B) && (B<10);

		System.out.println(ans?A*B:-1);
	}

}
