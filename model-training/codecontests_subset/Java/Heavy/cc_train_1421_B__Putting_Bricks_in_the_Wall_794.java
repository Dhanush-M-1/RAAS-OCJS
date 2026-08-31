import java.io.*;
import java.util.*;

public class Q1 {
	private void solve(Scan scan, Print print) throws Exception {
		int T = scan.nextInt();
		while (T-- > 0) 
		{
			int N=scan.nextInt();
			char arr[][]=new char[N][N];
			for(int i=0;i<N;i++)
			{
				arr[i]=scan.next('a');
			}
			StringBuilder ans=new StringBuilder();
			int count=0;
			if(arr[1][0]==arr[0][1])
			{
				if(arr[N-2][N-1]==arr[1][0])
				{
					count++;
					ans.append("\n"+(N-1)+" "+N);
				}
				if(arr[N-1][N-2]==arr[1][0])
				{
					count++;
					ans.append("\n"+N+" "+(N-1));
				}
				print.println(count+""+ans.toString());
			}
			else if(arr[N-2][N-1]==arr[N-1][N-2])
			{
				if(arr[1][0]==arr[N-2][N-1])
				{
					print.println("1\n2 1");
				}
				else
				{
					print.println("1\n1 2");
				}
			}
			else
			{
				if(arr[0][1]=='0')
				{
					ans.append("\n1 2");
				}
				else
				{
					ans.append("\n2 1");
				}
				if(arr[N-2][N-1]=='1')
				{
					ans.append("\n"+(N-1)+" "+N);
				}
				else
				{
					ans.append("\n"+N+" "+(N-1));
				}
				print.println("2"+ans.toString());
			}
		//	System.out.println(arr[N-2][N-1]==1);
		}
	}

	public static void main(String args[]) throws Exception {
		Scan scan = new Scan();
		Print print = new Print();
		Q1 o = new Q1();
		o.solve(scan, print);
		print.close();
	}

	public static class Print {
		private final BufferedWriter bw;

		public Print() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void println(int object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(int object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(long object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(long object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(boolean object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(boolean object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(Object object[]) throws IOException {
			print(Arrays.deepToString(object));
			bw.append("\n");
		}

		public void print(Object object[]) throws IOException {
			print(Arrays.deepToString(object));
		}

		public void close() throws IOException {
			bw.close();
		}
	}

	static class Scan {
		private byte[] buf = new byte[1024 * 1024 * 4];
		private int index;
		private InputStream in;
		private int total;

		public Scan() {
			in = System.in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int nextInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double nextDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			long c = scan();
			while (c <= ' ') {
				c = scan();
			}

			boolean neg = (c == '-');
			if (neg) {
				c = scan();
			}

			do {
				ret = ret * 10 + c - '0';
			} while ((c = scan()) >= '0' && c <= '9');

			if (neg) {
				return -ret;
			}
			return ret;
		}

		public String next() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n) || n == ' ') {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		public void next(int arr[]) throws IOException {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextInt();
			}
		}

		public void next(long arr[]) throws IOException {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextLong();
			}
		}

		public char[] next(char c) throws IOException {
			char arr[] = next().toCharArray();
			return arr;
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}
}