import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String S = sc.nextLine();
	static String target = "keyence";
	public static void main(String[] args) {
		if (S.startsWith(target) || S.endsWith(target)
				|| S.matches("k.*eyence")
				|| S.matches("ke.*yence")
				|| S.matches("key.*ence")
				|| S.matches("keye.*nce")
				|| S.matches("keyen.*ce")
				|| S.matches("keyenc.*e")
				) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}