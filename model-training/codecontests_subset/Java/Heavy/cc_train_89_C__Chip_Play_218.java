import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	int FREE  = -1;
	int UP    =  0;
	int RIGHT =  1;
	int DOWN  =  2;
	int LEFT  =  3;
	
	int[] dr = { -1,  0,  1,  0 };
	int[] dc = {  0,  1,  0, -1 };

	int rNum;
	int cNum;
	int size;
	int[] dir;
	int[][] origLink;
	int[][] link;
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		/* Input */
		rNum = nextInt();
		cNum = nextInt();
		size = rNum * cNum;
		
		dir = new int [rNum * cNum];
		for (int r = 0; r < rNum; r++) {
			char[] row = nextToken().toCharArray();
			for (int c = 0; c < cNum; c++)
				dir[code(r, c)] = getDir(row[c]);
		}
		
		/* Solution */
		origLink = new int [4][rNum * cNum];
		for (int[] a : origLink)
			fill(a, -1);
		for (int r = 0; r < rNum; r++) {
			for (int c = 0; c < cNum; c++) {
				if (dir[code(r, c)] != FREE) {
					for (int d = 0; d < 4; d++) {
						for (int step = 1;; step++) {
							int nr = r + step * dr[d];
							int nc = c + step * dc[d];
							if (nr < 0 || nr >= rNum || nc < 0 || nc >= cNum) break;
							if (dir[code(nr, nc)] != FREE) {
								origLink[d][code(r, c)] = code(nr, nc);
								break;
							}
						}
					}
				}
			}
		}
		
		int best = 0;
		int count = 0;
		
		link = new int [4][rNum * cNum];
		for (int r = 0; r < rNum; r++) {
			for (int c = 0; c < cNum; c++) {
				if (dir[code(r, c)] == FREE) continue;
//				mov(link, origLink);
				for (int d = 0; d < 4; d++)
					System.arraycopy(origLink[d], 0, link[d], 0, size);
				int cur = proc(r, c);
				if (best < cur) {
					best = cur;
					count = 1;
				} else if (best == cur) {
					count++;
				}
			}
		}
		
		/* Output */
		out.println(best + " " + count);
		
		out.close();
	}
	
	int proc(int sr, int sc) {
		int ret = 0;
		for (int cur = code(sr, sc);;) {
			ret++;
			int nxt = link[dir[cur]][cur];
			if (nxt != -1) {
				remove(cur);
				cur = nxt;
			} else {
				break;
			}
		}
		return ret;
	}

	void remove(int node) {
		for (int pd = 0; pd < 2; pd++) {
			int nd = pd + 2;
			int prev = link[pd][node];
			int next = link[nd][node];
			if (prev != -1) link[nd][prev] = next;
			if (next != -1) link[pd][next] = prev;
		}
	}

	void mov(int[][] dst, int[][] src) {
		for (int i = 0; i < dst.length; i++)
			for (int j = 0; j < dst[i].length; j++)
				dst[i][j] = src[i][j];
	}

	int code(int r, int c) {
		return cNum * r + c;
	}

	boolean good(int r, int c) {
		return 0 <= r && r < rNum && 0 <= c && c < cNum;
	}

	int getDir(char c) {
		if (c == 'U') return UP;
		if (c == 'R') return RIGHT;
		if (c == 'D') return DOWN;
		if (c == 'L') return LEFT;
		return FREE;
	}

	/*************************************************************** 
	 * Input 
	 **************************************************************/
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
