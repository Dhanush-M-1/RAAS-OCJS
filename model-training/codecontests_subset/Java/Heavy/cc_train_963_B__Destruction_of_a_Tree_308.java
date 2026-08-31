import java.util.*;
import java.math.*;
import java.io.*;

public class CF964D implements Runnable {

	class Node {

		Node parent;
		int id, degree, depth;
		boolean dead;
		List<Node> children;

		public Node(int ii) { children = new ArrayList<>();  degree = 0;  dead = false;  id = ii; }
		void add(Node child) { children.add(child); }
		public String toString() { return String.format("%d %d %b", id + 1, degree, dead); }
		void setDegree() { degree = (parent == null ? 0 : 1) + children.size(); }

		boolean destroy() {
			if((degree & 1) == 1)
				return false;
			destroyed.add(this);
			dead = true;
			boolean possible = true;
			if(parent != null)
				parent.degree--;
			for(Node child : children)
				if(!child.dead) {
					child.degree--;
					possible &= child.destroy();
				}
			return possible;
		}

		void dfs(int d) {
			depth = d;
			for(Node child : children)
				child.dfs(d + 1);
			post.add(this);
		}

	}

	final int MOD = (int) 1e9 + 7;
	final double ERROR = 1e-9;
	final double oo = 1e50;
	List<Node> post;
	List<Node> destroyed;

	public void run() {
		SuperScanner scan = new SuperScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt();
		Node[] nodes = new Node[n];
		for(int i = 0 ; i < n ; i++)
			nodes[i] = new Node(i);
		Node root = null;
		for(int i = 0 ; i < n ; i++) {
			int p = scan.nextInt() - 1;
			if(p == -1) {
				root = nodes[i];
				continue;
			}
			nodes[i].parent = nodes[p];
			nodes[p].add(nodes[i]);
		}
		post = new ArrayList<>();
		destroyed = new ArrayList<>();
		// get a list of the nodes in post order, so that we can loop from 1 to n and check
		// them from bottom to top
		root.dfs(0);
		for(int i = 0 ; i < n ; i++)
			nodes[i].setDegree();
		boolean passed = true;
		for(int i = 0 ; i < n ; i++) {
			// if we can destroy the node, destroy it
			// every single node in the subtree of what was just destroyed must be destroyed
			// if a node can't be destroyed in the subtree, then it is impossible
			if((post.get(i).degree & 1) == 0) {
				passed &= post.get(i).destroy();
			}
		}
		for(int i = 0 ; i < n ; i++)
			if(!nodes[i].dead)
				passed = false;
		if(passed) {
			out.println("YES");
			for(Node destroyedNode : destroyed)
				out.println(destroyedNode.id + 1);
		} else {
			out.println("NO");
		}
		out.close();
	}

	class SuperScanner {
		public int BS = 1 << 16;
		public char NC = (char) 0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public SuperScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public SuperScanner(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}

		public char nextChar() {
			while (bId == size) {
				try {
					size = in.read(buf);
				} catch (Exception e) {
					return NC;
				}
				if (size == -1)
					return NC;
				bId = 0;
			}
			return (char) buf[bId++];
		}

		public int nextInt() {
			return (int) nextLong();
		}

		public long nextLong() {
			num = 1;
			boolean neg = false;
			if (c == NC)
				c = nextChar();
			for (; (c < '0' || c > '9'); c = nextChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = nextChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				num *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = nextChar();
			while (c > 32) {
				res.append(c);
				c = nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = nextChar();
			while (c != '\n') {
				res.append(c);
				c = nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if (c > 32)
				return true;
			while (true) {
				c = nextChar();
				if (c == NC)
					return false;
				else if (c > 32)
					return true;
			}
		}
	}

	public static void main(String[] args) {
		new Thread(null, new CF964D(), "_cf", 1 << 28).start();
	}
}
