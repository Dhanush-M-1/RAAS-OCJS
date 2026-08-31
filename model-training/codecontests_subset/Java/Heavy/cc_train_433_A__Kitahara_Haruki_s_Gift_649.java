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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA
    {
        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            int n = in.nextInt();
            int h = 0;
            int t = 0;
            for (int i = 0; i < n; i++)
            {
                int num = in.nextInt();
                if (num == 100)
                {
                    h++;
                } else
                {
                    t++;
                }
            }

            if (h >= 2 * t)
            {
                h -= 2 * t;
                if (h % 2 == 0)
                {
                    out.println("YES");
                    return;
                }
                out.println("NO");
            } else
            {
                if (h % 2 != 0)
                {
                    out.println("NO");
                    return;
                }
                if (t % 2 == 0 && h % 2 == 0)
                {
                    out.println("YES");
                    return;
                }
                if (t % 2 != 0 && h == 0)
                {
                    out.println("NO");
                    return;
                }
                if (t % 2 != 0 && h >= 2)
                {
                    t -= 1;
                    h -= 2;
                    if (t % 2 == 0 && h % 2 == 0)
                    {
                        out.println("YES");
                        return;
                    }
                }
                out.println("NO");
            }

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
}

