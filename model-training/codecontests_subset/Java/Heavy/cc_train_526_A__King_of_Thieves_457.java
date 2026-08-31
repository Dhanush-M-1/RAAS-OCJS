import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static int[] readIntArray() throws IOException {
		String[] v = br.readLine().split(" ");
		int[] ans = new int[v.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = Integer.valueOf(v[i]);
		}

		return ans;
	}

	static int n;
	static char[] l;

	public static void main(String[] args) throws IOException {
		n = readIntArray()[0];
		l = br.readLine().toCharArray();

		boolean ok = false;
		for (int dist = 1; dist <= 30 && !ok; dist++) {
			for (int start = 0; start < n && !ok; start++) {
				boolean current = true;
				for (int i = 0; i < 5; i++) {
					int pos = start + dist * i;
					current = current && (pos < n && l[pos] == '*');
				}
				ok = ok || current;
			}
		}

		System.out.println(ok ? "yes" : "no");
	}

}
