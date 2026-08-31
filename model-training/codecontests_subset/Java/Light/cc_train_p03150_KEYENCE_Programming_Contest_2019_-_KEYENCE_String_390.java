import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = "keyence";
		String S = sc.nextLine();
		for (int i = 0; i < target.length(); i++) {
			if (S.startsWith(target.substring(0, i)) &&
					S.endsWith(target.substring(i))) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}
