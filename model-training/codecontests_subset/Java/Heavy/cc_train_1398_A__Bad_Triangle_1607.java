import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public final class Solution {
    
 
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
	}	public static void main(String[] args) throws IOException{
		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out);
		int T=sc.nextInt();
		for(int t=0;t<T;t++){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
			    a[i]=sc.nextInt();
			}
			int x=a[0];
			int y=a[1];
			int z=a[n-1];
			if(x+y>z){
			    System.out.println("-1");
			}
			else{
			    System.out.println("1"+" "+"2"+" "+n);
			}
            }
    }
}
