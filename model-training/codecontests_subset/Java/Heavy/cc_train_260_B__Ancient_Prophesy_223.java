import java.io.*;
import java.util.*;

public class B{

	//public static Reader sc = new Reader();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("input.in"));
		int[] mo = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		HashMap<String,  Integer> hm =  new HashMap<String, Integer>();
		String s = br.readLine();
		for (int i = 0; i <= s.length()-10; i++) {
			String str = s.substring(i,i+10);
			boolean works = true;
			
			if (str.charAt(2) == '-' && str.charAt(5) == '-') {
				
			}
			else works = false;
			
			for (int j = 0; j < 10; j++) {
				if (j == 2 || j == 5) {
				}
				else if (str.charAt(j) == '-') {
					works = false;
				}
			}
			
			if (str.substring(6,9).equals("201")) {
				if (str.charAt(9) >= '3' && str.charAt(9) <= '5') {
					
				}
				else works = false;
			}
			else works = false;
			
			if (works) {
				int month = Integer.parseInt(str.substring(3,5));
				int day = Integer.parseInt(str.substring(0, 2));
				if (month >= 1 && month <= 12 && day >= 1) {
					if (day <= mo[month-1]) {
						
					}
					else works = false;
				}
				else works = false;
			}
			
			if (works) {
				//System.out.println(str);
				if (!hm.containsKey(str)) hm.put(str, 0);
				hm.put(str, hm.get(str)+1);
			}
		}
		int val = 0;
		String res = "";
		for (Map.Entry<String, Integer> e: hm.entrySet()) {
			if (e.getValue() > val) {
				res = e.getKey();
				val = e.getValue();
			}
		}
		out.println(res);

		out.close();
	}

	static long ceil(long a, long b) {
		return (a + b - 1) / b;
	}

	static long powMod(long base, long exp, long mod) {
		if (base == 0 || base == 1)
			return base;
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base % mod;
		long R = powMod(base, exp / 2, mod) % mod;
		R *= R;
		R %= mod;
		if ((exp & 1) == 1) {
			return base * R % mod;
		} else
			return R % mod;
	}

	static long pow(long base, long exp) {
		if (base == 0 || base == 1)
			return base;
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		long R = pow(base, exp / 2);
		if ((exp & 1) == 1) {
			return R * R * base;
		} else
			return R * R;
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

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					break;
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, Integer.max(cnt - 1, 0));
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

	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}