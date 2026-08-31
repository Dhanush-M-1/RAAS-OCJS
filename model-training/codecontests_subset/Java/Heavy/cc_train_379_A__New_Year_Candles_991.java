import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer to = new StringTokenizer(sc.readLine(), " ");
		int n = Integer.parseInt(to.nextToken());
		int a = Integer.parseInt(to.nextToken());
		int out = n;
//		int rc = n;
		int dc = 0;
		while (n > 0) {
			while (n > 0) {
				dc += (n % a);
				n /= a;
				out += n;
			}
			n = dc / a;
			dc = dc % a;
			out += n;
		}
//		out += dc;
		System.out.println(out);
	}

}
