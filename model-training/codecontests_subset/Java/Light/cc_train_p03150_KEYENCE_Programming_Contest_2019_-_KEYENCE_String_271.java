import java.util.*;

public class Main {
	static String KEYENCE = "keyence";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		in.close();
		List<String> startStrs = startStrs(line);
		List<String> endStrs = endStrs(line);
		boolean enable = false;
		for (String startStr : startStrs) {
			for (String endStr : endStrs) {
				if (KEYENCE.equals(startStr + endStr)) {
					enable = true;
					break;
				}
			}
			if (enable) {
				break;
			}
		}
		if (line.startsWith(KEYENCE)) {
			enable = true;
		}
		if (line.endsWith(KEYENCE)) {
			enable = true;
		}
		if (enable) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static List<String> startStrs(String line) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= KEYENCE.length(); ++i) {
			result.add(line.substring(0, i));
		}
		return result;
	}

	static List<String> endStrs(String line) {
		List<String> result = new ArrayList<>();
		for (int i = line.length() - 1; i >= line.length() - KEYENCE.length(); --i) {
			result.add(line.substring(i, line.length()));
		}
		return result;
	}

}