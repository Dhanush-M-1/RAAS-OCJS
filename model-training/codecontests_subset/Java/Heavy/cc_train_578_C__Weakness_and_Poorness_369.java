import java.io.*;
import java.util.*;

public class MainClass
{
    public static void main(String[] args)throws IOException
    {
        Reader in = new Reader();
        int n = in.nextInt();
        long[] A = new long[n];
        for (int i=0;i<n;i++)   A[i] = in.nextLong();
        double l = -100000.0d;
        double r =  100000.0d;
        int noOfIterations = 100;
        double ans = Double.MAX_VALUE;
        while (noOfIterations > 0)
        {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            double f1 = kadane(A, m1);
            double f2 = kadane(A, m2);
            if (f1 < f2)
            {
                ans = Math.min(ans, f1);
                r = m2;
            }
            else
                l = m1;
            noOfIterations--;
        }
        System.out.println(ans);
    }
    public static double kadane(long[] A, double x)
    {
        double[] B = new double[A.length];
        for (int i=0;i<A.length;i++) B[i] = A[i] - x;
        double maxSoFar = Double.MIN_VALUE;
        double maxEndingHere = 0.0d;
        double maxEndingHere1 = 0.0d;
        for (int i=0;i<B.length;i++)
        {
            maxEndingHere += B[i];
            maxEndingHere1 += B[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxSoFar = Math.max(maxSoFar, -maxEndingHere1);
            if (maxEndingHere < 0)
                maxEndingHere = 0.0d;
            if (maxEndingHere1 > 0)
                maxEndingHere1 = 0.0d;
        }
        return maxSoFar;
    }
}
class Reader
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
        }  while ((c = read()) >= '0' && c <= '9');

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
        do {
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

        do {
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
}