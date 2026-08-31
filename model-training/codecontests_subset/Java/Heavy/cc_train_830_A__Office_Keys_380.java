import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 public class _831D {

 }

 */

public class _831D
{
	public void solve() throws FileNotFoundException
	{
		InputStream inputStream = System.in;

		InputHelper inputHelper = new InputHelper(inputStream);

		PrintStream out = System.out;

		// actual solution
		int n = inputHelper.readInteger();
		int k = inputHelper.readInteger();
		int p = inputHelper.readInteger();

		int[] a = new int[n];

		for (int i = 0; i < n; i++)
		{
			a[i] = inputHelper.readInteger();
		}

		Arrays.sort(a);

		int[] b = new int[k];

		for (int i = 0; i < k; i++)
		{
			b[i] = inputHelper.readInteger();
		}
		Arrays.sort(b);

		long lo = 0;
		long hi = (long) 2e12;

		long ans = Long.MAX_VALUE;

		while (lo <= hi)
		{
			long mid = (lo + hi) / 2;

			if (isp(a, b, p, mid, n, k))
			{
				ans = Math.min(ans, mid);
				hi = mid - 1;
			}
			else
			{
				lo = mid + 1;
			}
		}

		System.out.println(ans);
		// end here
	}

	boolean isp(int[] pp, int[] ke, int p, long cv, int n, int k)
	{
		int pi = 0;
		int ske = 0;
		for (int i = 0; i < k; i++)
		{
			long d = Math.abs(ke[i] - pp[pi]);
			d += Math.abs(ke[i] - p);

			if (d > cv)
			{
				ske++;

				if (ske > k - n)
				{
					return false;
				}
			}
			else
			{
				pi++;

				if (pi == n)
				{
					break;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		(new _831D()).solve();
	}

	class InputHelper
	{
		StringTokenizer tokenizer = null;
		private BufferedReader bufferedReader;

		public InputHelper(InputStream inputStream)
		{
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			bufferedReader = new BufferedReader(inputStreamReader, 16384);
		}

		public String read()
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try
				{
					String line = bufferedReader.readLine();
					if (line == null)
					{
						return null;
					}
					tokenizer = new StringTokenizer(line);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public Integer readInteger()
		{
			return Integer.parseInt(read());
		}

		public Long readLong()
		{
			return Long.parseLong(read());
		}
	}
}