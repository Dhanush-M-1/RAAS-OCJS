import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), false);
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char last = s.charAt(0);
		int start = 0, end = -1;
		for (int i = 1; i < s.length() && end == -1; ++i) {
			if (s.charAt(i) < last) {
				end = i;
			} else {
				start = i;
				last = s.charAt(i);
			}
		}
		if (end == -1) {
			out.println("NO");
		} else {
			out.println("YES");
			out.printf("%d %d%n", start + 1, end + 1);
		}
		out.close();
	}


}
