import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean match = false;

		String[] goodCondition = { "keyence", "k.+eyence", "ke.+yence", "key.*ence", "keye.+nce", "keyen.+ce",
				"keyenc.+e" };

		for (String cond : goodCondition) {
			if (str.matches(cond)) {
				match = true;
			}
		}

		if (match) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}