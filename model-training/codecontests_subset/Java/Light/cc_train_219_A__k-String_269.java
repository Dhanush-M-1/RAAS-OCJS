import java.io.*;

public class CF219A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] cc = br.readLine().toCharArray();
		int[] kk = new int[26];
		for (int i = 0; i < cc.length; i++) {
			int c = cc[i] - 'a';
			kk[c]++;
		}
		for (int c = 0; c < 26; c++)
			if (kk[c] % k != 0) {
				System.out.println(-1);
				return;
			}
		StringBuilder sa = new StringBuilder();
		for (int c = 0; c < 26; c++)
			for (int i = 0; i < kk[c] / k; i++)
				sa.append((char) ('a' + c));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++)
			sb.append(sa);
		System.out.println(sb);
	}
}
