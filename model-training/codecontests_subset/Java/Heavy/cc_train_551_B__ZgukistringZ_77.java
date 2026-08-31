//package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	char[] c = bf.next().toCharArray();
	char[] a = bf.next().toCharArray();
	char[] b = bf.next().toCharArray();
	int[] occC = new int[26];
	int[] occA = new int[26];
	int[] occB = new int[26];
	for (int i = 0; i < c.length; i++)
	{
	    occC[c[i] - 'a']++;
	}
	for (int i = 0; i < a.length; i++)
	{
	    occA[a[i] - 'a']++;
	}
	for (int i = 0; i < b.length; i++)
	{
	    occB[b[i] - 'a']++;
	}
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < occA.length; i++)
	{
	    if (occA[i] > 0)
		min = Math.min(min, occC[i] / occA[i]);
	}
	int ans = 0, idx = -1;
	for (int i = 0; i <= min; i++)
	{
	    int tmp = c.length;
	    for (int j = 0; j < occB.length; j++)
	    {
		if (occB[j] > 0)
		    tmp = Math.min(tmp, (occC[j] - i * occA[j]) / occB[j]);
	    }
	    if (ans < tmp + i)
	    {
		ans = tmp + i;
		idx = i;
	    }
	}
	for (int i = 0; ans > 0 && i < idx; i++)
	{
	    out.print(a);
	}
	for (int i = 0; ans > 0 && i < ans - idx; i++)
	{
	    out.print(b);
	}
	for (int i = 0; i < occC.length; i++)
	{
	    int sz = ans == 0?occC[i]:occC[i] - (idx * occA[i] + (ans - idx) * occB[i]);
	    for (int j = 0; j < sz; j++)
	    {
		out.print((char) (i + 'a'));
	    }
	}
	out.flush();
	out.close();
    }

    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);
	}

	public String next() throws IOException
	{
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}