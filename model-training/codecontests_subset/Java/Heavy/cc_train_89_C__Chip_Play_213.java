import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[] cd;
	
	
	public static void main(String[] args) throws IOException {
		cd = new int[128];
		cd['L'] = 0;
		cd['U'] = 1;
		cd['R'] = 2;
		cd['D'] = 3;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String[] nm = in.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		char[][] map = new char[n][];
		for (int i = 0 ; i < n ; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		if (n > m) {
			char[][] nmap = new char[m][n];
			for (int i = 0 ; i < m ; i++) {
				for (int j = 0 ; j < n ; j++) {
					nmap[i][j] = map[j][i];
					if (map[j][i] == 'R') {
						nmap[i][j] = 'D';
					}
					if (map[j][i] == 'D') {
						nmap[i][j] = 'R';
					}
					if (map[j][i] == 'L') {
						nmap[i][j] = 'U';
					}
					if (map[j][i] == 'U') {
						nmap[i][j] = 'L';
					}
				}
			}
			map = nmap;
			n = map.length;
			m = map[0].length;
		}
		
		int cnt = 0;
		int max = 0;
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if (map[i][j] != '.') {
					int res = solve(i, j, map);
					if (max == res) {
						cnt++;
					} else if (max < res) {
						max = res;
						cnt = 1;
					}
				}
			}
		}
		
		out.println(max + " " + cnt);
		out.flush();
	}
	
	private static int solve(int ny, int nx, char[][] map) {
		int n = map.length;
		int m = map[0].length;
		int[][] next = new int[4][n*m];
		boolean[][] visited = new boolean[n][m];
		for (int d = 0 ; d < 4 ; d++) {
			Arrays.fill(next[d], -2);
			int fi = (d == 3) ? n-1 : 0;
			int ti = (d == 3) ? -1 : n;
			int di = (d == 3) ? -1 : 1;
			int fj = (d == 2) ? m-1 : 0;
			int tj = (d == 2) ? -1 : m;
			int dj = (d == 2) ? -1 : 1;
			
			for (int i = fi ; i != ti ; i += di) {
				for (int j = fj ; j != tj ; j += dj) {
					int id = i*m+j;
					int ni = i+dy[d];
					int nj = j+dx[d];
					int nid = ni*m+nj;
					if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
						next[d][id] = -1;
					} else {
						if (map[ni][nj] == '.') {
							next[d][id] = (next[d][nid] == -1) ? -1 : next[d][nid];
						} else {
							next[d][id] = nid;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		while (true) {
			cnt++;
			int nd = cd[map[ny][nx]];
			visited[ny][nx] = true;
			int nid = ny*m+nx;
			for (int d = 0 ; d < 4 ; d++) {
				int od = (d+2)%4;
				int tid = next[d][nid];
				if (tid >= 0) {
					next[od][tid] = next[od][nid];
				}
			}
			while (nid >= 0 && visited[ny][nx]) {
				nid = next[nd][nid];
				ny = nid/m;
				nx = nid%m;
			}
			if (nid == -1) {
				break;
			}
		}
		return cnt;
	}

	
	
	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}
