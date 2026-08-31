import java.io.*;
import java.util.*;

public class Main	{
	static int[][] C;
	static int[] A;
	static int n;
	static void updata(int i, int j, int x)	{
		while (i <= n)	{
			C[i][j] += x;
			i += i & -i;
		}
	}
	static int query(int i, int j)	{
		int ret = 0;
		while (i > 0)	{
			ret += C[i][j];
			i -= i & -i;
		}
		return ret;
	}
	static int min(int a, int b)	{
		if (a < b)	return a;
		else	return b;
	}
	public static void main(String[] args)	{
		Scanner cin = new Scanner (new BufferedInputStream (System.in));
		n = cin.nextInt ();
		int k = cin.nextInt ();
		int a = cin.nextInt ();
		int b = cin.nextInt ();
		int q = cin.nextInt ();
		C = new int[n+5][2];
		A = new int[n+5];
		for (int i=0; i<q; ++i)	{
			int op = cin.nextInt ();
			if (op == 1)	{
				int d = cin.nextInt ();
				int e = cin.nextInt ();
				int tmp = A[d];	A[d] += e;
				updata (d, 0, min (b, A[d]) - min (b, tmp));	
				updata (d, 1, min (a, A[d]) - min (a, tmp));
			}
			else	{
				int p = cin.nextInt ();
				int ans = query (p - 1, 0) + query (n, 1) - query (p+k-1, 1);
				System.out.println (ans);
			}
		}
	}
}
