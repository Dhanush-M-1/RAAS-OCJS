import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
	int N;
	char[] chars;
	List<String> result;

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		Main ins = new Main(in);
		ins.calc();
		ins.showResult();
	}

	Main(BufferedReader in) throws IOException {
		N = Integer.parseInt(in.readLine());
		chars = new char[26];
		for (int i = (int) 'a'; i <= (int) 'z'; ++i) {
			int index = i - (int)'a';
			chars[index] = (char) i;
		}

	}

	List<String> sub(String line) {
		Set<Character> cSet = new HashSet<>();
		for (int i = 0; i < line.length(); ++i) {
			cSet.add(line.charAt(i));
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i <= cSet.size(); ++i) {
			list.add(line + chars[i]);
		}
		return list;
	}

	void calc() {
		result = new ArrayList<>();
		result.add("a");
		for (int i = 1; i < N; ++i) {
			List<String> temp = new ArrayList<>();
			for (String line : result) {
				temp.addAll(sub(line));
			}
			result = temp;
		}
	}

	void showResult() {
		for (String line : result) {
			System.out.println(line);
		}
	}
}
