/**
 * Created by ankeet on 1/13/17.
 */
import java.io.*;
import java.util.*;

public class E102 {

    static FastReader in = null;
    static PrintWriter out = null;


    static long xc;
    static long yc;

    static boolean check(long M, long N){
        if(xc == 0 && yc == 0){
            return M == 0 && N == 0;
        }
        if(xc == 0){
            return M%yc==0 && N%yc ==0;
        }
        if(yc == 0){
            return M%xc==0 && N%xc == 0;
        }
        if((N*yc + M*xc) % (xc*xc + yc*yc) != 0) return false;
        long v = (N*yc + M*xc)/(xc*xc + yc*yc);
        return (xc*v-M) % yc == 0;
    }

    public static void solve()
    {
        long xa = in.nextInt();
        long ya = in.nextInt();
        long xb = in.nextInt();
        long yb = in.nextInt();
        xc = in.nextInt();
        yc = in.nextInt();

        boolean ans = check(xb-xa, yb-ya) || check(xb+ya,yb-xa) || check(xa+xb, ya+yb) || check(xb-ya,yb+xa);

        out.println(ans?"YES":"NO");


    }

    public static void main(String[] args)
    {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    static class FastReader {

        BufferedReader read;
        StringTokenizer tokenizer;

        public FastReader(InputStream in)
        {
            read = new BufferedReader(new InputStreamReader(in));
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try{
                    tokenizer = new StringTokenizer(read.readLine());
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public String nextLine(){

            try
            {
                return read.readLine();
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n)
        {
            int[] a = new int[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArr(int n)
        {
            long[] a = new long[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextLong();
            }
            return a;
        }
    }


}


