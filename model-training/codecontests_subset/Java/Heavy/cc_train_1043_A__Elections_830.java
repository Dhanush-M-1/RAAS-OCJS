import java.util.*;
import java.io.*;

public class Elections {
	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = nextInt();
		}
		Arrays.sort(arr);
		int max = arr[n - 1];
		int Elo = 0;
		int Awr = 0;
		for(int i = 0; i < n; i++) {
			Elo += arr[i];
			Awr += max - arr[i];
		}
		if(Elo >= Awr)
			max += (int) ((Elo - Awr) / n) + 1;
		System.out.println(max);
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
