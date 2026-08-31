import java.io.*;

public class CF893A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int c = 3;
		while (n-- > 0) {
			int a = Integer.parseInt(br.readLine());
			if (a == c) {
				System.out.println("NO");
				return;
			}
			c = 6 - a - c;
		}
		System.out.println("YES");
	}
}
