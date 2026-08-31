

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException
    {
        int n = in.nextInt();
        long a = 0;
        long b = 0;
        long c = 0;
        for (int i = 0; i < n; ++i)
        {
            a += in.nextInt();
        }
        for (int i = 0; i < n - 1; i++)
        {
            b += in.nextInt();
        }
        for (int i = 0; i < n - 2; i++)
        {
            c += in.nextInt();
        }
        System.out.println(a - b);
        System.out.println(b - c);


    }

    public void run()
    {
        try
        {
            in = new FastScanner();
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;

        FastScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg)
    {
        new Main().run();
    }
}

class Item implements Comparable<Item>
{
    public int n;

    public Item(int n)
    {
        this.n = n;
    }

    public int compareTo(Item that)
    {
        return this.n - that.n < 0 ? -1 : +1;
    }
}
