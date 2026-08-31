
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.*;

public class E {
	private static final int mod = (int)1e9+7;

	final Random random = new Random(0);
	final IOFast io = new IOFast();

	int[] cnt = new int[10];
	int[] len = new int[10];
	int[][] pos = new int[10][];
	int[] map = new int[8*8];
	long[] ans = new long[6];
	
	boolean dfs(long v, long idx) {
		if(v == 0) return true;
		if(v < 0 || idx * 4 > v) return false;
		int k = (int)(v / idx % 10);
		
		for(int x : pos[k]) {
			if(dfs(v - map[x] * idx, idx * 10)) {
				final int i4 = x / 8;
				final int i7 = x % 8;
				for(int i = 0; i < i4; i++) { ans[i] += idx * 4; }
				for(int i = 0; i < i7; i++) { ans[i+i4] += idx * 7; }
				return true;
			}
		}
		return false;
	}
	
	public void run() throws IOException {
		for(int i = 0; i <= 6; i++){
			for(int j = 0; i + j <= 6; j++) {
				int v = 0;
				for(int k = 0; k < i; k++) v += 4;
				for(int k = 0; k < j; k++) v += 7;
				cnt[v%10]++;
			}
		}
		for(int i = 0; i < 10; i++) pos[i] = new int[cnt[i]];
		for(int i = 0; i <= 6; i++){
			for(int j = 0; i + j <= 6; j++) {
				int v = 0;
				for(int k = 0; k < i; k++) v += 4;
				for(int k = 0; k < j; k++) v += 7;
				pos[v%10][len[v%10]++] = i * 8 + j;
				map[i*8+j] = v;
			}
		}
		
		int t = io.nextInt();
		for(int i = 0; i < t; i++) {
			long v = io.nextLong();
			Arrays.fill(ans, 0);
			if(dfs(v, 1)) {
				for(int j = 0; j < 6; j++) {
					io.out.print(ans[j] + (j==5?"\n":" "));
				}
			}
			else {
				io.out.println(-1);
			}
		}
	}

	static void arrayIntSort(int[][] x, int key) {
		Arrays.sort(x, new IntArrayComparator(key));
	}
	
	static class IntArrayComparator implements Comparator<int[]> {
		final int KEY;
		
		public IntArrayComparator(int key) {
			KEY = key;
		}
		
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[KEY] - o2[KEY];
		}
	}
	
	void main() throws IOException {
		//		IOFast.setFileIO("rle-size.in", "rle-size.out");
		try {
			run();
		}
		catch (EndOfFileRuntimeException e) { }
		io.out.flush();
	}

	public static void main(String[] args) throws IOException {
		new E().main();
	}
	
	static class EndOfFileRuntimeException extends RuntimeException {
		private static final long serialVersionUID = -8565341110209207657L; }

	static
	public class IOFast {
		private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		private PrintWriter out = new PrintWriter(System.out);

		void setFileIO(String ins, String outs) throws IOException {
			in = new BufferedReader(new FileReader(ins));
			out = new PrintWriter(new FileWriter(outs));
		}

		//		private static final int BUFFER_SIZE = 50 * 200000;
		private static int pos, readLen;
		private static final char[] buffer = new char[1024 * 8];
		private static final char[] str = new char[500000*8*2];
		private static boolean[] isDigit = new boolean[256];
		private static boolean[] isSpace = new boolean[256];
		private static boolean[] isLineSep = new boolean[256];

		static {
			for(int i = 0; i < 10; i++) { isDigit['0' + i] = true; }
			isDigit['-'] = true;
			isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
			isLineSep['\r'] = isLineSep['\n'] = true;
		}

		public int read() throws IOException {
			if(pos >= readLen) {
				pos = 0;
				readLen = in.read(buffer);
				if(readLen <= 0) { throw new EndOfFileRuntimeException(); }
			}
			return buffer[pos++];
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(nextString());
		}

		public char nextChar() throws IOException {
			while(true) {
				final int c = read();
				if(!isSpace[c]) { return (char)c; }
			}
		}
		
		int reads(char[] cs, int len, boolean[] accept) throws IOException {
			try {
				while(true) {
					final int c = read();
					if(accept[c]) { break; }
					cs[len++] = (char)c;
				}
			}
			catch(EndOfFileRuntimeException e) { ; }
			
			return len;
		}

		public char[] nextLine() throws IOException {
			int len = 0;
			str[len++] = nextChar();
			len = reads(str, len, isLineSep);
			
			try {
				if(str[len-1] == '\r') { len--; read(); }
			}
			catch(EndOfFileRuntimeException e) { ; }
			
			return Arrays.copyOf(str, len);
		}

		public String nextString() throws IOException {
			return new String(next());
		}

		public char[] next() throws IOException {
			int len = 0;
			str[len++] = nextChar();
			len = reads(str, len, isSpace);
			return Arrays.copyOf(str, len);
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(nextString());
		}

		public long[] nextLongArray(final int n) throws IOException {
			final long[] res = new long[n];
			for(int i = 0; i < n; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public int[] nextIntArray(final int n) throws IOException {
			final int[] res = new int[n];
			for(int i = 0; i < n; i++) {
				res[i] = nextInt();
			}
			return res;
		}

		public int[][] nextIntArray2D(final int n, final int k) throws IOException {
			final int[][] res = new int[n][];
			for(int i = 0; i < n; i++) {
				res[i] = nextIntArray(k);
			}
			return res;
		}

		public double[] nextDoubleArray(final int n) throws IOException {
			final double[] res = new double[n];
			for(int i = 0; i < n; i++) {
				res[i] = nextDouble();
			}
			return res;
		}

	}

}
