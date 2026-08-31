import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String tmp = br.readLine();
		char[] s = tmp.toLowerCase().toCharArray();
		int ch = Integer.parseInt(br.readLine());
		for (int i = 0; i < s.length; i++) {
			if (s[i] < ch + 97) {
				s[i] = (char) (s[i] - 'a' + 'A');
			}
		}
		out.println(new String(s));
		br.close();
		out.close();
	}
}
