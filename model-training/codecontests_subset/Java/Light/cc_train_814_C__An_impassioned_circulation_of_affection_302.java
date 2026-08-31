import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem418C {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int n = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();
		int q = Integer.parseInt(reader.readLine());

		int[] indices = new int[26];
		Arrays.fill(indices, -1);
		int[] next = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			next[i] = indices[s[i] - 'a'];
			indices[s[i] - 'a'] = i;
		}
		for (int i = 0; i < q; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int m = Integer.parseInt(tokenizer.nextToken());
			char c = tokenizer.nextToken().charAt(0);
			int index = c - 'a';
			if (indices[index] == -1) {
				// doesn't exist
				writer.println(m);
				continue;
			}
			int max = 0;
			int left = indices[index];
			int right = left;
			int count = 1;
			while (left != -1) {
				// is advancing to the next one valid?
				while (next[right] != -1 && next[right] - left + 1 <= m + count + 1) {
					right = next[right];
					count++;
				}
				max = Math.max(max, count + m);
				left = next[left];
				count--;
			}
			writer.println(Math.min(max, n));
		}


		reader.close();
		writer.close();
	}
}
