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

/*
5 7
qcezchs
hhedywq
wikywqy
qckrqzt
bqexcxz
3 3
???
yw?
?q?

2 2
cd
ab
3 3
aba
cdc
aba

 */
public class e {
	static void gen() {
		int n = 400, m = 400;
		System.out.println(n + " " +m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print('a');
			}
			System.out.println();
		}
		System.out.println(n + " " +m);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print('a');
			}
			System.out.println();
		}
		
		
	}
	public static void main(String[] args) throws IOException {
//		gen();
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int fullRows = in.nextInt(), fullCols = in.nextInt();
		String[] rows = new String[fullRows];
		for (int i = 0; i < fullRows; i++) {
			rows[i] = in.next();
		}
		int patternRows = in.nextInt(), patternCols = in.nextInt();
		String[] prows = new String[patternRows];
		for (int i = 0; i < patternRows; i++) {
			prows[i] = in.next();
		}
		char[][] cs = new char[patternRows+fullRows][patternCols + fullCols];
		for(int i=0;i<cs.length;i++)
			for(int j=0;j<cs[i].length;j++)
			cs[i][j] = rows[i%fullRows].charAt(j % fullCols);
		char[][] ps = new char[patternRows][patternCols];
		for(int i=0;i<ps.length;i++)
			for(int j=0;j<ps[i].length;j++)
				ps[i][j] = prows[i].charAt(j);
		boolean[][] ans = match(cs,ps);
		for (int sr = 0; sr < fullRows; sr++) {
			for (int sc = 0; sc < fullCols; sc++) {
				out.print(ans[sr][sc] ? '1' : '0');
			}
			out.println();
		}
		out.close();
	}

	static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static final char wildcard = '?';
	static long[][] ranVs;

	static {
		ranVs = new long[1][alphabet.length()];
		for (int i = 0; i < ranVs.length; i++) {
			for (int j = 0; j < ranVs[i].length; j++) {
				ranVs[i][j] = (long) (Math.random() * 10000);
			}
		}
	}

	static boolean[][] match(char[][] source, char[][] pattern) {
		boolean[][] ans = new boolean[source.length][source[0].length];
		for(boolean[]row : ans)
			Arrays.fill(row, true);
		long[][] sourceMat = new long[source.length][source[0].length];
		long[][] patternMat = new long[source.length][source[0].length];
		
		for (int id = 0; id < ranVs.length; id++) {
			for(int i=0;i<source.length;i++) {
				for(int j=0;j<source[i].length;j++) {
					sourceMat[i][j] = ranVs[id][source[i][j]-'a'];
				}
			}
			long hash = 0;
			for(int i=0;i<pattern.length;i++) {
				for(int j=0;j<pattern[i].length;j++) {
					char c = pattern[i][j];
					if (c != wildcard) {
						hash += ranVs[id][c - 'a'] * ranVs[id][c - 'a'];
						patternMat[pattern.length-1-i][pattern[i].length-1-j] = ranVs[id][pattern[i][j]-'a'];
					}
				}
			}
			long[][] conv = multiply2(sourceMat, patternMat);
			for(int i=0;i<source.length;i++) {
				for(int j=0;j<source[i].length;j++) {
					ans[i][j] &= conv[i+pattern.length-1][j+pattern[0].length-1] == hash;
				}
			}
		}
		return ans;
	}
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
            double angle = 2 * Math.PI / len;
            if (invert) {
                angle = -angle;
            }
            double wLenA = Math.cos(angle);
            double wLenB = Math.sin(angle);
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
            fft(aReal,aImag, inv);
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
            fft(aReal,aImag, inv);
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
            for(int j=0;j<a[i].length;j++)
            	aReal[i][j] = a[i][j];
        for (int i = 0; i < b.length; i++)
            for(int j=0;j<b[i].length;j++)
            	bReal[i][j] = b[i][j];

        fft2(aReal,aImaginary,false);
        fft2(bReal,bImaginary,false);
        for (int i = 0; i < resultSize1; i++) {
        	for(int j=0;j<resultSize2;j++) {
        		double r1 = aReal[i][j], r2 = bReal[i][j];
        		double i1 = aImaginary[i][j], i2 = bImaginary[i][j];
	            double real = r1 * r2 - i1 * i2;
	            aImaginary[i][j] = i1 * r2+ i2*r1;
	            aReal[i][j] = real;
        	}
        }
        fft2(aReal,aImaginary,true);
        long[][] result = new long[resultSize1][resultSize2];
        for (int i = 0; i < resultSize1; i++) {
        	for(int j=0;j<resultSize2;j++) {
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
