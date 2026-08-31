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
			ranVs[j] = (long) (Math.random() * 10000)+1;
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
	// SET maxk appropriately!!! ~log(maxn) //%
	static class FFT {
	    static final int maxk = 21, maxn = (1 << maxk) + 1;
	    // Init: wR, wI, rR, rI, aR, aI   to   new double[maxn] !!!
	    //#
	    static double[] wR = new double[maxn],
	            wI = new double[maxn],
	            rR = new double[maxn],
	            rI = new double[maxn],
	            aR  = new double[maxn],
	            aI  = new double[maxn]; //$
	    static int n, k, lastk = -1, dp[] = new int[maxn];

	    static void fft(boolean inv) {
	        if (lastk != k) {
	            lastk = k;  dp[0] = 0;
	            for (int i = 1, g = -1; i < n; i++) {
	                if ((i & (i - 1)) == 0) g++;
	                dp[i] = dp[i ^ (1 << g)] ^ (1 << (k - 1 - g));
	            }
	            wR[1] = 1;
	            wI[1] = 0;
	            for (int t = 0; t < k - 1; t++) {
	                double a = Math.PI / n * (1 << (k - 1 - t));
	                double curR = Math.cos(a), curI = Math.sin(a);
	                int p2 = (1 << t), p3 = p2 * 2;
	                for (int j = p2, k = j * 2; j < p3; j++, k += 2) {
	                    wR[k] = wR[j];
	                    wI[k] = wI[j];
	                    wR[k + 1] = wR[j] * curR - wI[j] * curI;
	                    wI[k + 1] = wR[j] * curI + wI[j] * curR;
	                }
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            int d = dp[i];
	            if (i < d) {
	                double tmp = aR[i];
	                aR[i] = aR[d];
	                aR[d] = tmp;
	                tmp = aI[i];
	                aI[i] = aI[d];
	                aI[d] = tmp;
	            }
	        }
	        if (inv) for (int i = 0; i < n; i++) aI[i] = -aI[i];
	        for (int len = 1; len < n; len <<= 1) {
	            for (int i = 0; i < n; i += len) {
	                int wit = len;
	                for (int it = 0, j = i + len; it < len; it++, i++, j++) {
	                    double tmpR = aR[j] * wR[wit] - aI[j] * wI[wit];
	                    double tmpI = aR[j] * wI[wit] + aI[j] * wR[wit];
	                    wit++;
	                    aR[j] = aR[i] - tmpR;
	                    aI[j] = aI[i] - tmpI;
	                    aR[i] += tmpR;
	                    aI[i] += tmpI;
	                }
	            }
	        }
	    }
	    static long[] multiply(long[] a, long[] b) {
	        int na = a.length, nb = b.length;
	        for (k = 0, n = 1; n < na + nb - 1; n <<= 1, k++) {}
	        for (int i = 0; i < n; ++i) {
	            aR[i] = i < na ? a[i] : 0;
	            aI[i] = i < nb ? b[i] : 0;
	        }
	        fft(false);
	        aR[n] = aR[0];
	        aI[n] = aI[0];
	        double q = -1.0 / n / 4.0;
	        for (int i = 0; i <= n - i; ++i) {
	            double tmpR = aR[i] * aR[i] - aI[i] * aI[i];
	            double tmpI = aR[i] * aI[i] * 2;
	            tmpR -= aR[n - i] * aR[n - i] - aI[n - i] * aI[n - i];
	            tmpI -= aR[n - i] * aI[n - i] * -2;
	            aR[i] = -tmpI * q;
	            aI[i] = tmpR * q;
	            aR[n - i] = aR[i];
	            aI[n - i] = -aI[i];
	        }
	        fft(true);
	        long[] ans = new long[n = na + nb - 1]; // ONLY MOD IF NEEDED
	        for (int i = 0; i < n; i++) ans[i] = Math.round(aR[i]);
	        return ans;
	    }
	    static void fft2(double[][] xr, double[][] xi, boolean inv) {
	        n = xr[0].length;
	        k = Integer.numberOfTrailingZeros(n);
	        for (int i = 0; i < xr.length; i++) {
	            for (int j = 0; j < n; j++) { aR[j] = xr[i][j];  aI[j] = xi[i][j]; }
	            fft(inv);
	            for (int j=0;j<n;j++){xr[i][j] = aR[j] / (inv ? n : 1);  xi[i][j] = aI[j] / (inv ? -n : 1);}
	        }
	        n = xr.length;
	        k = Integer.numberOfTrailingZeros(n);
	        for (int j = 0; j < xr[0].length; j++) {
	            for (int i = 0; i < n; i++) { aR[i] = xr[i][j];  aI[i] = xi[i][j]; }
	            fft(inv);
	            for (int i=0;i<n;i++){xr[i][j] = aR[i] / (inv ? n : 1);  xi[i][j] = aI[i] / (inv ? -n : 1);}
	        }
	    }
	    static long[][] multiply2(long[][] a, long[][] b) {
	        int n1, n2;
	        for (n1 = 1; n1 < a.length + b.length - 1; n1 <<= 1) {}
	        for (n2 = 1; n2 < a[0].length + b[0].length - 1; n2 <<= 1) {}
	        double[][] ar = new double[n1][n2], ai = new double[n1][n2];
	        double[][] br = new double[n1][n2], bi = new double[n1][n2];
	        for (int i = 0; i < a.length; i++) for(int j=0;j<a[i].length;j++) ar[i][j] = a[i][j];
	        for (int i = 0; i < b.length; i++) for(int j=0;j<b[i].length;j++) br[i][j] = b[i][j];
	        fft2(ar,ai,false); fft2(br,bi,false);
	        for (int i = 0; i < n1; i++) {
	            for(int j = 0; j < n2; j++) {
	                double r1 = ar[i][j], r2 = br[i][j];
	                double i1 = ai[i][j], i2 = bi[i][j];
	                double real = r1 * r2 - i1 * i2;
	                ai[i][j] = i1 * r2+ i2*r1;
	                ar[i][j] = real;
	            }
	        }
	        fft2(ar,ai,true);  long[][] result = new long[n1=a.length+b.length-1][n2=a[0].length+b[0].length-1];
	        for (int i = 0; i < n1; i++)
	            for(int j = 0; j < n2; j++) result[i][j] = Math.round(ar[i][j]);
	        return result;
	    }
	    // To use: FFT both, product, iFFT (n is next power of 2)
	    static long[] fftOr(long[] arr, int n, boolean invert) {
	        long[] ans = Arrays.copyOf(arr, n);
	        for (int b = 1; b < n; b <<= 1)
	            for (int i = 0; i < n; i++) {
	                if ((i & b) != 0) continue;
	                ans[i + b] += invert ? -ans[i] : ans[i];
	            }
	        return ans;
	    }
	    static long[] fftXor(long[] arr, int n, boolean invert) {
	        long[] ans = Arrays.copyOf(arr, n);
	        for (int b = 1; b < n; b <<= 1)
	            for (int i = 0; i < n; i++) {
	                if((i & b) != 0) continue;
	                long u = ans[i], v = ans[i+b];
	                ans[i] = u + v;  ans[i + b] = u - v;
	            }
	        if (invert) for (int i = 0; i < n; i++) ans[i] /= n;
	        return ans;
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