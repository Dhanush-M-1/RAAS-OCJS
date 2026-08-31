// Working program using Reader Class
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4
{
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

    public static void main(String[] args) throws IOException
    {
        Reader z=new Reader();
        int n=z.nextInt(), i, j, k, l;
        long[] a = new long[n];
        int[] b = new int[11];
        long mod=998244353L, sum=0, m, p, msum=0;
        for(i=0;i<n;i++){
            a[i]=z.nextLong();
            b[(a[i]+"").length()]++;
        }
        for(i=0;i<n;i++){
            p=a[i];
            for(l=1;l<=10;l++) {
                StringBuilder s1 = new StringBuilder(a[i]+"");
                StringBuilder s2 = new StringBuilder();
                j=s1.length();
                for(k=0;k<j-l;k++){
                    s2.append(s1.charAt(k));
                }
                if(s2.length()>0){
                    m=Long.parseLong(s2.toString());
                    m=m*2;
                    s2=new StringBuilder(m+"");
                }
                for (k = Math.max(j-l, 0); k < j; k++) {
                    s2.append(s1.charAt(k));
                    s2.append(s1.charAt(k));
                }
                a[i] = 0;
                for (k = 0; k < s2.length(); k++) {
                    a[i] = (a[i] * 10 + s2.charAt(k) - '0') % mod;
                }
                msum = (b[l]*a[i]) % mod;
                sum=(sum+msum)%mod;
                a[i]=p;
            }
        }
        System.out.println(sum);
    }
}