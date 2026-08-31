import java.io.*;
import java.math.*;
import java.util.*;

public class CODEFORCES
{
	private InputStream is;
	private PrintWriter out;

	int or[][], pre[][];

	void solve()
	{
		int n = ni();
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = ni();
		or = new int[n + 1][32];
		pre = new int[n + 1][32];
		for (int i = 0; i < n; i++)
		{
			int tmp = arr[i + 1];
			for (int j = 0; j < 32; j++)
			{
				if ((tmp & 1) == 1)
					or[i + 1][j] = 1;
				pre[i + 1][j] = pre[i][j] + or[i + 1][j];
				tmp >>= 1;
			}
		}
		long ans = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i++)
		{
			int l = 1, r = i, kl = i;
			if (map.containsKey(arr[i]))
				l = map.get(arr[i]) + 1;
			while (l <= r)
			{
				int mid = l + r >> 1;
				int num = 0;
				for (int j = 0; j < 32; j++)
				{
					if (pre[i][j] > pre[mid - 1][j])
						num |= (1 << j);
				}
				if (arr[i] == num)
				{
					r = mid - 1;
					kl = mid;
				} else
				{
					l = mid + 1;
				}
			}
			long cm = i - kl + 1;
			l = i;
			r = n;
			kl = i;
			while (l <= r)
			{
				int mid = l + r >> 1;
				int num = 0;
				for (int j = 0; j < 32; j++)
				{
					if (pre[i - 1][j] < pre[mid][j])
						num |= (1 << j);
				}
				if (arr[i] == num)
				{
					l = mid + 1;
					kl = mid;
				} else
				{
					r = mid - 1;
				}
			}
			ans += cm * (long) (kl - i + 1);
			// out.println(ans);
			map.put(arr[i], i);
		}
		long tmp = n * (long) (n + 1);
		tmp >>= 1;
		tmp -= ans;
		out.println(tmp);
	}

	void soln()
	{
		is = System.in;
		out = new PrintWriter(System.out);
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args)
	{
		new CODEFORCES().soln();
	}

	// To Get Input
	// Some Buffer Methods
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte()
	{
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf)
		{
			ptrbuf = 0;
			try
			{
				lenbuf = is.read(inbuf);
			} catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c)
	{
		return !(c >= 33 && c <= 126);
	}

	private int skip()
	{
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd()
	{
		return Double.parseDouble(ns());
	}

	private char nc()
	{
		return (char) skip();
	}

	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b)))
		{ // when nextLine, (isSpaceChar(b) && b != '
			// ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b)))
		{
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n)
	{
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-')
		{
			minus = true;
			b = readByte();
		}

		while (true)
		{
			if (b >= '0' && b <= '9')
			{
				num = num * 10 + (b - '0');
			} else
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-')
		{
			minus = true;
			b = readByte();
		}

		while (true)
		{
			if (b >= '0' && b <= '9')
			{
				num = num * 10 + (b - '0');
			} else
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private void tr(Object... o)
	{
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
}