import java.io.*;

public class CF5A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int n = 0;
		int l = 0;
		while ((s = br.readLine()) != null) {
			char c = s.charAt(0);
			if (c == '+')
				n++;
			else if (c == '-')
				n--;
			else {
				int i = s.indexOf(':');
				l += n * (s.length() - i - 1);
			}
		}
		System.out.println(l);
	}
}
