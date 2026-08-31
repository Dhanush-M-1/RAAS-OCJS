import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] goodCondition = { ".*keyence", "k.*eyence", "ke.*yence", "key.*ence", "keye.*nce", "keyen.*ce",
				"keyenc.*e", "keyence.*" };

		if (Stream.of(goodCondition).anyMatch(str::matches)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}