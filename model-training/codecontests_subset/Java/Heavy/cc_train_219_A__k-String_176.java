import java.io.*;
import java.util.*;

public class Smile {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static String a;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
//		Map<String, Integer> hm = new HashMap<String, Integer>();
		n = in.nextInt();
		a = in.next();
		int m = a.length();
		char[] b = a.toCharArray();
		if (m % n != 0) {
			out.println(-1);
			out.close();
			return;
		}
		Arrays.sort(b);
		String d = "";
		for (int i = 0; i < m; i += n) {
			char c = b[i];
			for (int j = i; j < i + n; j++) {
				if (c != b[j]) {
					out.println(-1);
					out.close();
					return;
				}
			}
			d += c;
		}
		for (int i = 0; i < n; i++) {
			out.print(d);
		}
		out.close();
	}
}