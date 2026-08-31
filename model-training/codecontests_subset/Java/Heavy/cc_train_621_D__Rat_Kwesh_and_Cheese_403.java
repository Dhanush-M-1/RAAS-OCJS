import java.io.*;
import java.util.*;
public class D621 {
	static double EPS = 1e-10;
	static String[] ss = new String[]{
			"x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y", "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x", "z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x"
	};
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	boolean findMax = true;
	double a = input.nextDouble(), b = input.nextDouble(), c = input.nextDouble();
	if(a <= 1 && b <= 1 && c <= 1)
	{
		//a = 1/a;
		//b = 1/b;
		//c = 1/c;
		findMax = false;
	}
	int besti = -1;
	double bestVal = 0;
	for(int i = 0; i<12; i++)
	{
		double base = a;
		if(i >= 4) base = b;
		if(i >= 8) base = c;
		if(base <= 1 && findMax) continue;
		if(i%4 < 2)
		{
			double loglog = lnln(base);
			double second = a;
			if(i == 1 || i == 5) second = c;
			if(i == 0 || i == 9) second = b;
			double third = a+b+c-second - base;
			loglog += third * ln(second);
			//out.println(i+" "+loglog);
			if(besti == -1 || (findMax && loglog > bestVal + EPS) || (!findMax && loglog < bestVal - EPS))
			{
				besti = i;
				bestVal = loglog;
			}
		}
		else
		{
			double second = b, third = c;
			if(base == b) second = a;
			else if(base == c) third = a;
			//out.println(i+" "+base+" "+second+" "+third);
			double loglog = lnln(base) + ln(second) + ln(third);
			//out.println(loglog);
			if(besti == -1 || (findMax && loglog > bestVal + EPS) || (!findMax && loglog < bestVal - EPS))
			{
				besti = i;
				bestVal = loglog;
			}
		}
	}
	if(besti == -1) besti =0;
	out.println(ss[besti]);
	out.close();
}
static double lnln(double x)
{
	if(x < 1) x = 1.0/x;
	return ln(ln(x));
}
static double ln(double x)
{
	return Math.log(x);
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

