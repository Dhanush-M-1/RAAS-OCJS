import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
public class Main {
	static final long C =  1000000007;
	static final int CY = 1000000000;
	static final int INF = Integer.MAX_VALUE/2;
	StringBuilder sb;
	//セット
	class Set<F,S> {
		F f;
		S s;
		Set(F f, S s) {this.f = f;this.s = s;}
	}
	int[][] G;
	//Map<Integer,List<Integer>> Genb = new HashMap<>();
	//***/
	int V;
	int E;
	int Venb;
	int Eenb;
	long START_TIME;
	int GenbSize;//Genbグラフの1辺
	Random rand = new Random();
	int[][] DIR = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
	static class Path{int a,b,g;

	public Path(int a, int b, int g) {
		super();
		this.a = a;
		this.b = b;
		this.g = g;
	} @Override
	public String toString() {
		return String.format("%d %d %d", a,b,g);
	}}
	public void calc() {

		sb = new StringBuilder();


		//入力処理
		IO sc = new IO();
		String ss = sc.next();
		char[] s = ss.toCharArray();
		boolean ans = false;
		char[] a = "keyence".toCharArray();
		int index = 0;
		int num = 0;
		LOOP:for (int i=0; i < s.length; i++) {
			for (int t=i; t < s.length;t++) {
				if ((ss.substring(0,i) + ss.substring(t)).equals("keyence")){
					ans = true;
				break LOOP;
				}
			}
		}





		System.out.println(ans?"YES":"NO");
	}
	long count(String s) {
		long ret = 0;
		for (char c:s.toCharArray()) {
			ret += c <= '9'?c-'0': c - 'a'+10;
		}
		return ret;
	}
	public static double log2(double x) {
	    // 特殊な値
	    if (Double.isNaN(x) || x < 0.0) return Double.NaN;
	    if (x == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
	    if (x == 0.0) return Double.NEGATIVE_INFINITY;
	    // ここから
	    int k = Math.getExponent(x);
	    if (k < Double.MIN_EXPONENT) {
	        // 非正規化数は取扱い注意！
	        k = Math.getExponent(x * 0x1.0p52) - 52;
	    }
	    if (k < 0) {
	        k++;
	    }
	    double s = Math.scalb(x, -k);
	    final double LOG2_E = 1.4426950408889634;
	    return k + LOG2_E * Math.log(s);
	}

	//二次元配列のコピー
	public boolean[][] copyMap(boolean[][] map) {
		boolean[][] copy = new boolean[map.length][];
		for (int i=0; i < map.length; i++) {
			copy[i] = Arrays.copyOf(map[i], map[i].length);
		}
		return copy;
	}
	public boolean[][] copyMap(boolean[][] map,int r,int c,int nr,int nc) {
		boolean[][] copy =  Arrays.copyOf(map, map.length);

		copy[r] = Arrays.copyOf(map[r], map[r].length);
		copy[nr] = Arrays.copyOf(map[nr], map[nr].length);
		copy[r][c] = true;
		copy[nr][nc] = true;
		return copy;
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.calc();

	}
}
class IO extends PrintWriter {
	private final InputStream in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;

	public IO() { this(System.in);}
	public IO(InputStream source) { super(System.out); this.in = source;}
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		}else{
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}
	private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	private static boolean isNewLine(int c) { return c == '\n' || c == '\r';}
	public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	public boolean hasNextLine() { while(hasNextByte() && isNewLine(buffer[ptr])) ptr++; return hasNextByte();}
	public String next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public char[] nextCharArray(int len) {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		char[] s = new char[len];
		int i = 0;
		int b = readByte();
		while(isPrintableChar(b)) {
			if (i == len) {
				throw new InputMismatchException();
			}
			s[i++] = (char) b;
			b = readByte();
		}
		return s;
	}
	public String nextLine() {
		if (!hasNextLine()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(!isNewLine(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while(true){
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			}else if(b == -1 || !isPrintableChar(b)){
				return minus ? -n : n;
			}else{
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
			throw new NumberFormatException();
		}
		return (int) nl;
	}
	public char nextChar() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return (char) readByte();
	}
	public double nextDouble() { return Double.parseDouble(next());}
	public int[] nextIntArray(int n) { int[] a = new int[n]; for(int i=0;i<n;i++) a[i] = nextInt(); return a;}
	public long[] nextLongArray(int n) { long[] a = new long[n]; for(int i=0;i<n;i++) a[i] = nextLong(); return a;}
	public double[] nextDoubleArray(int n) { double[] a = new double[n]; for(int i=0;i<n;i++) a[i] = nextDouble(); return a;}
	public void nextIntArrays(int[]... a) { for(int i=0;i<a[0].length;i++) for(int j=0;j<a.length;j++) a[j][i] = nextInt();}
	public int[][] nextIntMatrix(int n,int m) { int[][] a = new int[n][]; for(int i=0;i<n;i++) a[i] = nextIntArray(m); return a;}
	public char[][] nextCharMap(int n,int m) { char[][] a = new char[n][]; for(int i=0;i<n;i++) a[i] = nextCharArray(m); return a;}
	public void close() { super.close(); try {in.close();} catch (IOException e) {}}
}