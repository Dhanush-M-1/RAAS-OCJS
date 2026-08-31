import java.util.*;
import java.io.*;
import java.awt.Point;
import java.math.BigInteger;

public class compression {
	
	static int matrix[][];
	static int[][] prefix;
	static int[] map = new int[256];
	
	public static void main(String[] args) throws Exception {
		FastIO sc = new FastIO(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int N = sc.nextInt();
		matrix = new int[N][N];
		prefix = new int[N+1][N+1];
		
		int a = 0;
		int b = 0;
		
		map['0'] = 0;
		map['1'] = 1;
		map['2'] = 2;
		map['3'] = 3;
		map['4'] = 4;
		map['5'] = 5;
		map['6'] = 6;
		map['7'] = 7;
		map['8'] = 8;
		map['9'] = 9;
		map['A'] = 10;
		map['B'] = 11;
		map['C'] = 12;
		map['D'] = 13;
		map['E'] = 14;
		map['F'] = 15;
		
		
		for(int c = 0; c < N; c++) {
			char[] digits = sc.next().toCharArray();
			
			for(int d = 0; d < N/4; d++) {
				int dig = map[digits[d]];
				for(int e = 3; e >= 0; e--) {
					if(((1 << e) & dig) > 0) {
						matrix[a][b] = 1;
					}
					
					a++;
					if(a >= N) {
						a = 0;
						b++;
					}
				}
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				prefix[i+1][j+1] = matrix[i][j];
			}
		}
		
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < N+1; j++) {
				if(i > 0) prefix[i][j] += prefix[i-1][j];
				if(j > 0) prefix[i][j] += prefix[i][j-1];
				if(i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
			}
		}
		
		for(int max = N; max >= 1; max--) {
			if(N % max == 0) {
				boolean good = true;
				for(int i = 0; i < N/max; i++) {
					for(int j = 0; j < N/max; j++) {
						int num = query(i*max+1, j*max+1, (i+1)*max, (j+1)*max);
						if(!(num == max*max || num == 0)) {
							good = false;
							break;
						}
					}
				}
				
				if(good) {
					pw.println(max);
					pw.close();
					System.exit(0);
				}
			}
		}
		
	}
	
	static int query(int a, int b, int c, int d) {
		return prefix[c][d] - prefix[a-1][d] - prefix[c][b-1] + prefix[a-1][b-1]; 
	}

	static class FastIO {

		//Is your Fast I/O being bad?

		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;

		public FastIO(String fileName) throws Exception {
			dis = new FileInputStream(fileName);
		}

		public FastIO(InputStream is) throws Exception {
			dis = is;
		}

		int nextInt() throws Exception {
			int ret = 0;

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}

			return (negative) ? -ret : ret;
		}

		long nextLong() throws Exception {
			long ret = 0;

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}

			return (negative) ? -ret : ret;
		}

		byte nextByte() throws Exception {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}

		String next() throws Exception {
			StringBuffer ret = new StringBuffer();

			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}

			return ret.toString();
		}

	}
}
