import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		int n = in.nextInt();
		System.out.println(a + " " + b);
		while(n --> 0) {
			String c = in.next(), d = in.next();
			if(a.equals(c)) {
				a = d;
			} else {
				b = d;
			}
			System.out.println(a + " " + b);
		}
	}
}
