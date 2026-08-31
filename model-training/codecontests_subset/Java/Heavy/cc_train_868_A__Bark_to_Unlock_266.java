import java.util.*;
import java.io.*;

public class A
{

    Reader in;
    PrintWriter out;
    int i = 0, j = 0;
    void solve()
    {
        
        //START// 
        String p = in.next();
        boolean c1 = false, c2 = false;
        int n = in.nextInt();
        String cur = "";
        for (i = 0; i < n; i++)
        {
            cur = in.next();
            if(cur.equals(p))
            {
                c1 = true;
                c2 = true;
            }
            else
            {
                if (cur.charAt(0) == p.charAt(1))
                    c1 = true;
                if (cur.charAt(1) == p.charAt(0))
                    c2 = true;
            }
        }
        if (c1 && c2)
            out.println("YES");
        else
            out.println("NO");







        //END
        
    }
    void runIO()
    {
        in = new Reader();
        out = new PrintWriter(System.out, false);
        solve();
        out.close();
    }

    public static void main(String[] args)
    {
        new A().runIO();
    }


    // input/output
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        

        public final String next()
        {
            int c = read();
            while (isSpaceChar(c))
            {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do
            {
                res.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c)
        {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt()
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong()
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble()
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.')
                while ((c = read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);
            if (neg)
                return -ret;
            return ret;
        }

        public int[] readIntArray(int size)
        {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = nextInt();
            return arr;
        }

        public long[] readLongArray(int size)
        {
            long[] arr = new long[size];
            for (int i = 0; i < size; i++)
                arr[i] = nextInt();
            return arr;
        }

        private void fillBuffer()
        {
            try
            {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            }
            catch (IOException e)
            {

            }
            
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read()
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
