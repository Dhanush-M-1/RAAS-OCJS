import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class codeChef
{
    static int mod1 = (int) (1e9 + 7);

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

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
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

        public long nextLong() throws IOException
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
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
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
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }

        public int[] nextArray(int n) throws IOException
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = nextInt();
            }
            return a;
        }
    }

    static long power2(long x, long y, long p )
    {
        long res = 1;
        x = x % p;
        while (y > 0)
        {
            if((y & 1)==1)
            {
                BigInteger res0 = BigInteger.valueOf(res);
                res0=res0.multiply(BigInteger.valueOf(x));
                res0=res0.mod(BigInteger.valueOf(p));
                String str0=res0.toString();
                res=Long.parseLong(str0);
            }
            y = y >> 1;
            BigInteger res00=BigInteger.valueOf(x);
            res00=res00.multiply(BigInteger.valueOf(x));
            res00=res00.mod(BigInteger.valueOf(p));
            String ans00=res00.toString();
            x=Long.parseLong(ans00);

        }
        return res;
    }

    public static void main(String[] args) throws IOException
    {
        Reader r = new Reader();
        OutputWriter2 out1 = new OutputWriter2(System.out);
        int num1=r.nextInt();
        int[] arr1=r.nextArray(num1);
        String ans1="NO";
        int count1=0,count2=0;
        int sum1=0;
        for(int i=0;i<num1;i++)
        {
            if(arr1[i]==100)
            {
                count1=count1+1;
            }
            else
            {
                count2=count2+1;
                sum1=sum1+1;
            }
            sum1=sum1+1;
        }
        if(sum1%2==0)
        {
            if(count1>0 && count2>0)
            {
                ans1="YES";
            }
            else if(count1==0)
            {
                if(count2%2==0)
                {
                    ans1="YES";
                }
            }
            else if(count2==0)
            {
                if(count1%2==0)
                {
                    ans1="YES";
                }
            }
        }
        out1.print(ans1+"");
        out1.close();
    }
}

class OutputWriter2{
    BufferedWriter writer;

    public OutputWriter2(OutputStream stream){
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void print(int i) throws IOException {
        writer.write(i);
    }


    public void print(String s) throws IOException {
        writer.write(s);
    }

    public void print(char []c) throws IOException {
        writer.write(c);
    }
    public  void close() throws IOException {
        writer.close();
    }
}
