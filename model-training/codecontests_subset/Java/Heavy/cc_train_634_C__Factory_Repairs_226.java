import java.io.IOException;
import java.util.InputMismatchException;

public class FactoryRepairs {
	public static void main(String[] args) {
		FasterScanner sc = new FasterScanner();

		int N = sc.nextInt();
		int K = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int Q = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		SegmentTree pre = new SegmentTree(N + 1);
		SegmentTree post = new SegmentTree(N + 1);
		for (int q = 0; q < Q; q++) {
			int T = sc.nextInt();
			if (T == 1) {
				int D = sc.nextInt();
				int V = sc.nextInt();
				long preAmt = Math.min(B, pre.get(D) + V);
				pre.insert(D, preAmt);
				long postAmt = Math.min(A, post.get(D) + V);
				post.insert(D, postAmt);
			} else {
				int P = sc.nextInt();
				long preSum = pre.get(1, P - 1);
				long postSum = post.get(P + K, N);
				long total = preSum + postSum;
				sb.append(total + "\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	/**
	 * Here is a Segment Tree implementation.  It currently does sums of longs.
	 * See the comments to find where to change the data-type and function of this Segment Tree.
	 */
	public static class SegmentTree {
		public SegmentTreeNode[] leaves;
		public SegmentTreeNode root;

		public SegmentTree(int n) {
			this.leaves = new SegmentTreeNode[n];
			this.root = new SegmentTreeNode(this, null, 0, n - 1);
		}

		// modify the data-type of this segment tree
		public SegmentTree(long[] vals) {
			this(vals.length);
			for (int i = 0; i < vals.length; i++) {
				this.insert(i, vals[i]);
			}
		}

		// modify the data-type of this segment tree
		public void insert(int idx, long v) {
			this.leaves[idx].setAndUpdate(v);
		}

		// modify the data-type of this segment tree
		public long get(int idx) {
			return this.leaves[idx].val;
		}

		// modify the data-type of this segment tree
		public long get(int lower, int upper) {
			return this.root.getRange(lower, upper);
		}

		private static class SegmentTreeNode {
			public int L;
			public int R;

			// modify the data-type of this segment tree
			public long val;

			public SegmentTree tree;
			public SegmentTreeNode parent;
			public SegmentTreeNode left;
			public SegmentTreeNode rite;

			public SegmentTreeNode(SegmentTree t, SegmentTreeNode p, int lower, int upper) {
				this.tree = t;
				this.parent = p;
				this.L = lower;
				this.R = upper;

				if (lower == upper) {
					this.tree.leaves[lower] = this;
				} else {
					int mid = (lower + upper) / 2;
					this.left = new SegmentTreeNode(tree, this, lower, mid);
					this.rite = new SegmentTreeNode(tree, this, mid + 1, upper);
				}
			}

			// modify the data-type of this segment tree
			public void setAndUpdate(long v) {
				this.val = v;
				this.update();
			}

			// modify the function (i.e. max, min, sum, etc.) in this method
			public void update() {
				if (this.left != null && this.rite != null) {
					this.val = this.left.val + this.rite.val;
				} else if (this.left != null) {
					this.val = this.left.val;
				} else if (this.rite != null) {
					this.val = this.rite.val;
				}

				if (this.parent != null) {
					this.parent.update();
				}
			}

			// modify the function & the default return value in this method
			public long getRange(int lower, int upper) {
				if (this.L >= lower && this.R <= upper) {
					return this.val;
				} else if (this.L > upper || this.R < lower) {
					// modify the default value here (if it's not found)
					return 0;
				} else {
					// modify the function that this Segment Tree uses
					return this.left.getRange(lower, upper) + this.rite.getRange(lower, upper);
				}
			}
		}
	}

	public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			return nextIntArray(n, 0);
		}

		public int[] nextIntArray(int n, int off) {
			int[] arr = new int[n + off];
			for (int i = 0; i < n; i++) {
				arr[i + off] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			return nextLongArray(n, 0);
		}

		public long[] nextLongArray(int n, int off) {
			long[] arr = new long[n + off];
			for (int i = 0; i < n; i++) {
				arr[i + off] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}