
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Graph {

	
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
			} while ((c = read()) >= '0' && c <= '9');
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
			} while ((c = read()) >= '0' && c <= '9');

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
	public static void main(String[] args) throws IOException {
		
		
		Reader scan=new Reader();
		int t=scan.nextInt();
		
		while(t-->0) {
			long n=scan.nextLong();
			long l=scan.nextLong();
			long r=scan.nextLong();
			
			D1334(n, l, r, 1, 1);
			System.out.println();
		}

	}
	
	public static void D1334(long n, long l, long r, long seg, long cur) {
		
		if(cur>r) return;
		
		if(seg==n) {
			System.out.print(1);
			return;
		}
		
		long t= 2*(n-seg);
		
		long hi= cur+t-1;
		
		
		if(hi<l) {
			D1334(n, l, r, seg+1, hi+1);
			return;
		}
		
		
		long i= l-cur+1;
		
		if(i%2==0) {
			System.out.print((seg+i/2)+" ");
			i++;
		}
		
		
		
		for(;i+cur-1<=Math.min(r,  hi);i++) {
			
			if(i%2!=0) System.out.print(seg+" ");
			else System.out.print((seg+i/2)+" ");
			
		}
		
		if(i==r+1) return;
		
		D1334(n, hi+1, r, seg+1, hi+1);
		
		
	}

}
