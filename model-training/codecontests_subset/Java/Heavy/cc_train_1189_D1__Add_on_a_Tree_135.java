import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class GFG770 {
    static int mod1 = (int) (1e9 + 7);

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextString() throws IOException {
            String str00 = scan.next();
            return str00;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        String next() throws IOException {
            int c;
            for (c = read(); c <= 32; c = read());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = read()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public int[] nextArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
    }


    static long GCD(long a, long b)
    {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }


    static long power(long x, long y, long p)
    {
        long res = 1;      // Initialize result

        x = x % p;  // Update x if it is more than or
        // equal to p

        while (y > 0)
        {
            // If y is odd, multiply x with result
            if (y%2!=0)
                res = (res*x) % p;

            // y must be even now
            y = y>>1; // y = y/2
            x = (x*x) % p;
        }
        return res;
    }


    static boolean primeCheck(long num0) {
        boolean b1 = true;
        if (num0 == 1) {
            b1 = false;
        } else {
            int num01 = (int) (Math.sqrt(num0)) + 1;
            me1:
            for (int i = 2; i < num01; i++) {
                if (num0 % i == 0) {
                    b1 = false;
                    break me1;
                }
            }
        }
        return b1;
    }

    public static int dev(long num1)
    {
        int count00=0;
        while (num1%2==0)
        {
            count00++;
            num1/=2;
        }
        HashMap<Long,Long> hashMap=new HashMap<>();
        if(count00!=0)
        {
            hashMap.put(2L,(long)count00);
        }
        for (int i = 3; i <= (int)Math.sqrt(num1); i = i + 2)
        {
            // While i divides n, print i and divide n
            if(num1%i==0) {
                int count01 = 0;

                while (num1 % i == 0) {
                    num1 /= i;
                    count01++;
                }
                hashMap.put((long)i,(long)count01);
            }
        }
        if(num1>2)
        {
            hashMap.put((long)num1,1L);
        }
        long numOfDiv=1;
        for(long num00:hashMap.keySet())
        {
            long cDiv0=hashMap.get(num00);
            numOfDiv*=(cDiv0+1);
        }

        return (int)(numOfDiv);
    }









    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        //PrintWriter writer=new PrintWriter(System.out);
        //Scanner r = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner r=new Scanner(System.in);
        OutputWriter770 out77 = new OutputWriter770(System.out);

        int num1=r.nextInt();
        int[] arr1=new int[num1+1];

        for(int i=0;i<num1-1;i++)
        {
            int u = r.nextInt();
            int v = r.nextInt();
            arr1[u]++;
            arr1[v]++;
        }

        String ans1="YES";
        me1: for(int i=1;i<num1+1;i++)
        {
            if(arr1[i]==2)
            {
                ans1="NO";
                break me1;
            }
        }
        out77.print(ans1+"");

        r.close();
        out77.close();
    }
}















class OutputWriter770
{
    BufferedWriter writer;

    public OutputWriter770(OutputStream stream)
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
