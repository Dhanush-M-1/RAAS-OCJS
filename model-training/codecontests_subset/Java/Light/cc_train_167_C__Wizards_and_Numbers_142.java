import java.io.*;
import java.util.*;
public class bb {
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int T = input.nextInt();
	for(int t = 0; t<T; t++)
	{
		long a = input.nextLong(), b = input.nextLong();
		out.println(go(a, b) > 0 ? "First" : "Second");
	}
	out.close();
}
static int go(long a, long b)
{
	if(b < a) return go(b, a);
	if(a == 0) return 0;
	if(go(a, b%a) == 0) return 1;
	if((b/a)%(a+1)%2 == 0) return 1;
	else return 0;
	
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

