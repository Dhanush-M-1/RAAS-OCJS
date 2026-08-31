import java.util.Scanner;

public class a385 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int best = 0;
		int last = in.nextInt();
		while (n-- > 1) {
			int here = in.nextInt();
			best = Math.max(best, last - here - c);
			last = here;
		}
		System.out.println(best);
	}
}
