import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	InputStream in = System.in;
	PrintStream out = System.out;

	public void _main(String[] args) {
		Scanner sc = new Scanner(in);

		String S = sc.next();

		sc.close();

		String[] regex = { ".*keyence", "k.*eyence", "ke.*yence", "key.*ence", "keye.*nce", "keyen.*ce", "keyenc.*e",
				"keyence.*", };

		String ans = "NO";
		for (String r : regex) {
			if (S.matches(r)) {
				ans = "YES";
			}
		}

		out.println(ans);

	}

	public static void main(String[] args) {
		new Main()._main(args);
	}
}
