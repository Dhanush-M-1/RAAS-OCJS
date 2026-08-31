import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main1 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FKateAndImperfection solver = new FKateAndImperfection();
        solver.solve(1, in, out);
        out.close();
    }

    static class FKateAndImperfection {
        PrintWriter out;
        InputReader in;
        int[] vis;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int t = ni();
            while(t-->0){
                long n = nl();
                long l = nl();
                long r = nl();
                long sum = 0;
                long i = 1;
                while(sum + (n - i) * 2 < l && i < n){
                    sum += (n - i) * 2L;
                    i++;
                    //System.out.println(sum);
                }
                long j = i + 1;
                while(sum + 2 < l && j <= n){
                    sum += 2;
                    j++;
                    //System.out.println(sum);
                }
                //pn(i +" "+j);
                ArrayList<Long> ans = new ArrayList<>();
                if(l % 2 == 0) {
                    ans.add(j);
                    j++;
                    l++;
                }
                //pn(ans);
                if(j == n + 1) {
                    i++;
                    j = i + 1;
                }
                boolean ok = true;
                if(r == n * (n - 1) + 1){
                    ok = false;
                    r--;
                }
                while (l <= r){
                    l++;
                    ans.add(i);
                    if(l <= r) {
                        ans.add(j);
                        l++;
                    }
                    j++;
                    if(j == n + 1) {
                        i++;
                        j = i + 1;
                    }
                }
                if(!ok)
                    ans.add(1L);
                for(long x : ans)
                    p(x +" ");
                pn("");
            }
        }
       /* final Comparator<Tuple> com = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple t1, Tuple t2) {
                if(t1.x != t2.x)
                    return Long.compare(t1.x, t2.x);
                else if(t1.y != t2.y)
                    return Long.compare(t2.y, t1.y);
                else if(vis[(t1.id + 1) % n] != vis[(t2.id + 1) % n])
                    return Integer.compare(vis[(t1.id + 1) % n], vis[(t2.id + 1) % n]);
                else
                    return Integer.compare(t1.id, t2.id);
            }
        };*/
        class Tuple{
            long x, y;
            int id;
            Tuple(long x, long y, int id){
                this.x = x;
                this.y = y;
                this.id = id;
            }
        }
        int ni() {
            return in.nextInt();
        }
        long nl() {
            return in.nextLong();
        }
        void pn(Object o) {
            out.println(o);
        }
        void p(Object o) {
            out.print(o);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}