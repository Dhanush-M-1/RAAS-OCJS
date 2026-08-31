import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author zodiacLeo
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        FastPrinter out = new FastPrinter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD
    {
        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n <= 4 || k < n + 1)
            {
                out.println(-1);
                return;
            }

            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int[] map = new int[n + 1];
            map[1] = a;
            map[2] = b;
            map[3] = c;
            map[4] = d;
            int now = 1;
            for (int j = 5; j <= n; j++)
            {
                while (now == a || now == b || now == c || now == d)
                {
                    now++;
                }
                map[j] = now;
                now++;
            }
            int[] p1 = new int[n];
            p1[0] = 1;
            p1[n - 1] = 2;
            p1[1] = 3;
            p1[n - 2] = 4;
            now = 5;
            for (int i = 0; i < n; i++)
            {
                if (p1[i] == 0)
                {
                    p1[i] = now;
                    now++;
                }
            }
            int[] p2 = p1.clone();
            int temp = p2[0];
            p2[0] = p2[1];
            p2[1] = temp;

            temp = p2[n - 1];
            p2[n - 1] = p2[n - 2];
            p2[n - 2] = temp;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < n; i++)
            {
                sb.append(map[p1[i]] + " ");
            }
            sb.append("\n");
            for (int i = 0; i < n; i++)
            {
                sb.append(map[p2[i]] + " ");
            }
            sb.append("\n");
            out.print(sb);
        }

    }

    static class FastPrinter extends PrintWriter
    {
        public FastPrinter(OutputStream out)
        {
            super(out);
        }

        public FastPrinter(Writer out)
        {
            super(out);
        }

    }

    static class FastScanner
    {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream is)
        {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public FastScanner(File f)
        {
            try
            {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        public String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                String s = null;
                try
                {
                    s = br.readLine();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

    }
}

