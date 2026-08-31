import java.util.Scanner;

public class EquivalentStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(smallest(s1).equals(smallest(s2)) ? "YES" : "NO");
	}

	static String smallest(String s) {
		if (s.length() <= 1 || s.length() % 2 == 1)
			return s;
		String s1 = smallest(s.substring(0, s.length() / 2));
		String s2 = smallest(s.substring(s.length() / 2));
		if (s1.compareTo(s2) < 0)
			return s1 + s2;
		else
			return s2 + s1;
	}

}
