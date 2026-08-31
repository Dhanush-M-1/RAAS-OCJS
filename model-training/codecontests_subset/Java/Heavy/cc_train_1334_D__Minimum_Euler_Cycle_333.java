import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Main
{
	static final long mod = 998244353l;
	static long gain[];

	public static void main(String[] args) throws IOException
	{
		Scanner in = getScan(args);
		int t = in.nextInt();
		while (t-- > 0)
		{
			long n = in.nextInt();
			long l = in.nextLong();
			long r = in.nextLong();
			long m = 2 * (n - 1);
			long i = 1;
			if (l == n * (n - 1) + 1)
			{
				System.out.println(1);
				continue;
			}
			while (l > m)
			{
				l -= m;
				r -= m;
				i++;
				m = 2 * (n - i);
			}
			recursive(n, l, r, i);
			System.out.println();
		}
	}

	public static void recursive(long n, long l, long r, long curr)
	{
		if (curr == n)
		{
			if (r == 1) System.out.print(1);
			return;
		}
		long m = 2 * (n - curr);
		if (l <= m)
		{
			l = Math.max(1, l);
			long max = Math.min(r, m);
			for (long i = l; i <= max; i++)
			{
				if (i % 2 == 1) System.out.print(curr + " ");
				else System.out.print(curr + i / 2 + " ");
			}
		}
		l -= m;
		r -= m;
		if (r <= 0) return;
		recursive(n, l, r, curr + 1);
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	static Scanner getScan(String[] args) throws IOException
	{
		if (args.length == 0)
		{
			return new Scanner(System.in);
		}
		else
		{
			return new Scanner(new File(args[0]));
		}
	}

}

class Node
{
	int val;
	int deg;
	int par;
	int i;
	long nbChild;

	Node(int i)
	{
		this.i = i;
	}

	@Override
	public String toString()
	{
		return i + " " + val;
	}
}
