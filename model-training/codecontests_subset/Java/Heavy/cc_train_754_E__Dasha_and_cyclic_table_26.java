import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class e {
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n1 = in.nextInt(), m1 = in.nextInt();
		String[] rows = new String[n1];
		for (int i = 0; i < n1; i++) {
			rows[i] = in.next();
		}
		int n2 = in.nextInt(), m2 = in.nextInt();
		String[] prows = new String[n2];
		for (int i = 0; i < n2; i++) {
			prows[i] = in.next();
		}
		char[][] cs = new char[n2 + n1][m2 + m1];
		for (int i = 0; i < n1+n2; i++)
			for (int j = 0; j < m1+m2; j++)
				cs[i][j] = rows[i % n1].charAt(j % m1);
		char[][] ps = new char[n2][m2];
		for (int i = 0; i < n2; i++)
			for (int j = 0; j < m2; j++)
				ps[i][j] = prows[i].charAt(j);
		boolean[][] ans = match(cs, ps);
		for (int sr = 0; sr < n1; sr++) {
			for (int sc = 0; sc < m1; sc++) {
				out.print(ans[sr][sc] ? "1" : "0");
			}
			out.println();
		}
		out.close();
	}

	static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static final char wildcard = '?';
	static long[] ranVs;

	static {
		ranVs = new long[alphabet.length()];
		for (int j = 0; j < ranVs.length; j++) {
			ranVs[j] = (long) (Math.random() * 10000);
		}
	}

	static boolean[][] match(char[][] s, char[][] p) {
		int n1 = s.length, m1 = s[0].length;
		int n2 = p.length, m2 = p[0].length;
		boolean[][] ans = new boolean[n1][m1];
		for (boolean[] row : ans)
			Arrays.fill(row, true);
		long[][] sm = new long[n1][m1];
		long[][] pm = new long[n2][m2];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				sm[i][j] = ranVs[s[i][j] - 'a'];
			}
		}
		long hash = 0;
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < m2; j++) {
				char c = p[i][j];
				if (c != wildcard) {
					hash += ranVs[c - 'a'] * ranVs[c - 'a'];
					pm[n2 - 1 - i][m2 - 1 - j] = ranVs[p[i][j] - 'a'];
				}
			}
		}
		long[][] conv = FFT.multiply2(sm, pm);
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				ans[i][j] &= conv[i + n2 - 1][j + m2 - 1] == hash;
			}
		}
		return ans;
	}
	
	static class FFT {
		static final int maxk = 21, maxn = (1 << maxk) + 1; // maxk ~ log(maxn)
		//!!! Initialize wsr, wsi, rsr, rsi, ar, ai   to   new double[maxn] !!!
		//#
		static double[] wsr = new double[maxn],
				wsi = new double[maxn],
				rsr = new double[maxn],
				rsi = new double[maxn],
				ar  = new double[maxn],
				ai  = new double[maxn]; //$
		static int[] dp = new int[maxn];
		static int n, k;
		static int lastk = -1;

		static void fft(boolean rev) {
			if (lastk != k) {
				lastk = k;  dp[0] = 0;
				for (int i = 1, g = -1; i < n; i++) {
					if ((i & (i - 1)) == 0) g++;
					dp[i] = dp[i ^ (1 << g)] ^ (1 << (k - 1 - g));
				}
				wsr[1] = 1;
				wsi[1] = 0;
				for (int two = 0; two < k - 1; two++) {
					double a = Math.PI / n * (1 << (k - 1 - two));
					double curR = Math.cos(a), curI = Math.sin(a);
					int p2 = (1 << two), p3 = p2 * 2;
					for (int j = p2; j < p3; ++j) {
						wsr[j * 2] = wsr[j];
						wsi[j * 2] = wsi[j];
						wsr[j * 2 + 1] = wsr[j] * curR - wsi[j] * curI;
						wsi[j * 2 + 1] = wsr[j] * curI + wsi[j] * curR;
					}
				}
			}
			for (int i = 0; i < n; ++i) {
				int d = dp[i];
				if (i < d) {
					double tmp = ar[i];
					ar[i] = ar[d];
					ar[d] = tmp;
					tmp = ai[i];
					ai[i] = ai[d];
					ai[d] = tmp;
				}
			}
			if (rev) for (int i = 0; i < n; i++) ai[i] = -ai[i];
			for (int len = 1; len < n; len <<= 1) {
				for (int i = 0; i < n; i += len) {
					int wit = len;
					for (int it = 0, j = i + len; it < len; it++, i++, j++) {
						double tmpR = ar[j] * wsr[wit] - ai[j] * wsi[wit];
						double tmpI = ar[j] * wsi[wit] + ai[j] * wsr[wit];
						wit++;
						ar[j] = ar[i] - tmpR;
						ai[j] = ai[i] - tmpI;
						ar[i] += tmpR;
						ai[i] += tmpI;
					}
				}
			}
		}

		static long[] multiply(long[] _a, long[] _b) {
			int na = _a.length, nb = _b.length;
			for (k = 0, n = 1; n < na + nb - 1; n <<= 1, k++) {}
			for (int i = 0; i < n; ++i) {
				ar[i] = i < na ? _a[i] : 0;
				ai[i] = i < nb ? _b[i] : 0;
			}
			fft(false);
			ar[n] = ar[0];
			ai[n] = ai[0];
			double r_i = -1.0 / n / 4.0;
			for (int i = 0; i <= n - i; ++i) {
				double tmpR = ar[i] * ar[i] - ai[i] * ai[i];
				double tmpI = ar[i] * ai[i] * 2.0;
				tmpR -= ar[n - i] * ar[n - i] - ai[n - i] * ai[n - i];
				tmpI -= ar[n - i] * ai[n - i] * -2.0;
				ar[i] = -tmpI * r_i;
				ai[i] = tmpR * r_i;
				ar[n - i] = ar[i];
				ai[n - i] = -ai[i];
			}
			fft(true);
			long[] ans = new long[n];
			for (int i = 0; i < n; i++) ans[i] = Math.round(ar[i]);
			return ans;
		}
	    
	    static void fft2(double[][] real, double[][] imag, boolean inv) {
	        FFT.n = real[0].length;
	        FFT.k = Integer.numberOfTrailingZeros(FFT.n);
	        
	        for (int i = 0; i < real.length; i++) {
	            for (int j = 0; j < FFT.n; j++) { ar[j] = real[i][j];  ai[j] = imag[i][j]; }
	            fft(inv);
	            if(inv) {
	        		for(int m=0;m<FFT.n;m++) {
	        			FFT.ar[m] /= FFT.n;
	        			FFT.ai[m] /= -FFT.n;
	        		}
	            }
	            for (int j = 0; j < real[i].length; j++) { real[i][j] = ar[j];  imag[i][j] = ai[j]; }
	        }
	        FFT.n = real.length;
	        FFT.k = Integer.numberOfTrailingZeros(FFT.n);
	        for (int j = 0; j < real[0].length; j++) {
	            for (int i = 0; i < real.length; i++) { ar[i] = real[i][j];  ai[i] = imag[i][j]; }
	            fft(inv);
	            if(inv) {
	        		for(int m=0;m<FFT.n;m++) {
	        			FFT.ar[m] /= FFT.n;
	        			FFT.ai[m] /= -FFT.n;
	        		}
	            }
	            for (int i = 0; i < real.length; i++) { real[i][j] = ar[i];  imag[i][j] = ai[i]; }
	        }
	    }
	    static long[][] multiply2(long[][] a, long[][] b) {  
	        int n1 = Integer.highestOneBit(Math.max(a.length, b.length) - 1) << 2;
	        int n2 = Integer.highestOneBit(Math.max(a[0].length, b[0].length) - 1) << 2;
	        n1 = Math.max(n1, 1);  n2 = Math.max(n2, 1);

	        double[][] ar = new double[n1][n2];
	        double[][] ai = new double[n1][n2];
	        double[][] br = new double[n1][n2];
	        double[][] bi = new double[n1][n2];
	        for (int i = 0; i < a.length; i++) for(int j=0;j<a[i].length;j++) ar[i][j] = a[i][j];
	        for (int i = 0; i < b.length; i++) for(int j=0;j<b[i].length;j++) br[i][j] = b[i][j];

	        fft2(ar,ai,false); fft2(br,bi,false);
	        for (int i = 0; i < n1; i++) {
	            for(int j=0;j<n2;j++) {
	                double r1 = ar[i][j], r2 = br[i][j];
	                double i1 = ai[i][j], i2 = bi[i][j];
	                double real = r1 * r2 - i1 * i2;
	                ai[i][j] = i1 * r2+ i2*r1;
	                ar[i][j] = real;
	            }
	        }
	        fft2(ar,ai,true);  long[][] result = new long[n1][n2];
	        for (int i = 0; i < n1; i++)
	            for(int j=0;j<n2;j++) result[i][j] = Math.round(ar[i][j]);
	        return result;
	    }
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream i) {
			br = new BufferedReader(new InputStreamReader(i));
			st = new StringTokenizer("");
		}

		public String next() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			else
				st = new StringTokenizer(br.readLine());
			return next();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return new Long(next());
		}

		public double nextDouble() throws IOException {
			return new Double(next());
		}
	}
}