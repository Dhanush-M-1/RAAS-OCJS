import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{

	/* IO */
	InputReader in;
	StringTokenizer tok;
	StringBuilder ans;

	/* FIELDS */
	int n, k, a, b, c, d;

	public static void main(String[] args) throws FileNotFoundException
	{
		Main sol = new Main();
		sol.begin();

	}

	private void begin() throws FileNotFoundException
	{
		// io
		boolean file = false;
		if (file)
			in = new InputReader(new FileInputStream("input.in"));
		else
			in = new InputReader(System.in);
		ans = new StringBuilder();

		// read
		n = in.nextInt();
		k = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();

		// solve
		solve();
		System.out.print(ans.toString());
	}

	private void solve()
	{
		// check valid
		if (n == 4 || k < n + 1)
		{
			ans.append("-1\n");
			return;
		}

		// mark other nodes
		boolean taken[] = new boolean[n + 1];
		taken[a] = true;
		taken[b] = true;
		taken[c] = true;
		taken[d] = true;

		// a -> b
		StringBuilder strb = new StringBuilder();
		strb.append(a + " ");
		strb.append(c + " ");
		for (int i = 1; i <= n; i++)
			if (!taken[i])
				strb.append(i + " ");
		strb.append(d + " ");
		strb.append(b + " ");
		ans.append(strb.toString().trim() + "\n");

		// c -> d
		strb = new StringBuilder();
		strb.append(c + " ");
		strb.append(a + " ");
		for (int i = 1; i <= n; i++)
			if (!taken[i])
				strb.append(i + " ");
		strb.append(b + " ");
		strb.append(d + " ");
		ans.append(strb.toString().trim() + "\n");
	}
}

class InputReader
{
	BufferedReader reader;
	StringTokenizer tok;

	public InputReader(InputStream stream)
	{
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tok = new StringTokenizer("");
	}

	public String next()
	{
		while (!tok.hasMoreTokens())
			try
			{
				tok = new StringTokenizer(reader.readLine());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		return tok.nextToken();
	}

	public int nextInt()
	{
		return Integer.parseInt(next());
	}
}