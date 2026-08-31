import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 */
public class Main {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	public static void run(InputStream in, PrintStream out) {
		try (Scanner sc = new Scanner(in)) {
			Set<String> set = new HashSet<>();
			long res = 0;
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.startsWith("+")) {
					set.add(s.substring(1));
				} else if (s.startsWith("-")) {
					set.remove(s.substring(1));
				} else {
					int i = s.indexOf(':');
					res += set.size() * (s.length() - i - 1);
				}

			}
			out.println(res);
		}
	}

}