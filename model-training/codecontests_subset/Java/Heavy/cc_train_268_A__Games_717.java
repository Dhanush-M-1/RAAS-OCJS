import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class GFGss
{
    static int mod1 = (int) (1e9 + 7);
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
        public String nextString() throws IOException
        {
            String str00=scan.next();
            return str00;
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
    static boolean primeCheck(long num0)
    {
        boolean b1 = true;
        if(num0==1)
        {
            b1=false;
        }
        else
        {
            int num01 = (int) (Math.sqrt(num0)) + 1;
            me1: for (int i = 2; i < num01; i++)
            {
                if (num0 % i == 0)
                {
                    b1 = false;
                    break me1;
                }
            }
        }
        return b1;
    }
    static HashSet<Integer> primeDivisor(HashSet<Integer> hSet0,int num0)
    {
        boolean b1=primeCheck(num0);
        if(b1)
        {
            hSet0.add(num0);
        }
        else
        {
            for(int i=2;i*i<=num0;i++)
            {
                if(num0%i==0)
                {
                    hSet0.add(i);
                    while(num0%i==0)
                    {
                        num0 /= i;
                    }
                }
            }
            boolean b2=primeCheck(num0);
            if(b2)
            {
                hSet0.add(num0);
            }
        }
        return hSet0;
    }

    static long GCD (long num0,long num00)
    {
        BigInteger big1=BigInteger.valueOf(num0);
        BigInteger big2=BigInteger.valueOf(num00);
        big1=big1.gcd(big2);
        long num000=Long.parseLong(big1.toString());
        return num000;
    }

    static long power1 (long num0,long num00)
    {
        long res1 = 1;
        while (num00 > 0)
        {
            if (num00 % 2 != 0)
            {
                res1 = (res1 * (num0 % 100006)) % 1000016;
            }
            num0 *= num0;
            num0 %= 1000016;
            num00 /= 2;
        }
        return res1;
    }

    static HashSet<Integer> primeDivi(int num0)
    {
        HashSet<Integer> hSet1=new HashSet<>();
        int num00=(int)Math.sqrt(num0);
        hSet1.add(1);
        for(int i=2;i<num00+1;i++)
        {
            if(num0%i==0)
            {
                hSet1.add(i);
                hSet1.add(num0/i);
            }
        }
        return hSet1;
    }

    static long gcd(long num0,long num00)
    {
        if(num00==0)
        {
            return num0;
        }
        return gcd(num00,num0%num00);
    }

    static boolean findChar(char chr0,char[] chrArr0)
    {
        int len0=chrArr0.length;
        boolean bool0=false;
        me0: for(int i=0;i<len0;i++)
        {
            if(chrArr0[i]==chr0)
            {
                bool0=true;
                break me0;
            }
        }

        return bool0;
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        //PrintWriter writer=new PrintWriter(System.out);
        //Scanner r = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter33 out33=new OutputWriter33(System.out);

        int num1=r.nextInt();
        int[][] arr1=new int[num1][2];
        for(int i=0;i<num1;i++)
        {
            arr1[i][0]=r.nextInt();
            arr1[i][1]=r.nextInt();
        }

        int count1=0,res1=0;
        for(int i=0;i<num1;i++)
        {
            for(int j=0;j<num1;j++)
            {
                if(i!=j)
                {
                    if(arr1[i][0]==arr1[j][1])
                    {
                        count1++;
                    }
                }
            }
        }
        res1=count1;
        out33.print(res1+"");
        out33.close();
        r.close();
    }
}
class OutputWriter33
{
    BufferedWriter writer;

    public OutputWriter33(OutputStream stream)
    {
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void print(int i) throws IOException
    {
        writer.write(i + "");
    }

    public void println(int i) throws IOException
    {
        writer.write(i + "\n");
    }

    public void print(String s) throws IOException
    {
        writer.write(s + "");
    }

    public void println(String s) throws IOException
    {
        writer.write(s + "\n");
    }

    public void print(char[] c) throws IOException
    {
        writer.write(c);
    }

    public void close() throws IOException
    {
        writer.flush();
        writer.close();
    }
}