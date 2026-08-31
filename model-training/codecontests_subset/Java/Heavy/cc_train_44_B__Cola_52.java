import java.io.*;
import java.util.*;
public class B44 {
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = input.nextInt(), a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
	int res = 0;
	for(int i = 0; i<= a; i += 2)
		for(int j = 0; j<=b; j++)
		{
			int left = n - i/2 - j;
			if(left < 0 || left%2 == 1 || left/2 > c) continue;
			res++;
		}
	out.println(res);
	out.close();
}

public static class input {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(reader.readLine());
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}
}

