import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
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
            byte[] buf = new byte[256]; // line length
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
	
	static long power(long a,long k)
	{
		long m = 1000000007;
	    long ans=1;
	    long tmp=a%m;
	    while(k>0)
	    {
	        if(k%2==1)
	        	ans=ans*tmp%m;
	        tmp=tmp*tmp%m;
	        k>>=1;
	    }
	    return ans;
	}
	
	public static void main(String args[])throws IOException{
		Reader in = new Reader();
		Scanner sc = new Scanner(System.in);
		/*int n = in.nextInt();
		int[][] p = new int[n][5];
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			int e = in.nextInt();
			p[0][0]=a;
			p[0][1]=b;
			p[0][2]=c;
			p[0][3]=d;
			p[0][4]=e;
		}
		int s[][][] = new int[n][n][5];
		int m[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j)
					continue;
				s[i][j][0]=p[i][0]+p[j][0];
				s[i][j][1]=p[i][1]+p[j][1];
				s[i][j][2]=p[i][2]+p[j][2];
				s[i][j][3]=p[i][3]+p[j][3];
				s[i][j][4]=p[i][4]+p[j][4];
				m[i][j]=p[i][0]*p[j][0]+p[i][1]*p[j][1]+p[i][2]*p[j][2]+p[i][3]*p[j][3]+p[i][4]*p[j][4];
			}
		}
		for(int i=0;i<n;i++){
			
		}*/
		
		long ax = in.nextLong();
		long ay = in.nextLong();
		long bx = in.nextLong();
		long by = in.nextLong();
		long cx = in.nextLong();
		long cy = in.nextLong();
		if((by-ay)*(cx-bx)==(cy-by)*(bx-ax)){
			System.out.println("No");
			System.exit(0);
		}
		
		if((by-cy)*(by-cy)+(bx-cx)*(bx-cx)==(ay-by)*(ay-by)+(ax-bx)*(ax-bx))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	static int mod=1000000007;
}