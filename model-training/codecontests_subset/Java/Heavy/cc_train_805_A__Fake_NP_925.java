import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.rmi.activation.ActivationSystem;
import java.util.*;

/**
 * Created by hp on 5/18/2017.
 */

public class toto {

    public static PrintWriter out;
     public static InputReader in;

    public static void main(String[] args) {
        out= new PrintWriter(System.out);
        in=new InputReader(System.in);

        int l=in.nextInt();
        int r=in.nextInt();
        if(l==r)
        {
            out.println(l);
        }else
        {
            out.println("2");
        }





      out.close();
    }
    public static int bsearch(ArrayList<choco> app,int target)
    {
         int low=0;
         int high=app.size();
         int ans=0;
         while(low<=high)
         {
               int mid=low+(high-low)/2;
               if(app.get(mid).time<target)
               {
                    ans=app.get(mid).time;
                    low=mid+1;



               }else
                   high=mid-1;


         }
         return ans;



    }
    static class choco
    {
         int value;
         int time;

        public choco(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    public static long mod = 1000000007, inf = 100000000000000000l;
    public static long fac[],inv[];
    public static void cal()
    {
        fac = new long[1000005];
        inv = new long[1000005];
        fac[0]=1;
        inv[0]=1;
        for(int i=1; i<=1000000; i++)
        {
            fac[i]=(fac[i-1]*i)%mod;
            inv[i]=(inv[i-1]*modPow(i,mod-2,mod))%mod;

        }
    }
    public static long ncr(int n, int r)
    {

        return (((fac[n]*inv[r])%mod)*inv[n-r])%mod;
    }

    public static long modPow(long base, long exp, long mod) {
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }

        }

        return result;
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
