import java.util.*;


public class stavka {
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);

		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		
		if (a + b + c + d + e == 0) {
			System.out.println (-1);
			return;
		}
		if ((a + b + c + d + e) % 5 == 0) {
			System.out.println ((a + b + c + d + e) / 5 );
		}
		else {
			System.out.println (-1);
		}
	}
}