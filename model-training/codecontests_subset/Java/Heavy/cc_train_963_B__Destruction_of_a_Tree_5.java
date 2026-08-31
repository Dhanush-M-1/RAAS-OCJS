import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

public class firstone {

    public static TreeSet<String> hs;
    public static ArrayList<Integer> aa[];
    public static InputReader in;
    public static PrintWriter out;
    public static void main(String[] args) {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        if(n%2 ==0)
        {
            out.println("NO");
            out.close();
            return;
        }
        else out.println("YES");
        aa = new ArrayList[n+1];
        for (int  i = 0 ;i<n+1;i++)
        {
            aa[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 1 ;i<=n;i++)
        {
            int p = in.nextInt();
            if(p == 0)
            {
                root = i;
            }else
            {
                aa[p].add(i);

            }
        }
        dfs(root);
        /*for (int i :degree)
        {
            if(i!=0)
                System.out.print(i+" ");
        }
        */
        delete(root);



        out.close();

    }
    static int visited[] = new int[200010];
    static int degree[] = new int[200010];
    static int j = 0;
    static void dfs(int node)
    {
       degree[node] = 1;
       for (int i = 0 ;i<aa[node].size();i++)
       {
           j++;
           dfs(aa[node].get(i));
           //System.out.println(node+" call no"+j+" "+aa[node].get(i));
           degree[node] +=degree[aa[node].get(i)];
       }
       //Even bacho ka subtree milne se hi khatam kardo
       if(degree[node]%2 == 0)
       {
          // System.out.print(node+" deletehone aya");
           delete(node);
       }


    }
    static void delete(int node)
    {
        visited[node] = 1;
        out.println(node);
        for (int i = 0 ;i<aa[node].size();i++)
        {
            if(visited[aa[node].get(i)] == 0)
            {
                delete(aa[node].get(i));
                //System.out.print(aa[node].get(i)+" ");
            }
        }
    }



    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

}
