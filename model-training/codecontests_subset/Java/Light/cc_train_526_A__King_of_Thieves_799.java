import java.io.*;

public class CF526A {
	static boolean good(char[] cc, int i, int l) {
		return cc[i + l] == '*' && cc[i + l * 2] == '*' && cc[i + l * 3] == '*' && cc[i + l * 4] == '*';
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] cc = br.readLine().toCharArray();
		for (int i = 0; i < n; i++)
			if (cc[i] == '*')
				for (int l = 1; l < n; l++)
					if (i + l * 4 < n && good(cc, i, l)) {
						System.out.println("yes");
						return;
					}
		System.out.println("no");
	}
}
