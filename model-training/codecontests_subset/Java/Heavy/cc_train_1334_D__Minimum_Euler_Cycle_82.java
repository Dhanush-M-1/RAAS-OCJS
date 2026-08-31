import java.util.*;
import java.io.*;

public class D1334 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			long l = sc.nextLong(), r = sc.nextLong();
			
			int i;
			long c = 0;
			for(i = 1; i < n; i++) {
				c += 2l * (n - i);
				if(l <= c) {
					c -= 2l * (n - i);
					break;
				}
			}
			
			if(i == n) {
				pw.println("1");
				continue;
			}
			
			long max = c + 2l * (n - i);
			StringBuilder sb = new StringBuilder("");
			for(long j = l; j <= r; j++) {
				if(j > max) {
					if(i == n - 1) {
						sb.append("1 ");
						break;
					} else {
						c += 2l * (n - i);
						i++;
						max += 2l * (n - i);
					}
				}
				if(j % 2 == 1) {
					sb.append(i + " ");
				} else {
					sb.append((i + (1l * (j - c) / 2)) + " ");
				}
			}
			
			pw.println(sb.substring(0, sb.length() - 1));
		}
		
		
		pw.flush();
	}

	public static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();
			return array;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++)
				array[i] = new Integer(nextInt());
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();
			return array;
		}

		public double[] nextDoubleArray(int n) throws IOException {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();
			return array;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
