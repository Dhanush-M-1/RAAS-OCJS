import java.io.*;
import java.util.*;

public class CF551B {
	static int[] convert(char[] cc) {
		int[] aa = new int[26];
		for (int i = 0; i < cc.length; i++)
			aa[cc[i] - 'a']++;
		return aa;
	}
	static int pack1(int[] aa, int[] bb) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++)
			if (bb[i] > 0) {
				int r = aa[i] / bb[i];
				if (min > r)
					min = r;
			}
		return min;
	}
	static int pack2(int[] aa, int[] bb, int b, int[] cc) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++)
			if (cc[i] > 0) {
				int r = (aa[i] - bb[i] * b) / cc[i];
				if (min > r)
					min = r;
			}
		return min;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] aa = convert(br.readLine().toCharArray());
		String b = br.readLine();
		String c = br.readLine();
		int[] bb = convert(b.toCharArray());
		int[] cc = convert(c.toCharArray());
		int m = pack1(aa, bb);
		int max = Integer.MIN_VALUE;
		int imax = 0, jmax = 0;
		for (int i = 0; i <= m; i++) {
			int j = pack2(aa, bb, i, cc);
			if (max < i + j) {
				max = i + j;
				imax = i;
				jmax = j;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < imax; i++)
			sb.append(b);
		for (int j = 0; j < jmax; j++)
			sb.append(c);
		for (int k = 0; k < 26; k++) {
			int n = aa[k] - bb[k] * imax - cc[k] * jmax;
			char ch = (char) ('a' + k);
			while (n-- > 0)
				sb.append(ch);
		}
		System.out.println(sb);
	}
}
