
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;
import java.math.*;
/*
    *********************
  ***
 ***
 ***
 ***
 ***
   ***
     ***
       ***
*/
public class Cf
{

//INPUT READER//

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int Int() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String String() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return String();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
    static int modulus = (int) 1e7;

    public static int[] sort(int[] a) {
        int n = a.length;
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
            a[i] = l.get(i);
        return a;
    }

    public static long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x) % modulus;
                y--;

            }
            x = (x * x) % modulus;
            y = y / 2;
        }
        return res;
    }

    public static long gcd(long x, long y) {
        if (x == 0)
            return y;
        else
            return gcd(y % x, x);
    }

    public static long lcm(long x, long y) {
        return (x * (y / gcd(x, y)));
    }

    public static int i() {
        return in.Int();
    }

    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }

    public static String s() {
        return in.String();
    }

    public static int[] readArray(int n) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i();
        }
        return A;
    }

    public static long[] readArray(long n) {
        long A[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            A[i] = l();
        }
        return A;
    }

    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static long fast_pow(long a, long b) {
         long mod = (long)1e9 + 7;
        if(b == 0)
            return 1L;

        long val = fast_pow(a, b / 2);

        if(b % 2 == 0)
            return val * val % mod;
        else
            return val * val % mod * a % mod;
    }


//-------------------------------------BFS------------------------------------------------------------------------------------------------------------------------------------//
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int n, int src)
    {
        ArrayList<Integer> p = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Boolean visited[] = new Boolean[n];
        Arrays.fill(visited, false);

        visited[src] = true;
        q.add(src);
        while (q.size() != 0) {
            src = q.poll();
            p.add(src);
            Iterator<Integer> it = g.get(src).iterator();
            while (it.hasNext()) {
                int nn = it.next();

                if (visited[nn] == false) {
                    visited[nn] = true;
                    q.add(n);

                }
            }

        }
        return p;

    }
//--------------------------------------------------------DFS------------------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------------- CODE--------------------------------------------------------------------------------------------------------------------//




    static void dfs(int i,int n)
    {
        if(!visited[i])
        {
            visited[i]=true;
            l.add(i);
        }
        for(int a:graph.get(i))
        {
            if(!visited[a])
            {

                dfs(a,n);

            }
        }

    }

//----------------------********************************MAIN FUNCTION IDHAR NHI AANE KA**********************************************--------------------------------------------------------------//
//***************************************************#$%&^%%%%^^&&--DEVIL---------------------------------------------------------------$%^&&***&&^^%%****************************
///////////////////////////////////////////////////////////////////CODER//////////////////////////////////////////////////////////////////////////////////////////////////////
   static ArrayList<ArrayList<Integer>>graph;
  static   boolean visited[];
  static long size;
  static ArrayList<Integer>l;


    public static void main(String[] args)
     {
         StringBuffer sb=new StringBuffer();
        int t=i();
        while(t-->0) {
            int n = i();
            int A[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                char s[] = s().toCharArray();
                for (int j = 0; j < n; j++)
                    A[i][j] = s[j] - '0';
            }

            int v1 = A[0][1];
            int v2 = A[1][0];
            int v3 = A[n - 1][n - 2];
            int v4 = A[n - 2][n - 1];
            int count = 0;
            ArrayList<Integer> l = new ArrayList<>();
            if (v1 == v2) {
                int x = 1 ^ v1;

                if (x != v3) {
                    count++;
                    l.add(n - 1);
                    l.add(n - 2);
                }
                if (x != v4) {
                    count++;
                    l.add(n - 2);
                    l.add(n - 1);
                }

            } else {
                if (v3 == v4) {
                    int x = 1 ^ v3;
                    if (x != v1) {
                        count++;
                        l.add(0);
                        l.add(1);
                    }
                    if (x != v2) {
                        count++;
                        l.add(1);
                        l.add(0);
                    }
                } else {
                    if (v1 == 0) {
                        count++;
                        l.add(0);
                        l.add(1);
                    }
                    if (v2 == 0) {
                        count++;
                        l.add(1);
                        l.add(0);
                    }
                    if (v3 == 1) {
                        count++;
                        l.add(n - 1);
                        l.add(n - 2);
                    }
                    if (v4 == 1) {
                        count++;
                        l.add(n - 2);
                        l.add(n - 1);
                    }
                }


            }
            sb.append(count + "\n");
            for (int i = 0; i < l.size(); i=i+2)
                sb.append((l.get(i)+1) + " " + (l.get(i + 1)+1)+"\n");
        }
         System.out.println(sb);


     }
}