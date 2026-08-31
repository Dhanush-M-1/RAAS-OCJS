/*
    Java might be good for Competitive Programming but Python still rocks!!!!!!!!!


                            pppppppppppppppppppp
                         ppppp  ppppppppppppppppppp
                      ppppppp    ppppppppppppppppppppp
                      pppppppp  pppppppppppppppppppppp
                      pppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppppp
       ppppppppppppppppppppppppppppppppppppppppppppppp  pppppppppppppppppppp
      pppppppppppppppppppppppppppppppppppppppppppppppp  ppppppppppppppppppppp
     ppppppppppppppppppppppppppppppppppppppppppppppppp  pppppppppppppppppppppp
    ppppppppppppppppppppppppppppppppppppppppppppppp    pppppppppppppppppppppppp
   pppppppppppppppppppppppppppppppppppppppppppppp     pppppppppppppppppppppppppp
  ppppppppppppppppppppppppppppppppppppppppppppp      pppppppppppppppppppppppppppp
  pppppppppppppppppppppppppppppppp               pppppppppppppppppppppppppppppppp
  pppppppppppppppppppppppppppp     pppppppppppppppppppppppppppppppppppppppppppppp
  ppppppppppppppppppppppppppp    pppppppppppppppppppppppppppppppppppppppppppppppp
    pppppppppppppppppppppppp  pppppppppppppppppppppppppppppppppppppppppppppppppp
     ppppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppppppp
      pppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppppp
       ppppppppppppppppppppp  ppppppppppppppppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppppp
                              pppppppppppppppppppppppppppppppp
                              pppppppppppppppppppppp  pppppppp
                              ppppppppppppppppppppp    ppppppp
                                 ppppppppppppppppppp  ppppp
                                    pppppppppppppppppppp
*/


import java.util.*;
import java.lang.*;
import java.io.*;
public final class ProblemF
{
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int t, n, m, i, j, k, u, v, w, q, low, high, mid, mod = 1_000_000_007;
    public static int[] parent;
    public static boolean[] marked;
    public static void main(String[] args) throws IOException
    {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[m + 1];
        marked = new boolean[m + 1];
        for(i = 0; i <= m; i++) parent[i] = i;
        long answer = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for(i = 1; i <= n; i++)
        {
            k = sc.nextInt();
            if(k == 1)
            {
                u = parent(sc.nextInt());
                if(!marked[u])
                {
                    marked[u] = true;
                    answer = (answer * 2) % mod;
                    result.add(i);
                }
            }
            else
            {
                u = sc.nextInt();
                v = sc.nextInt();
                if(union(u, v))
                {
                    answer = (answer * 2) % mod;
                    result.add(i);
                }
            }
        }
        out.write(answer + " " + result.size() + "\n");
        for(int i: result) out.write(i + " ");
        out.flush();
        out.close();
    }

    static int parent(int value)
    {
        if(parent[value] != value) return parent[value] = parent(parent[value]);
        return parent[value];
    }

    static boolean union(int value1, int value2)
    {
        int p1 = parent(value1), p2 = parent(value2);
        if((p1 == p2) || (marked[p1] && marked[p2])) return false;
        parent[p1] = p2;
        marked[p2] |= marked[p1];
        return true;
    }

    public static class Print
    {
        Print()
        {}

        void integer(int... arr) throws IOException
        {
            for(int value: arr)
            {
                out.write(value+" ");
                out.flush();
            }
            out.write("\n");
            out.flush();
        }

        void string(String... arr) throws IOException
        {
            for(String value: arr)
            {
                out.write(value+" ");
                out.flush();
            }
            out.write("\n");
            out.flush();
        }

        void character(char... arr) throws IOException
        {
            for(char value: arr)
            {
                out.write(value+" ");
                out.flush();
            }
            out.write("\n");
            out.flush();
        }

        void long_int(long... arr) throws IOException
        {
            for(long value: arr)
            {
                out.write(value+" ");
                out.flush();
            }
            out.write("\n");
            out.flush();
        }
    }

    static class FastScanner
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next()
        {
            while (!st.hasMoreTokens())
                try
                {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
        int[] readArray(int n)
        {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
    }
}