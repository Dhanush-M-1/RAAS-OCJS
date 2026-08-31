import java.io.*;
import java.util.*;

public class Main {

	public static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public char nextChar() {
			return next().charAt(0);
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		// InputStream inputStream = System.in; // Useful when taking input other than
		// console eg file handling // check ctor of inputReader
		InputReader scn = new InputReader();

		int k = scn.nextInt();
		String str = scn.next();
		if(str.length() % k != 0) {
			System.out.println(-1);
			return;
		}
		
		int[] arr = new int[26];
		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		
		ArrayList<Character> list = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			if(arr[i] % k != 0) {
				System.out.println(-1);
				return;
			}
			
			int in = arr[i] / k;
			while(in-- > 0) {
				list.add((char)(i + 'a'));
			}
		}
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
			}
		}
		
	}
}