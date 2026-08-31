import java.io.*;
import java.util.*;

public class CF90E
{
	static final boolean _DEBUG = true;

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner(BufferedReader _br) {
			br = _br;
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
					return "";
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	static MyScanner   scan;
	static PrintWriter out;

	static int debugCount = 0;
	static void debug(String msg) {
		if (_DEBUG && debugCount < 200) {
			out.println(msg);
			out.flush();
			debugCount++;
		}
	}
	
    public static void main (String args[]) throws IOException {
//    	scan = new MyScanner(new BufferedReader(new FileReader("test.in")));
    	scan = new MyScanner(new BufferedReader(new InputStreamReader(System.in)));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        CF90E inst = new CF90E();
        inst.execute();
        out.close();
    }
    
    class Node {
    	Node left, right, up, down;
    	char c;
    	Node l, r, u, d;
    	
    	void init() {
    		c = '0';
    		l = r = u = d = this;
    		left = right = up = down = this;
    	}
    	void insertLast(Node head) {
    		r = head;
    		l = head.l;
    		head.l.r = this;
    		head.l = this;
    	}
    	
    	void insertBottom(Node top) {
    		d = top;
    		u = top.u;
    		top.u.d = this;
    		top.u = this;
    	}
    	
    	boolean valid;
    	
    	void reset() {
    		left = l;
    		right = r;
    		up = u;
    		down = d;
    		valid = true;
    	}
    	
    	void remove() {
    		left.right = right;
    		right.left = left;
    		up.down = down;
    		down.up = up;
    		valid = false;
    	}
    	
    	Node getNext() {
    		if (c == 'U') return up;
    		else if (c == 'D') return down;
    		else if (c == 'L') return left;
    		else return right;
    	}
    	
    }
    
    void execute() throws IOException {
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	
    	Node[] heads = new Node[n];
    	for (int r = 0; r < n; r++) {
			heads[r] = new Node();
			heads[r].init();
		}
    	Node[] tops = new Node[m];
    	for (int c = 0; c < m; c++) {
			tops[c] = new Node();
			tops[c].init();
		}
    	ArrayList<Node> active = new ArrayList<Node>();
    	
   	
    	for (int i = 0; i < n; i++) {
    		char[] line = scan.next().toCharArray();
    		for (int c = 0; c < m; c++) {
    			char f = line[c];
    			if (f != '.') {
    				
    				Node node = new Node();
    				node.c = f;
    				node.insertLast(heads[i]);
    				node.insertBottom(tops[c]);
    				active.add(node);
    			}
    			
    		}
    	}
    	
//    	debug("here");
    	
    	int max = 0;
    	int count = 0;
    	for (Node cur : active) {
    		int len = 0;
    		for (Node node : active) {
    			node.reset();
    		}
    		for (Node node : heads) {
    			node.reset();
    		}
    		for (Node node : tops) {
    			node.reset();
    		}
    		while(true) {
    			Node next = cur.getNext();
    			len++;
    			cur.remove();
    			if (next.c == '0') {
    				break;
    			}
    			cur = next;
    		}
    		if (len > max) {
    			max = len;
    			count = 1;
    		} else if (len == max) {
    			count++;
    		}
    	}
    	out.println(max + " " + count);
    }
}