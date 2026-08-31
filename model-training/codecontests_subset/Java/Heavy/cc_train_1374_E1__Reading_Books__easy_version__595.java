import java.io.*;
import java.util.*;

public class check5 {

    public static void main(String[] args) throws IOException{

        Reader sc=new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int n=sc.nextInt();
        long k=sc.nextLong();

        long a[][]=new long[n][3];
        ArrayList<Long> al=new ArrayList<>();
        ArrayList<Long> bob=new ArrayList<>();
        ArrayList<Long> both=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            a[i][0]=sc.nextLong();
            a[i][1]=sc.nextLong();
            a[i][2]=sc.nextLong();

            if(a[i][1]==1)
            {
                if(a[i][2]==1) both.add(a[i][0]);
                else al.add(a[i][0]);
            }
            else if(a[i][2]==1) bob.add(a[i][0]);

        }
        Collections.sort(al,Collections.reverseOrder());
        Collections.sort(bob,Collections.reverseOrder());
        Collections.sort(both,Collections.reverseOrder());

        if(al.size()+both.size()<k || bob.size()+both.size()<k)
        {
            System.out.println(-1);
            return;
        }
        int ac=0;
        int bc=0;
        long ans=0;
        //System.out.println(al+""+bob+both);
        while(ac<k && bc<k)
        {
            int t1=al.size()-1;
            int t2=bob.size()-1;
            int t3=both.size()-1;

            if(t1>=0 && t2>=0 && t3>=0  && (al.get(t1)+bob.get(t2))>=both.get(t3))
            {
                ans=ans+both.get(t3);
                both.remove(t3);
            }
            else if(t1<0 || t2<0)
            {
                ans+=both.get(t3);
                both.remove(both.size()-1);
            }
            else// if(t3<0)
            {
                ans+=al.get(t1)+bob.get(t2);
                al.remove(t1);
                bob.remove(t2);
            }
           ac+=1;
            bc+=1;
        }
        System.out.println(ans);


        out.flush();
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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

        public String nextLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() throws IOException{
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

    }

}