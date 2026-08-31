import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class con526_A {

	static int MB = 1 << 20;
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in, StandardCharsets.US_ASCII), 10 * MB);
	static StringTokenizer st;

	static String NL() throws Exception {
		String s = br.readLine();
		st = new StringTokenizer(s);
		return s;
	}

	static String NT() {
		return st.nextToken();
	}

	public static void main(String[] args) throws Exception {
		NL();
		int N = Integer.parseInt(NT());
		char[] ca = NL().toCharArray();
		boolean good = false;
		outer:
		for (int l = 1; l <= N; l++) {
			for (int f = 0; f + 4 * l < N; f++) {
				if (ca[f] == '*' && ca[f+l] == '*' && ca[f + 2 * l] == '*' && ca[f + 3*l] == '*' && ca[f + 4*l] == '*') {
					good = true;
					break outer;
				}
			}
		}
		System.out.println(good? "yes" : "no ");
	}

}
