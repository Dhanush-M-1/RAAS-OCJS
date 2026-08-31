import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int l, r, value = 1, maxTime;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		StringTokenizer tk;
		line = in.readLine();
		tk = new StringTokenizer(line);
		l = Integer.parseInt(tk.nextToken());
		r = Integer.parseInt(tk.nextToken());

		if (r == l || l*2 ==r && (r%2!=0 || r%2 !=0)) {
			System.out.println(l);
		}
		else System.out.println("2");

	}
}
