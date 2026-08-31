/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author PRAVEEN KUMAR SINGH
 */


    /**
     * @param args the command line arguments
     */
    public class JavaApplication2 { 
        // public static void main(String args[])throws IOException
//{BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

//Friend friends[] = new Friend[n];  
//friends[i] = new Friend(br.nextInt(), br.nextInt());
//List a1 = new ArrayList();
           /* Arrays.sort(friends,new Comparator<Friend>() {
			@Override
			public int compare(Friend x, Friend y) {
				if(x.s > y.s)return 1;
				else if(x.s < y.s) return -1;
				return 0;
			}
		});*/
        public static void main(String[] args) throws Exception{
Reader br=new Reader();
PrintWriter pw=new PrintWriter(System.out);
        int n=br.nextInt();
        int[] a=new int[n],b=new int[n-1],c=new int[n-2];
        for(int i=0;i<n;i++)
           a[i]=br.nextInt();
        Arrays.sort(a);
        
        for(int i=0;i<n-1;i++)
            b[i]=br.nextInt();
        Arrays.sort(b);
        for(int i=0;i<n;i++)
        {if(i==n-1)
            pw.println(a[n-1]);
        else if(a[i]!=b[i])
        {pw.println(a[i]);break;}
        }
        for(int i=0;i<n-2;i++)
            c[i]=br.nextInt();
        Arrays.sort(c);
        for(int i=0;i<n-1;i++)
        {if(i==n-2)
            pw.println(b[n-2]);
        else if(c[i]!=b[i])
        {pw.println(b[i]);break;}
        }
br.close();
pw.flush();
        }        
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
 public String next() throws IOException{
			StringBuilder sb = new StringBuilder();
			int n = read();
			while (isWhiteSpace(n))
				n = read();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = read();
			}
			return sb.toString();
		}
        public String readLine() throws IOException
        {
            int n = read();
			while (isWhiteSpace(n))
				n = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(n);
				n = read();
			} while (!isEndOfLine(n));
			return res.toString();
		}
           public boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
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
 
 
	
    
static class Friend implements Comparable<Friend>{
        int m;
        int s;

        public Friend(int x, int y) {
            this.m = x;
            this.s = y;
        }

        @Override
        public int compareTo(Friend o) {
            return Integer.compare(m, o.m);
        }
}}