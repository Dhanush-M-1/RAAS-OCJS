
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		FastIO io = new FastIO();
		int N = io.nextInt(), M = io.nextInt();
		IntRange[] R = new IntRange[N + 1];
		for (int i = 0;i < N;++ i) R[i] = IntRange.closed(io.nextInt(), io.nextInt());
		R[N] = IntRange.closed(0, Integer.MAX_VALUE / 2);
		Arrays.sort(R, Comparator.comparing(IntRange::getDistance));
		DualSegmentTree<Integer> segment = new DualSegmentTree<>(M + 1, 0, new Addition());
		int pos = 0;
		for (int i = 1;i <= M;++ i) {
			int ans = 0;
			while (R[pos].getDistance() < i) segment.update(1, R[pos++]);
			for (int j = 1;j <= M / i;++ j) ans += segment.get(i*j);
			io.println(N + ans - pos);
		}
		io.flush();
	}

	public interface Associative<T> {
		public T operate(T left, T right);
	}

	public interface RangeOperate<T, E> {
		public T function(T element, E reaction,  int N);
	}

	public interface Commutative<T> {

	}

	public interface Unit<T> {
		public T unit();
	}

	public interface Monoid<T> extends Associative<T>, Unit<T> {

	}

	public interface Inverse<T> {
		public T inverse(T element);
	}

	public interface Group<T> extends Monoid<T>, Inverse<T>{

	}

	public interface Abelian<T> extends Group<T>, Commutative<T> {

	}

	public static class Addition implements Abelian<Integer>, RangeOperate<Integer, Integer>{

		@Override
		public Integer operate(Integer left, Integer right) {
			return left + right;
		}

		@Override
		public Integer unit() {
			return 0;
		}

		@Override
		public Integer inverse(Integer element) {
			return -element;
		}

		@Override
		public Integer function(Integer element, Integer reaction, int N) {
			return element + reaction * N;
		}

	}

	public interface SegmentTreeInterface<T, E> {
		public void update(E dat, int index);
		public void update(E dat, int left, int right);
		public default void update(E dat, IntRange range) {
			update(dat, range.getClosedLower(), range.getOpenUpper());
		}
		public T[] get();
		public T get(int index);
		public T get(int left, int right);
		public default T get(IntRange range) {
			return get(range.getClosedLower(), range.getOpenUpper());
		}
		public int lowerBound(T compare, Comparator<T> comparator);
		public int upperBound(T compare, Comparator<T> comparator);
		public int size();
	}

	/**
	 * 双対セグメント木です。<br>
	 * 範囲更新をO(logN)、1点取得をO(logN)でできるデータ構造です。
	 * @author 31536000
	 *
	 * @param <T> 範囲更新及び1点取得を行いたいクラス
	 */
	public class DualSegmentTree<T> implements SegmentTreeInterface<T, T>{
		private Associative<T> semigroup; // 演算関数
		private T dat[]; // データ
		private int size;

		/**
		 * 双対セグメント木を構築します。
		 * @param N 要素数
		 * @param dat 初期値
		 * @param semigroup 演算関数
		 */
		public DualSegmentTree(int N, T dat, Associative<T> semigroup) {
			this.semigroup = semigroup;
			@SuppressWarnings("unchecked")
			T[] data = (T[]) new Object[N];
			Arrays.fill(data, dat);
			build(data);
		}

		/**
		 * 双対セグメント木を構築します。
		 * @param dat 初期値
		 * @param semigroup 演算関数
		 */
		public DualSegmentTree(T[] dat, Associative<T> semigroup) {
			this.semigroup = semigroup;
			build(dat);
		}

		/**
		 * 双対セグメント木を構築します。
		 * @param N 要素数
		 * @param dat 初期値
		 * @throws ClassCastException 演算関数が定義されていなければ返す
		 */
		@SuppressWarnings("unchecked")
		public DualSegmentTree(int N, T dat) throws ClassCastException {
			this(N, dat, (Associative<T>)dat);
		}

		/**
		 * 双対セグメント木を構築します。
		 * @param dat 初期値
		 * @throws ClassCastException 演算関数が定義されていなければ返す
		 */
		@SuppressWarnings("unchecked")
		public DualSegmentTree(T dat[]) throws ClassCastException {
			this(dat, (Associative<T>)dat[0]);
		}

		@SuppressWarnings("unchecked")
		private void build(T dat[]) { // セグ木を配列として作成
			size = dat.length;
			this.dat = (T[])new Object[Integer.highestOneBit(dat.length - 1) << 2]; // 要素数を超える最小の2冪*2
			System.arraycopy(dat, 0, this.dat, this.dat.length >> 1, dat.length); // 最下段を埋める
		}

		private T operate(T left, T right) { // 演算関数
			if (right == null) return left; // 右がnullの可能性の方がはるかに高いので
			else if (left == null) return right;
			else return semigroup.operate(left, right);
		}

		private void lazy(int index) {
			dat[index << 1] = operate(dat[index << 1], dat[index]);
			dat[index << 1 | 1] = operate(dat[index << 1 | 1], dat[index]);
			dat[index] = null;
		}

		/**
		 * データを更新します
		 * @param data 更新するデータ
		 * @param left 更新する場所の左閉区間
		 * @param right 更新する場所の右開区間
		 */
		@Override
		public void update(T data, int left, int right) {
			if (left >= right || right > size) throw new IllegalArgumentException("[" + left + ", " + right + ") is undefined.");
			int mid = left ^ right, m = 1, l, r, length = this.dat.length >> 1;
			while ((mid & length) == 0) { // 共通区間
				if ((left & length) != 0) {
					left &= ~length;
					right &= ~length;
					++ m;
				}
				lazy(m);
				m <<= 1;
				length >>= 1;
			}
			l = m;
			int lengthL = length;
			while(left != 0) { // 左側評価
				lazy(l);
				l <<= 1;
				lengthL >>= 1;
				if ((left & lengthL) == 0) {
					dat[l + 1] = operate(dat[l + 1], data);
				} else {
					left &= ~lengthL;
					++ l;
				}
			}
			dat[l] = operate(dat[l], data);
			r = m + 1;
			int lengthR = length;
			right &= ~lengthR;
			while(right != 0) { // 右側評価開始
				lazy(r);
				r <<= 1;
				lengthR >>= 1;
				if ((right & lengthR) != 0) {
					right &= ~lengthR;
					dat[r] = operate(dat[r], data);
					++ r;
				}
			}
		}

		/**
		 * 全ての値を取得します。
		 * @return 現在の値
		 */
		@Override
		@SuppressWarnings("unchecked")
		public T[] get() {
			for (int i = 1, l = dat.length >> 1;i < l;++ i) {
				dat[i << 1] = operate(dat[i << 1], dat[i]);
				dat[i << 1 | 1] = operate(dat[i << 1 | 1], dat[i]);
				dat[i] = null;
			}
			T[] ret = (T[]) Array.newInstance(dat[dat.length >> 1].getClass(), size);
			System.arraycopy(dat, dat.length >> 1, ret, 0, size);
			return  ret;
		}

		/**
		 * 指定した場所の値を取得します。
		 * @param index 取得したい場所
		 * @return その場所の値
		 */
		@Override
		public T get(int index) {
			T ret = null;
			for (int i = dat.length >> 1 | index; i > 0; i >>= 1) ret = operate(ret, dat[i]);
			return ret;
		}

		/**
		 * 要素数を返します。
		 * @return 要素数
		 */
		@Override
		public int size() {
			return size;
		}

		@Override
		public void update(T dat, int index) {
			update(dat, index, index + 1);
		}

		@Override
		public T get(int left, int right) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int lowerBound(T compare, Comparator<T> comparator) {
			return Algorithm.binarySearch(size, -1, i -> comparator.compare(compare, get(i)) >= 0);
		}

		@Override
		public int upperBound(T compare, Comparator<T> comparator) {
			return Algorithm.binarySearch(-1, size, i -> comparator.compare(compare, get(i)) <= 0);
		}
	}

	public static class Algorithm {
		/**
		 * 累積和を計算します。
		 * @param dat 元となる値
		 * @param associative 演算式
		 * @param unit 単位元
		 * @return 累積和
		 */
		public static <T> T[] cumsum(T[] dat, Associative<T> associative, T unit) {
			@SuppressWarnings("unchecked")
			T[] ret = (T[]) new Object[dat.length + 1];
			ret[0] = unit;
			for (int i = 0;i < dat.length;++ i) ret[i + 1] = associative.operate(ret[i], dat[i]);
			return ret;
		}
		/**
		 * 二分探索を計算します。
		 * @param ok 演算範囲のtrue側の端(開区間)
		 * @param ng 演算範囲のfalse側の端(開区間)
		 * @param f 評価関数、単調性を満たす必要がある
		 * @return 境界に接し、評価関数がtrueを返す値
		 */
		public static int binarySearch(int ok, int ng, Predicate<Integer> f) {
			int halfDiff, mid;
			while((halfDiff = (ok - ng) / 2) != 0) if (f.test(mid = ng + halfDiff)) ok = mid; else ng = mid;
			return ok;
		}

		/**
		 * 尺取り法を計算します。
		 * @param l 区間の左端(これを含む)
		 * @param r 区間の右端(これを含まない)
		 * @param empty 空集合に対する値
		 * @param f 区間[l, r)が尺取り法で数え上げる条件を満たすならtrue
		 * @param addRight 区間に当該の値を追加する処理
		 * @param removeLeft 区間から当該の値を取り除く処理
		 * @param def 答えが存在しなかったときの答え
		 * @param ans 今までの答えと条件を満たす区間幅r-lが与えられた時の次の答え
		 * @return 尺取り法の答え
		 */
		public static <T, E> E syakutori(int l, int r, T empty, Predicate<T> f, BiFunction<T, Integer, T> addRight, BiFunction<T, Integer, T> removeLeft, E def, BiFunction<E, Integer, E> ans) {
			for (int i = l, j = l;j < r;def = ans.apply(def, j - i)) {
				empty = addRight.apply(empty, j++);
				while (!f.test(empty) && i < j) empty = removeLeft.apply(empty, i++);
			}
			return def;
		}
	}

	public class FastIO {
		private final InputStream in = System.in;
		private final byte[] buffer = new byte[1024];
		private int read = 0;
		private int length = 0;
		public final PrintWriter out = new PrintWriter(System.out, false);
		public final PrintWriter err = new PrintWriter(System.err, false);

		private boolean hasNextByte() {
			if (read < length) return true;
			read = 0;
			try {
				length = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return length > 0;
		}

		private int readByte() {
			return hasNextByte() ? buffer[read++] : -1;
		}

		private boolean isPrintableChar(int c) {
			return 33 <= c && c <= 126;
		}

		private boolean isNumber(int c) {
			return '0' <= c && c <= '9';
		}

		public boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[read])) read++;
			return hasNextByte();
		}

		public char nextChar() {
			if (!hasNextByte())  throw new NoSuchElementException();
			return (char)readByte();
		}

		public char[][] nextChar(int height) {
			char[][] ret = new char[height][];
			for (int i = 0;i < ret.length;++ i) ret[i] = next().toCharArray();
			return ret;
		}

		public String next() {
			if (!hasNext()) throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b;
			while (isPrintableChar(b = readByte())) sb.appendCodePoint(b);
			return sb.toString();
		}

		public long nextLong() {
			if (!hasNext()) throw new NoSuchElementException();
			long n = 0;
			boolean minus = false;
			int b = readByte();
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			if (!isNumber(b)) throw new NumberFormatException();
			while (true) {
				if (isNumber(b)) {
					n *= 10;
					n += b - '0';
				} else if (b == -1 || !isPrintableChar(b)) return minus ? -n : n;
				else throw new NumberFormatException();
				b = readByte();
			}
		}

		public int nextInt() {
			long nl = nextLong();
			if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
			return (int) nl;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextInt(int width) {
			int[] ret = new int[width];
			for (int i = 0;i < width;++ i) ret[i] = nextInt();
			return ret;
		}

		public long[] nextLong(int width) {
			long[] ret = new long[width];
			for (int i = 0;i < width;++ i) ret[i] = nextLong();
			return ret;
		}

		public int[][] nextInt(int width, int height) {
			int[][] ret = new int[height][width];
			for (int i = 0, j;i < height;++ i) for (j = 0;j < width;++ j) ret[i][j] = nextInt();
			return ret;
		}

		public long[][] nextLong(int width, int height) {
			long[][] ret = new long[height][width];
			for (int i = 0, j;i < height;++ i) for (j = 0;j < width;++ j) ret[j][i] = nextLong();
			return ret;
		}

		public boolean[] nextBoolean(char T) {
			char[] s = next().toCharArray();
			boolean[] ret = new boolean[s.length];
			for (int i = 0;i < ret.length;++ i) ret[i] = s[i] == T;
			return ret;
		}

		public boolean[][] nextBoolean(char T, int height) {
			boolean[][] ret = new boolean[height][];
			for (int i = 0;i < ret.length;++ i) {
				char[] s = next().toCharArray();
				ret[i] = new boolean[s.length];
				for (int j = 0;j < ret[i].length;++ j) ret[i][j] = s[j] == T;
			}
			return ret;
		}

		@Override
		protected void finalize() throws Throwable {
			try {
				super.finalize();
			} finally {
				in.close();
				out.close();
				err.close();
			}
		}

		public void print(boolean b) {
			out.print(b);
		}

		public void print(char c) {
			out.print(c);
		}

		public void print(char[] s) {
			out.print(s);
		}

		public void print(double d) {
			out.print(d);
		}

		public void print(float f) {
			out.print(f);
		}

		public void print(int i) {
			out.print(i);
		}

		public void print(long l) {
			out.print(l);
		}

		public void print(Object obj) {
			out.print(obj);
		}

		public void print(String s) {
			out.print(s);
		}

		public void printf(String format, Object... args) {
			out.printf(format, args);
		}

		public void printf(Locale l, String format, Object... args) {
			out.printf(l, format, args);
		}

		public void println() {
			out.println();
		}

		public void println(boolean b) {
			out.println(b);
		}

		public void println(char c) {
			out.println(c);
		}

		public void println(char[] s) {
			out.println(s);
		}

		public void println(double d) {
			out.println(d);
		}

		public void println(float f) {
			out.println(f);
		}

		public void println(int i) {
			out.println(i);
		}

		public void println(long l) {
			out.println(l);
		}

		public void println(Object obj) {
			out.println(obj);
		}

		public void println(String s) {
			out.println(s);
		}

		public void flush() {
			out.flush();
			err.flush();
		}
	}

	public enum BoundType {
		CLOSED, OPEN;
	}

	public static class Range<C> implements Serializable{

		private static final long serialVersionUID = 6582232757238309626L;
		protected C lower;
		protected C upper;
		protected BoundType lowerType;
		protected BoundType upperType;
		private Comparator<? super C> comparator;

		protected Range(C lower, BoundType lowerType, C upper, BoundType upperType) {
			this(lower, lowerType, upper, upperType, null);
		}

		protected Range(C lower, BoundType lowerType, C upper, BoundType upperType, Comparator<? super C> comparator) {
			this.lower = lower;
			this.upper = upper;
			this.lowerType = lowerType;
			this.upperType = upperType;
			this.comparator = comparator;
		}

		public static <C extends Comparable<? super C>> Range<C> range(C lower, BoundType lowerType, C upper, BoundType upperType) {
			if (lower != null && upper != null) {
				int comp = lower.compareTo(upper);
				if (comp > 0) throw new IllegalArgumentException();
				else if (comp == 0) {
					if (lowerType == BoundType.OPEN && upperType == BoundType.OPEN) throw new IllegalArgumentException();
					else if (lowerType == BoundType.OPEN || upperType == BoundType.OPEN)return new Range<C>(null, BoundType.CLOSED, null, BoundType.CLOSED);
				}
			}
			return new Range<C>(lower, lowerType, upper, upperType);
		}

		public static <C> Range<C> range(C lower, BoundType lowerType, C upper, BoundType upperType, Comparator<? super C> comparator) {
			if (lower != null && upper != null) {
				int comp = comparator.compare(lower, upper);
				if (comp > 0) throw new IllegalArgumentException();
				else if (comp == 0) {
					if (lowerType == BoundType.OPEN && upperType == BoundType.OPEN) throw new IllegalArgumentException();
					else if (lowerType == BoundType.OPEN || upperType == BoundType.OPEN)return new Range<C>(null, BoundType.CLOSED, null, BoundType.CLOSED, comparator);
				}
			}
			return new Range<C>(lower, lowerType, upper, upperType, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> all() {
			return range(null, BoundType.OPEN, null, BoundType.OPEN);
		}

		public static <C> Range<C> all(Comparator<? super C> comparator) {
			return range(null, BoundType.OPEN, null, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> atMost(C upper) {
			return range(null, BoundType.OPEN, upper, BoundType.CLOSED);
		}

		public static <C> Range<C> atMost(C upper, Comparator<? super C> comparator) {
			return range(null, BoundType.OPEN, upper, BoundType.CLOSED, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> lessThan(C upper) {
			return range(null, BoundType.OPEN, upper, BoundType.OPEN);
		}

		public static <C> Range<C> lessThan(C upper, Comparator<? super C> comparator) {
			return range(null, BoundType.OPEN, upper, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> downTo(C upper, BoundType boundType) {
			return range(null, BoundType.OPEN, upper, boundType);
		}

		public static <C> Range<C> downTo(C upper, BoundType boundType, Comparator<? super C> comparator) {
			return range(null, BoundType.OPEN, upper, boundType, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> atLeast(C lower) {
			return range(lower, BoundType.CLOSED, null, BoundType.OPEN);
		}

		public static <C> Range<C> atLeast(C lower, Comparator<? super C> comparator) {
			return range(lower, BoundType.CLOSED, null, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> greaterThan(C lower) {
			return range(lower, BoundType.OPEN, null, BoundType.OPEN);
		}

		public static <C> Range<C> greaterThan(C lower, Comparator<? super C> comparator) {
			return range(lower, BoundType.OPEN, null, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> upTo(C lower, BoundType boundType) {
			return range(lower, boundType, null, BoundType.OPEN);
		}

		public static <C> Range<C> upTo(C lower, BoundType boundType, Comparator<? super C> comparator) {
			return range(lower, boundType, null, BoundType.OPEN, comparator  );
		}

		public static <C extends Comparable<? super C>> Range<C> open(C lower, C upper) {
			return range(lower, BoundType.OPEN, upper, BoundType.OPEN);
		}

		public static <C> Range<C> open(C lower, C upper, Comparator<? super C> comparator) {
			return range(lower, BoundType.OPEN, upper, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> openClosed(C lower, C upper) {
			return range(lower, BoundType.OPEN, upper, BoundType.CLOSED);
		}

		public static <C> Range<C> openClosed(C lower, C upper, Comparator<? super C> comparator) {
			return range(lower, BoundType.OPEN, upper, BoundType.CLOSED, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> closedOpen(C lower, C upper) {
			return range(lower, BoundType.CLOSED, upper, BoundType.OPEN);
		}

		public static <C> Range<C> closedOpen(C lower, C upper, Comparator<? super C> comparator) {
			return range(lower, BoundType.CLOSED, upper, BoundType.OPEN, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> closed(C lower, C upper) {
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED);
		}

		public static <C> Range<C> closed(C lower, C upper, Comparator<? super C> comparator) {
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> singleton(C value) {
			return range(value, BoundType.CLOSED, value, BoundType.CLOSED);
		}

		public static <C> Range<C> singleton(C value, Comparator<? super C> comparator) {
			return range(value, BoundType.CLOSED, value, BoundType.CLOSED, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> empty() {
			return range(null, BoundType.CLOSED, null, BoundType.CLOSED);
		}

		public static <C> Range<C> empty(Comparator<? super C> comparator) {
			return range(null, BoundType.CLOSED, null, BoundType.CLOSED, comparator);
		}

		public static <C extends Comparable<? super C>> Range<C> encloseAll(Iterable<C> values) {
			C lower = values.iterator().next();
			C upper = lower;
			for (C i : values) {
				if (lower.compareTo(i) > 0) lower = i;
				if (upper.compareTo(i) < 0) upper = i;
			}
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED);
		}

		public static <C> Range<C> encloseAll(Iterable<C> values, Comparator<? super C> comparator) {
			C lower = values.iterator().next();
			C upper = lower;
			for (C i : values) {
				if (comparator.compare(lower, i) > 0) lower = i;
				if (comparator.compare(upper, i) < 0) upper = i;
			}
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED, comparator);
		}

		protected int compareLower(C value) {
			return compareLower(value, BoundType.CLOSED);
		}

		protected int compareLower(C value, BoundType boundType) {
			return compareLower(lower, lowerType, value, boundType);
		}

		protected int compareLower(C lower, BoundType lowerType, C value) {
			return compareLower(lower, lowerType, value, BoundType.CLOSED);
		}

		protected int compareLower(C lower, BoundType lowerType, C value, BoundType boundType) {
			if (lower == null) return value == null ? 0 : -1;
			else if (value == null) return 1;
			int compare;
			if (comparator == null) {
				@SuppressWarnings("unchecked")
				Comparable<C> comp = (Comparable<C>)lower;
				compare = comp.compareTo(value);
			} else compare = comparator.compare(lower, value);
			if (compare == 0) {
				if (lowerType == BoundType.CLOSED) -- compare;
				if (boundType == BoundType.CLOSED) ++ compare;
			}
			return compare;
		}

		protected int compareUpper(C value) {
			return compareUpper(value, BoundType.CLOSED);
		}

		protected int compareUpper(C value, BoundType boundType) {
			return compareUpper(upper, upperType, value, boundType);
		}

		protected int compareUpper(C upper, BoundType upperType, C value) {
			return compareUpper(upper, upperType, value, BoundType.CLOSED);
		}

		protected int compareUpper(C upper, BoundType upperType, C value, BoundType boundType) {
			if (upper == null) return value == null ? 0 : 1;
			if (value == null) return -1;
			int compare;
			if (comparator == null) {
				@SuppressWarnings("unchecked")
				Comparable<C> comp = (Comparable<C>)upper;
				compare = comp.compareTo(value);
			} else compare = comparator.compare(upper, value);
			if (compare == 0) {
				if (upperType == BoundType.CLOSED) ++ compare;
				if (boundType == BoundType.CLOSED) -- compare;
			}
			return compare;
		}

		public boolean hasLowerBound() {
			return lower != null;
		}

		public C lowerEndpoint() {
			if (hasLowerBound()) return lower;
			throw new IllegalStateException();
		}

		public BoundType lowerBoundType() {
			if (hasLowerBound()) return lowerType;
			throw new IllegalStateException();
		}

		public boolean hasUpperBound() {
			return upper != null;
		}

		public C upperEndpoint() {
			if (hasUpperBound()) return upper;
			throw new IllegalStateException();
		}

		public BoundType upperBoundType() {
			if (hasUpperBound()) return upperType;
			throw new IllegalStateException();
		}

		/**
		 * この区間が空集合か判定します。
		 * @return 空集合ならばtrue
		 */
		public boolean isEmpty() {
			return lower == null && upper == null && lowerType == BoundType.CLOSED;
		}

		/**
		 * 与えられた引数が区間の左側に位置するか判定します。<br>
		 * 接する場合は区間の左側ではないと判定します。
		 * @param value 調べる引数
		 * @return 区間の左側に位置するならtrue
		 */
		public boolean isLess(C value) {
			return isLess(value, BoundType.CLOSED);
		}

		protected boolean isLess(C value, BoundType boundType) {
			return compareLower(value, boundType) > 0;
		}

		/**
		 * 与えられた引数が区間の右側に位置するか判定します。<br>
		 * 接する場合は区間の右側ではないと判定します。
		 * @param value 調べる引数
		 * @return 区間の右側に位置するならtrue
		 */
		public boolean isGreater(C value) {
			return isGreater(value, BoundType.CLOSED);
		}

		private boolean isGreater(C value, BoundType boundType) {
			return compareUpper(value, boundType) < 0;
		}

		/**
		 * 与えられた引数が区間内に位置するか判定します。<br>
		 * 接する場合も区間内に位置すると判定します。
		 * @param value 調べる引数
		 * @return 区間内に位置するならtrue
		 */
		public boolean contains(C value) {
			return !isLess(value) && !isGreater(value) && !isEmpty();
		}

		/**
		 * 与えられた引数すべてが区間内に位置するか判定します。<br>
		 * 接する場合も区間内に位置すると判定します。
		 * @param value 調べる要素
		 * @return 全ての要素が区間内に位置するならtrue
		 */
		public boolean containsAll(Iterable<? extends C> values) {
			for (C i : values) if (!contains(i)) return false;
			return true;
		}

		/**
		 * 与えられた区間がこの区間に内包されるか判定します。<br>
		 *
		 * @param other
		 * @return 与えられた区間がこの区間に内包されるならtrue
		 */
		public boolean encloses(Range<C> other) {
			return !isLess(other.lower, other.lowerType) && !isGreater(other.upper, other.upperType);
		}

		/**
		 * 与えられた区間がこの区間と公差するか判定します。<br>
		 * 接する場合は公差するものとします。
		 * @param value 調べる引数
		 * @return 区間が交差するならtrue
		 */
		public boolean isConnected(Range<C> other) {
			C lower, upper;
			BoundType lowerType, upperType;
			if (isLess(other.lower, other.lowerType)) {
				lower = other.lower;
				lowerType = other.lowerType;
			} else {
				lower = this.lower;
				lowerType = this.lowerType;
			}
			if (isGreater(other.upper, other.upperType)) {
				upper = other.upper;
				upperType = other.upperType;
			} else {
				upper = this.upper;
				upperType = this.upperType;
			}
			if (lower == null || upper == null) return true;
			int comp = compareLower(lower, lowerType, upper, upperType);
			return comp <= 0;
		}
		/**
		 * この区間との積集合を返します。
		 * @param connectedRange 積集合を求める区間
		 * @return 積集合
		 */
		public Range<C> intersection(Range<C> connectedRange) {
			if (!isConnected(connectedRange)) throw new IllegalArgumentException();
			C lower, upper;
			BoundType lowerType, upperType;
			if (isLess(connectedRange.lower, connectedRange.lowerType)) {
				lower = connectedRange.lower;
				lowerType = connectedRange.lowerType;
			} else {
				lower = this.lower;
				lowerType = this.lowerType;
			}
			if (isGreater(connectedRange.upper, connectedRange.upperType)) {
				upper = connectedRange.upper;
				upperType = connectedRange.upperType;
			} else {
				upper = this.upper;
				upperType = this.upperType;
			}
			if (comparator == null) {
				return new Range<C>(lower, lowerType, upper, upperType);
			}
			return range(lower, lowerType, upper, upperType, comparator);
		}

		/**
		 * この区間との和集合を返します。
		 * @param other 和集合を求める区間
		 * @return 和集合
		 */
		public Range<C> span(Range<C> other) {
			if (other.isEmpty()) return new Range<C>(lower, lowerType, upper, upperType);
			C lower, upper;
			BoundType lowerType, upperType;
			if (isLess(other.lower, other.lowerType)) {
				lower = this.lower;
				lowerType = this.lowerType;
			} else {
				lower = other.lower;
				lowerType = other.lowerType;
			}
			if (isGreater(other.upper, other.upperType)) {
				upper = this.upper;
				upperType = this.upperType;
			} else {
				upper = other.upper;
				upperType = other.upperType;
			}
			return new Range<C>(lower, lowerType, upper, upperType, comparator);
		}

		@Override
		public boolean equals(Object object) {
			if (this == object) return true;
			if (object instanceof Range) {
				@SuppressWarnings("unchecked")
				Range<C> comp = (Range<C>) object;
				return compareLower(comp.lower, comp.lowerType) == 0 && compareUpper(comp.upper, comp.upperType) == 0 && lowerType == comp.lowerType && upperType == comp.upperType;
			}
			return false;
		}

		@Override
		public int hashCode() {
			if (lower == null && upper == null) return 0;
			else if (lower == null) return upper.hashCode();
			else if (upper == null) return lower.hashCode();
			return lower.hashCode() ^ upper.hashCode();
		}

		@Override
		public String toString() {
			if (isEmpty()) return "()";
			return (lowerType == BoundType.OPEN ? "(" : "[") + (lower == null ? "" : lower.toString()) + ".." + (upper == null ? "" : upper.toString()) + (upperType == BoundType.OPEN ? ")" : "]");
		}
	}

	public interface IterableFunction<T> {
		public T next(T value);
	}

	public static class IterableRange<C> extends Range<C> implements Iterable<C>{

	private static final long serialVersionUID = -8258795284144976352L;
	protected IterableFunction<C> func;

	protected IterableRange(C lower, BoundType lowerType, C upper, BoundType upperType, IterableFunction<C> func) {
		super(lower, lowerType, upper, upperType);
		this.func = func;
	}

	public static <C extends Comparable<? super C>> IterableRange<C> range(C lower, BoundType lowerType, C upper, BoundType upperType, IterableFunction<C> func) {
		if (lower == null || upper == null) throw new IllegalArgumentException();
		int comp = lower.compareTo(upper);
		if (comp > 0) throw new IllegalArgumentException();
		else if (comp == 0 && (lowerType == BoundType.OPEN || upperType == BoundType.OPEN)) throw new IllegalArgumentException();
		return new IterableRange<C>(lower, lowerType, upper, upperType, func);
	}

	public static <C extends Comparable<? super C>> IterableRange<C> open(C lower, C upper, IterableFunction<C> func) {
		if (lower == null) throw new IllegalArgumentException();
		return range(func.next(lower), BoundType.CLOSED, upper, BoundType.OPEN, func);
	}

	public static <C extends Comparable<? super C>> IterableRange<C> openClosed(C lower, C upper, IterableFunction<C> func) {
		if (lower == null) throw new IllegalArgumentException();
		return range(func.next(lower), BoundType.CLOSED, upper, BoundType.CLOSED, func);
	}

	public static <C extends Comparable<? super C>> IterableRange<C> closedOpen(C lower, C upper, IterableFunction<C> func) {
		return range(lower, BoundType.CLOSED, upper, BoundType.OPEN, func);
	}

	public static <C extends Comparable<? super C>> IterableRange<C> closed(C lower, C upper, IterableFunction<C> func) {
		return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED, func);
	}

	public static <C extends Comparable<? super C>> IterableRange<C> singleton(C value, IterableFunction<C> func) {
		return range(value, BoundType.CLOSED, value, BoundType.CLOSED, func);
	}
	private class Iter implements Iterator<C> {
		C now;
		Iter() {
			now = lower;
		}
		@Override
		public final boolean hasNext() {
			return !isGreater(now);
		}

		@Override
		public final C next() {
			C ret = now;
			now = func.next(now);
			return ret;
		}

		@Override
		public final void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<C> iterator() {
		return new Iter();
	}

	public int getDistance() {
		C check = upper;
		int ret = 0;
		while (lower != check) {
			check = func.next(check);
			++ ret;
		}
		return ret;
	}
}
	public static class IntRange extends IterableRange<Integer>{

		private static final long serialVersionUID = -2492737284164864881L;

		private final boolean useFastIter;

		private static class Next implements IterableFunction<Integer> {

			@Override
			public Integer next(Integer value) {
				return value + 1;
			}
		}

		protected IntRange(int lower, BoundType lowerType, int upper, BoundType upperType) {
			super(lower, lowerType, upper, upperType, new Next());
			useFastIter = true;
		}

		protected IntRange(int lower, BoundType lowerType, int upper, BoundType upperType, IterableFunction<Integer> func) {
			super(lower, lowerType, upper, upperType, func);
			useFastIter = false;
		}

		public static IntRange range(int lower, BoundType lowerType, int upper, BoundType upperType) {
			if (lower > upper) return new IntRange(0, BoundType.CLOSED, 0, BoundType.OPEN);
			if (lowerType == BoundType.OPEN) ++ lower;
			if (upperType == BoundType.OPEN) -- upper;
			return new IntRange(lower, BoundType.CLOSED, upper, BoundType.CLOSED);
		}

		public static IntRange range(int lower, BoundType lowerType, int upper, BoundType upperType, IterableFunction<Integer> func) {
			if (lower > upper) return new IntRange(0, BoundType.CLOSED, 0, BoundType.OPEN, func);
			if (lowerType == BoundType.OPEN) ++ lower;
			if (upperType == BoundType.OPEN) -- upper;
			return new IntRange(lower, BoundType.CLOSED, upper, BoundType.CLOSED, func);
		}

		public static IntRange open(int lower, int upper) {
			return range(lower, BoundType.OPEN, upper, BoundType.OPEN);
		}

		public static IntRange open(int lower, int upper, IterableFunction<Integer> func) {
			return range(lower, BoundType.OPEN, upper, BoundType.OPEN, func);
		}

		public static IntRange open(int upper) {
			return range(0, BoundType.CLOSED, upper, BoundType.OPEN);
		}

		public static IntRange open(int upper, IterableFunction<Integer> func) {
			return range(0, BoundType.CLOSED, upper, BoundType.OPEN, func);
		}

		public static IntRange openClosed(int lower, int upper) {
			return range(lower, BoundType.OPEN, upper, BoundType.CLOSED);
		}

		public static IntRange openClosed(int lower, int upper, IterableFunction<Integer> func) {
			return range(lower, BoundType.OPEN, upper, BoundType.CLOSED, func);
		}

		public static IntRange closedOpen(int lower, int upper) {
			return range(lower, BoundType.CLOSED, upper, BoundType.OPEN);
		}

		public static IntRange closedOpen(int lower, int upper, IterableFunction<Integer> func) {
			return range(lower, BoundType.CLOSED, upper, BoundType.OPEN, func);
		}

		public static IntRange closed(int lower, int upper) {
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED);
		}

		public static IntRange closed(int lower, int upper, IterableFunction<Integer> func) {
			return range(lower, BoundType.CLOSED, upper, BoundType.CLOSED, func);
		}

		public static IntRange closed(int upper) {
			return range(0, BoundType.CLOSED, upper, BoundType.CLOSED);
		}

		public static IntRange closed(int upper, IterableFunction<Integer> func) {
			return range(0, BoundType.CLOSED, upper, BoundType.CLOSED, func);
		}

		public static IntRange singleton(int value) {
			return range(value, BoundType.CLOSED, value, BoundType.CLOSED);
		}

		public static IntRange singleton(int value, IterableFunction<Integer> func) {
			return range(value, BoundType.CLOSED, value, BoundType.CLOSED, func);
		}

		private class FastIter implements Iterator<Integer> {
			int now;
			public FastIter() {
				now = lower;
			}
			@Override
			public final boolean hasNext() {
				return now <= upper;
			}

			@Override
			public final Integer next() {
				return now++;
			}

			@Override
			public final void remove() {
				throw new UnsupportedOperationException();
			}
		}

		private class Iter implements Iterator<Integer> {
			int now;
			public Iter() {
				now = lower;
			}
			@Override
			public final boolean hasNext() {
				return now <= upper;
			}

			@Override
			public final Integer next() {
				int ret = now;
				now = func.next(now);
				return ret;
			}

			@Override
			public final void remove() {
				throw new UnsupportedOperationException();
			}
		}

		@Override
		public Iterator<Integer> iterator() {
			return useFastIter ? new FastIter() : new Iter();
		}

		@Override
		public int getDistance() {
			int ret = upper - lower;
			if (upperType == BoundType.CLOSED) ++ ret;
			return ret;
		}

		public int getClosedLower() {
			return lower;
		}

		public int getOpenLower() {
			return lower - 1;
		}

		public int getClosedUpper() {
			return upperType == BoundType.CLOSED ? upper : upper - 1;
		}

		public int getOpenUpper() {
			return upperType == BoundType.CLOSED ? upper + 1 : upper;
		}
	}
}
