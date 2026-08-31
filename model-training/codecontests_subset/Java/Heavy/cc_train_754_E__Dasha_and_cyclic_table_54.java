import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e {
	public static void main(String[] args) throws IOException {
		initFFT();
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
		long[][] conv = multiply2(sm, pm);
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				ans[i][j] &= conv[i + n2 - 1][j + m2 - 1] == hash;
			}
		}
		return ans;
	}
	static void initFFT() {
		was = new double[MAX_N];
		wbs = new double[MAX_N];
		for(int i=0;i<MAX_N;i++) {
			double angle = 2 * Math.PI / i;
			was[i] = Math.cos(angle);
			wbs[i] = Math.sin(angle);
		}
	}
	static double[] was,wbs;
	static int MAX_N = 2049;
	static void fft(double[] a, double[] b, boolean invert) {
		int count = a.length;
		for (int i = 1, j = 0; i < count; i++) {
			int bit = count >> 1;
			for (; j >= bit; bit >>= 1) {
				j -= bit;
			}
			j += bit;
			if (i < j) {
				double temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				temp = b[i];
				b[i] = b[j];
				b[j] = temp;
			}
		}
		for (int len = 2; len <= count; len <<= 1) {
			int halfLen = len >> 1;
//			double angle = 2 * Math.PI / len;
//			if (invert) {
//				angle = -angle;
//			}
			double wLenA = was[len];//Math.cos(angle);
			double wLenB = wbs[len];//Math.sin(angle);
			if(invert)
				wLenB = -wLenB;
			for (int i = 0; i < count; i += len) {
				double wA = 1;
				double wB = 0;
				for (int j = 0; j < halfLen; j++) {
					double uA = a[i + j];
					double uB = b[i + j];
					double vA = a[i + j + halfLen] * wA - b[i + j + halfLen] * wB;
					double vB = a[i + j + halfLen] * wB + b[i + j + halfLen] * wA;
					a[i + j] = uA + vA;
					b[i + j] = uB + vB;
					a[i + j + halfLen] = uA - vA;
					b[i + j + halfLen] = uB - vB;
					double nextWA = wA * wLenA - wB * wLenB;
					wB = wA * wLenB + wB * wLenA;
					wA = nextWA;
				}
			}
		}
		if (invert) {
			for (int i = 0; i < count; i++) {
				a[i] /= count;
				b[i] /= count;
			}
		}
	}

	static void fft2(double[][] real, double[][] imag, boolean inv) {
		double[] aReal = new double[real[0].length];
		double[] aImag = new double[imag[0].length];

		for (int i = 0; i < real.length; ++i) {
			for (int j = 0; j < real[i].length; ++j) {
				aReal[j] = real[i][j];
				aImag[j] = imag[i][j];
			}
			fft(aReal, aImag, inv);
			for (int j = 0; j < real[i].length; ++j) {
				real[i][j] = aReal[j];
				imag[i][j] = aImag[j];
			}
		}
		aReal = new double[real.length];
		aImag = new double[imag.length];
		for (int j = 0; j < real[0].length; ++j) {
			for (int i = 0; i < real.length; ++i) {
				aReal[i] = real[i][j];
				aImag[i] = imag[i][j];
			}
			fft(aReal, aImag, inv);
			for (int i = 0; i < real.length; ++i) {
				real[i][j] = aReal[i];
				imag[i][j] = aImag[i];
			}
		}
	}

	static long[][] multiply2(long[][] a, long[][] b) {

		int resultSize1 = Integer.highestOneBit(Math.max(a.length, b.length) - 1) << 2;
		int resultSize2 = Integer.highestOneBit(Math.max(a[0].length, b[0].length) - 1) << 2;
		resultSize1 = Math.max(resultSize1, 1);
		resultSize2 = Math.max(resultSize2, 1);

		double[][] aReal = new double[resultSize1][resultSize2];
		double[][] aImaginary = new double[resultSize1][resultSize2];
		double[][] bReal = new double[resultSize1][resultSize2];
		double[][] bImaginary = new double[resultSize1][resultSize2];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				aReal[i][j] = a[i][j];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[i].length; j++)
				bReal[i][j] = b[i][j];

		fft2(aReal, aImaginary, false);
		fft2(bReal, bImaginary, false);
		for (int i = 0; i < resultSize1; i++) {
			for (int j = 0; j < resultSize2; j++) {
				double r1 = aReal[i][j], r2 = bReal[i][j];
				double i1 = aImaginary[i][j], i2 = bImaginary[i][j];
				double real = r1 * r2 - i1 * i2;
				aImaginary[i][j] = i1 * r2 + i2 * r1;
				aReal[i][j] = real;
			}
		}
		fft2(aReal, aImaginary, true);
		long[][] result = new long[resultSize1][resultSize2];
		for (int i = 0; i < resultSize1; i++) {
			for (int j = 0; j < resultSize2; j++) {
				result[i][j] = Math.round(aReal[i][j]);
			}
		}
		return result;
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
