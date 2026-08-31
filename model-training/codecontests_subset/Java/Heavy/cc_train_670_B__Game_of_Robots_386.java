//package Codeforces.Div2B_350.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * some cheeky quote
 */

public class Main
{
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException
    {
        int n = in.nextInt();
        int k = in.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }

        int row = 1;
        while (k > row)
        {
            k -= row;
            row++;
        }
        out.println(a[k - 1]);


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

