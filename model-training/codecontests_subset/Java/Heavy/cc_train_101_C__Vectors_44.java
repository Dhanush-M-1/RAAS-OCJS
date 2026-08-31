import java.io.*;
import java.util.*;
public class b {
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	long x1 = input.nextInt(), y1 =input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
	long x3 = input.nextInt(), y3 = input.nextInt();
	long gcd = gcd(Math.abs(x3), Math.abs(y3));
	long[][] poss = new long[][]
			{
		{x2 - x1, y2 - y1},
		{x2+x1, y2+y1},
		{x2 - y1, y2+x1},
		{x2 + y1, y2 - x1}
			};
	long[][] cs = new long[][]{
			{x3, y3},
			{-x3, -y3},
			{y3, -x3},
			{-y3, x3}
	};
	boolean found = false;
	for(int i = 0; i<4; i++)
	{
		long makeX = poss[i][0], makeY = poss[i][1];
		if(gcd == 0)
		{
			if(makeX == 0 && makeY == 0) found = true;
			continue;
		}
		if(makeX%gcd != 0 || makeY%gcd != 0) continue;
		long first = makeX * x3 + makeY * y3;
		long second = makeX * -y3 + makeY * x3;
		//out.println(makeX+" "+makeY+" "+x3+" "+y3+" "+first+" "+second);
		if(first% (x3*x3 + y3*y3) == 0 || second%(x3*x3+y3*y3) == 0) found = true;
	}
	out.println(found ? "YES" : "NO");
	out.close();
}
static long gcd(long a, long b)
{
	return b == 0 ? a : gcd(b, a%b);
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

