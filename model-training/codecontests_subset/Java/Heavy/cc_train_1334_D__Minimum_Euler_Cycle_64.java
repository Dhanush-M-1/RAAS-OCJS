import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class D1334{
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
    void solve() throws IOException {
        int t=rd.nextInt();
        outer:
        while(t--!=0){
        int n=rd.nextInt();
        long l = rd.nextLong();
        long r=rd.nextLong();
        long pos=0;
        long ttt = n*1L*(n-1);
        if(l==r&&l==ttt+1){
            pw.println(1);
            continue outer;
        }
        long tempn = (long)Math.sqrt(ttt-l);
        if(ttt-(tempn*(tempn+1))>=l){
            tempn++;
        }
        long p=n-tempn;
        pos= ttt-(tempn*(tempn+1));
        for(long i=p;i<=n;i++){
            for(long j=i+1;j<=n;j++){
                pos++;
                if(pos>=l&&pos<=r){
                    pw.print(i+" ");
                }
                pos++;
                if(pos>=l&&pos<=r){
                    pw.print(j+" ");
                }
                if(pos>=r){
                    pw.println();
                    continue outer;
                }
            }
        }
        
        pw.println(1);
        }
    }
    
   
 
    Reader rd;
    PrintWriter pw;
    void run() throws IOException {
        rd = new Reader();
        pw=new PrintWriter(System.out);
        solve();
        pw.close();
    }
 
    public static void main(String[] args) throws IOException {
        new D1334().run();
    }
 
}