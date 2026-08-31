//package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int r1 = bf.nextInt(), r2 = bf.nextInt(),c1=  bf.nextInt(), c2 = bf.nextInt(), d1 = bf.nextInt(),d2 = bf.nextInt();
	boolean flag = false;
	loop:
	    for (int i = 1; i < 10; i++)
	    {
		for (int j = 1; j < 10; j++)
		{
		    if(i == j) continue;
		    for (int k = 1; k < 10; k++)
		    {
			if(i == k || j == k) continue;
			for (int l = 1; l < 10; l++)
			{
			    if(l == i || l == j || l == k) continue;
			    if(i+j == r1 && k + l == r2 && i+k== c1 && j + l == c2 && i+l == d1 && j + k == d2){
				flag = true;
				out.println(i + " " + j);
				out.println(k + " " + l);
				break loop;
			    }
			}
		    }
		}
	    }
	if(!flag) out.println(-1);
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
