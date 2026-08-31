import java.io.*;
import java.util.*;
import java.awt.image.BandedSampleModel;
import java.lang.reflect.Array;
import java.util.Scanner;
public class A {

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

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
         {
            int n = sc.nextInt();
            int k = sc.nextInt();
            //int t1=0;
            //int t2=0;
            int books[][] = new int[n][3];

             int alc=0;
             int bothc=0;
             int bobc=0;
            for(int j=0;j<n;j++)
            {
                books[j][0]=sc.nextInt();
                int x=sc.nextInt();
                books[j][1]=x;
                int y=sc.nextInt();
                books[j][2]=y;
                if(x==1&&y==0)
                {
                   alc++;
                }
                else if(x==0&&y==1)
                {
                    bobc++;
                }
                else if(x==1&&y==1)
                {
                    bothc++;
                }
            }
            int alice[]=new int[alc];
            int bob[]=new int[bobc];
            int both[]=new int[bothc];
            alc=0;
            bobc=0;
            bothc=0;
             for(int j=0;j<n;j++)
             {
                 //books[j]=sc.nextInt();
                 //int x=sc.nextInt();
                 //int y=sc.nextInt();
                 int x=books[j][1];
                 int y=books[j][2];
                 if(x==1&&y==0)
                 {
                     alice[alc]=books[j][0];
                     alc++;
                 }
                 else if(x==0&&y==1)
                 {
                     bob[bobc]=books[j][0];
                     bobc++;
                 }
                 else if(x==1&&y==1)
                 {
                     both[bothc]=books[j][0];
                     bothc++;
                 }
             }

            if(alice.length+both.length<k||bob.length+both.length<k)
            {
                System.out.println(-1);
            }
            else
            {
                long ans=0;
                int[] al=new int[alice.length];


                Arrays.sort(alice);
                Arrays.sort(bob);
                Arrays.sort(both);
                int ac=0;
                int bc=0;
                int boc=0;
                while(k>0) {
                    if (ac < alice.length && bc < bob.length && boc < both.length) {
                        if (alice[(ac)] + bob[(bc)] < both[(boc)]) {
                            ans = ans + alice[(ac)] + bob[(bc)];
                            ac++;
                            bc++;
                            k--;
                        } else {
                            ans = ans + both[(boc)];
                            boc++;
                            k--;
                        }
                    } else if (ac >= alice.length || bc >= bob.length) {
                        ans = ans + both[(boc)];
                        boc++;
                        k--;
                    } else {
                        ans = ans + alice[(ac)] + bob[(bc)];
                        ac++;
                        bc++;
                        k--;
                    }
                }
                System.out.println(ans);
            }

        }
    }
}
