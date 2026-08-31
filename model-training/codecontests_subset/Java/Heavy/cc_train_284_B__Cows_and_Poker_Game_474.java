import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowsAndPokerGame {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		sc = new StringTokenizer(br.readLine());
		nxtInt();
		String s = nxtTok();
		int a, i;
		a = i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == 'A')
				a++;
			else if (s.charAt(j) == 'I')
				i++;
		}
		if (i == 0)
			out.println(a);
		else
			out.println(i == 1 ? 1 : 0);
		br.close();
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	static StringTokenizer sc;

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			sc = new StringTokenizer(s.trim());
		}
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}
}