import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
	static PrintWriter out = new PrintWriter(System.out);

	static int N;
	static boolean b[][];
	
	static int sum[][];
	
	public static void main(String[] args) {
		FS in = new FS();
		N = in.nextInt();
		b = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			char c[] = in.next().toCharArray();
			int idd = 0;
			for(int j = 0; j < c.length; j++) {
				int v = get(c[j]);
				for(int k = 3; k >= 0; k--) {
					if((v & (1<<k)) > 0) b[i][idd++] = true;
					else b[i][idd++] = false;
				}
			}
		}
		
		sum = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(b[r][c]) sum[r][c]++;
				if(r > 0) sum[r][c] += sum[r-1][c];
				if(c > 0) sum[r][c] += sum[r][c-1];
				if(r > 0 && c > 0) sum[r][c] -= sum[r-1][c-1];
			}
		}
		
		boolean found = false;
		for(int x = N; x >= 2; x--) {
			if(N%x != 0) continue;
			if(works(x)) {
				found = true;
				out.println(x);
				break;
			}
		}
		if(!found) out.println(1);
		out.close();
	}
	
	static boolean works(int sz) {
		int goal = sz*sz;
		for(int r = 0; r < N; r += sz) {
			for(int c = 0; c < N; c += sz) {
				int s = sum(r,c,sz);
				if(s != 0 && s != goal) return false;
			}
		}
		return true;
	}
	
	static int sum(int r, int c, int d) {
		int r2 = r+d-1, c2 = c+d-1;
		int res = sum[r2][c2];
		if(r > 0) res -= sum[r-1][c2];
		if(c > 0) res -= sum[r2][c-1];
		if(r > 0 && c > 0) res += sum[r-1][c-1];
		return res;
	}
	
	static int get(char c) {
		if(c >= 'A' && c <= 'F') return 10 + (c-'A');
		return c-'0';
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
