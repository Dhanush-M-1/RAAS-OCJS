import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AncientProphesy {

	static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static boolean check(String s) {
		if (!(s.charAt(2) == s.charAt(5) && s.charAt(2) == '-'))
			return false;
		boolean isNumber = true;
		for (int i = 0; i < s.length() && isNumber; i++) {
			if (i == 2 || i == 5)
				continue;
			isNumber &= s.charAt(i) >= '0' && s.charAt(i) <= '9';
		}
		if (!isNumber)
			return false;
		int day = Integer.parseInt(s.substring(0, 2));
		int month = Integer.parseInt(s.substring(3, 5)) - 1;
		int year = Integer.parseInt(s.substring(6, s.length()));
		if (year < 2013 || year > 2015 || day == 0 || month < 0 || month > 11
				|| days[month] < day)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		String s = nxtTok();
		HashMap<String, Integer> hm = new HashMap<>();
		String ans = null;
		for (int i = 0; i + 10 <= s.length(); i++) {
			ans = s.substring(i, i + 10);
			if (check(ans))
				hm.put(ans, hm.containsKey(ans) ? hm.get(ans) + 1 : 1);
		}
		int max = 0;
		ans = null;
		for (String x : hm.keySet()) {
			int tmp = hm.get(x);
			if (tmp > max) {
				max = tmp;
				ans = x;
			}
		}
		out.println(ans);
		br.close();
		out.close();
	}

	static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;

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

	static double nxtDbl() throws IOException {
		return Double.parseDouble(nxtTok());
	}

	static int[] nxtIntArr(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtInt();
		return a;
	}

	static long[] nxtLngArr(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtLng();
		return a;
	}

	static char[] nxtCharArr() throws IOException {
		return nxtTok().toCharArray();
	}
}