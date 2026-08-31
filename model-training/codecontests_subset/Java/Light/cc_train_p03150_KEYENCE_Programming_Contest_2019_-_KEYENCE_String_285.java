import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
public class Main
{
    public static void main(String[]args)
    {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Solver solver = new Solver();
        int ca = 1;
        solver.solve(ca,in,out);
        out.close();
    }
    static class Solver
    {

        public void solve(int ca,InputReader in,PrintWriter out)
        {
            while(ca -- != 0)
            {

                String s = in.next();
                String temp = "keyence";
                if(s.contains(temp))
                {
                    out.println("YES");
                }
                else
                {
                    int n = s.length();
                    int flag = 0;
                    for(int i = 0;i<n;i++)
                    {
                        for(int j = n-1;j >= i;j--)
                        {
                            if( (s.substring(0,i) + s.substring(j)).equals(temp))
                            {
                                out.println("YES");
                                flag = 1;
                                break;
                            }
                        }
                        if(flag == 1) break;
                    }
                    if(flag == 0) out.println("NO");
                }


            }
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
        public BigInteger nextBigInteger()
        {
            return new BigInteger(next());
        }

    }
}