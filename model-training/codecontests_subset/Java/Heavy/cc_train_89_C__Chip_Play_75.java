import java.io.*;
import java.util.*;

public class Main
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
        Main inst = new Main();
        inst.execute();
        out.close();
    }
    
    private class Node {
    	public int y;
    	public int x;
    	public int dir;
    	public Node[] connected;
    	public Node[] newConnected;
    	
    	public Node(int y, int x) {
    		this.y = y;
    		this.x = x;
    		dir = -1;
    		connected = new Node[4];
    		newConnected = new Node[4];
    	}
    }
    
    private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Up right down left
    
    public int dfs(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	for (int i = 0; i < 4; i++) {
    		int op = (i+2)%4;
    		if (node.newConnected[i] != null) {
				node.newConnected[i].newConnected[op] = node.newConnected[op];
			}
    	}
    	return dfs(node.newConnected[node.dir])+1;
    }
    
    private void execute() throws IOException {
    	String[] line = scan.nextLine().split(" +");
    	int N = Integer.parseInt(line[0]);
    	int M = Integer.parseInt(line[1]);
    	LinkedList<Node> empty = new LinkedList<Node>();
    	Node[][] nodes = new Node[N][M];
    	for (int i = 0; i < N; i++) {
    		char[] chars = scan.nextLine().toCharArray();
    		for (int j = 0; j < M; j++) { // "L", "R", "U", "D"
    			nodes[i][j] = new Node(i, j);
    			if (chars[j] == 'U') {
    				nodes[i][j].dir = 0;
    			} else if (chars[j] == 'R') {
    				nodes[i][j].dir = 1;
    			} else if (chars[j] == 'D') {
    				nodes[i][j].dir = 2;
    			} else if (chars[j] == 'L') {
    				nodes[i][j].dir = 3;
    			} else {
    				empty.add(nodes[i][j]);
    			}
    			if (i > 0) {
    				nodes[i][j].connected[0] = nodes[i-1][j];
    				nodes[i-1][j].connected[2] = nodes[i][j];
    			}
    			if (j > 0) {
    				nodes[i][j].connected[3] = nodes[i][j-1];
    				nodes[i][j-1].connected[1] = nodes[i][j];
    			}
    		}
    	}
    	for (Node node : empty) {
    		for (int dir = 0; dir < 4; dir++) {
    			int op = (dir+2)%4;
    			if (node.connected[dir] != null) {
    				node.connected[dir].connected[op] = node.connected[op];
    			}
    		}
    	}
    	int max = 0;
    	int maxAmounts = 0;
    	for (int y = 0; y < N; y++) {
    		for (int x = 0; x < M; x++) {
    			if (nodes[y][x].dir >= 0) {
    				for (int i = 0; i < N; i++) {
    		    		for (int j = 0; j < M; j++) {
    		    			if (nodes[i][j].dir >= 0) {
        		    			for (int k = 0; k < 4; k++) {
        		    				nodes[i][j].newConnected[k] = nodes[i][j].connected[k];
        		    			}
    		    			}
    		    		}
    		    	}
    				int result = dfs(nodes[y][x]);
    				if (result > max) {
    					max = result;
    					maxAmounts = 1;
    				} else if (result == max) {
    					maxAmounts++;
    				}
    			}
    		}
    	}
    	out.println(max+" "+maxAmounts);
    }
}
