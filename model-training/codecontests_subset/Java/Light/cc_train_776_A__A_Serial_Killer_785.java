import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String[] s = s1.split(" ");
		int n = in.nextInt();
		String[] t = new String[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			t[i] = in.next();
		}
		System.out.println(s[0] + " " + s[1]);
		for (int i = 0; i < 2 * n; i += 2) {
			if (t[i].equals(s[0])) {
				s[0] = t[i + 1];
			} else {
				s[1] = t[i + 1];
			}
			System.out.println(s[0] + " " + s[1]);

		}
	}

}
