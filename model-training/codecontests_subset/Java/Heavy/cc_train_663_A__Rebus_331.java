import java.io.*;
import java.util.*;
public class B664 {
public static void main(String[] args) throws IOException {
	Scanner input = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	ArrayList<Character> list = new ArrayList<Character>();
	list.add('+');
	int sum = -1;
	int pos = 1, neg = 0;
	while(input.hasNext())
	{
		String s = input.next();
		if(s.equals("?") || s.equals("=")) continue;
		if(s.equals("+") || s.equals("-"))
		{
			if(s.equals("+")) pos++;
			else neg++;
			list.add(s.charAt(0));
		}
		else
		{
			sum = Integer.parseInt(s);
			break;
		}
	}
	int max = pos * sum - neg;
	int min = pos - sum * neg;
	//out.println(min+" "+max+" "+sum+" "+pos+" "+neg);
	int need = sum;
	if(min > sum || max < sum) out.println("Impossible");
	else
	{
		out.println("Possible");
		for(int i = 0; i<list.size(); i++)
		{
			if(i > 0) out.print(" "+list.get(i));
			int npos = pos, nneg = neg;
			if(list.get(i) == '+') npos--;
			else nneg--;
			for(int j = 1; j<=sum; j++)
			{
				int nneed = need - (list.get(i) == '+' ? j : -j);
				int nmax = npos * sum - nneg;
				int nmin = npos - sum * nneg;
				if(nneed > nmax || nneed < nmin) continue;
				out.print((i == 0 ? "" :" ")+j);
				need = nneed;
				break;
			}
			pos = npos;
			neg = nneg;
		}
		out.print(" = "+sum);
	}
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

