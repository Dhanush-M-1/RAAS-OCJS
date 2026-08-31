import java.util.Scanner;

public class ReverseSubS {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i;
		String s = in.next(), o = "";
		in.close();

		boolean b = false;

		for (i = 1; i < n; i++) {
			if (s.charAt(i) < s.charAt(i - 1)) {
				o = i + " " + (i + 1);
				b = true;
			}
		}
		System.out.println(b ? "YES\n" + o : "NO");
	}
}
