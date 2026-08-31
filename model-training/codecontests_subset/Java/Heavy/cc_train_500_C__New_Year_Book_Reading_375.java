import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        private int n;
        private int m;
        private int[] w;
        private Integer[] o;

        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            n = in.nextInt();
            m = in.nextInt();

            w = new int[n];
            for (int i = 0; i < n; i++)
            {
                w[i] = in.nextInt();
            }

            int prev = -1;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++)
            {
                int now = in.nextInt() - 1;
                if (i > 0)
                {
                    if (now == prev)
                    {
                        continue;
                    }
                }
                list.add(now);
                prev = now;
            }
            m = list.size();
            o = new Integer[m];
            list.toArray(o);

            list = new ArrayList<>();
            boolean[] was = new boolean[n];
            for (int i = 0; i < m; i++)
            {
                int pos = o[i];
                if (!was[pos])
                {
                    was[pos] = true;
                    list.add(pos);
                }
            }
            Stack<Integer> now = new Stack<>();
            for (int i = 0; i < n; i++)
            {
                if (!was[i])
                {
                    now.push(i);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--)
            {
                int pos = list.get(i);
                now.push(pos);
            }
            int res = 0;
            for (int i = 0; i < m; i++)
            {
                int pos = o[i];
                Stack<Integer> temp = new Stack<>();
                while (now.peek() != pos)
                {
                    int top = now.pop();
                    temp.push(top);
                    res += w[top];
                }
                now.pop();
                while (!temp.isEmpty())
                {
                    now.push(temp.pop());
                }
                now.push(pos);
            }
            out.println(res);
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

