
import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Math.*;

public class C {

	int INF = 1 << 28;
	//long INF = 1L << 62;
	double EPS = 1e-10;
	int h, w, k;
	boolean[][] map, tmp, put;
	void run() {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt(); w = sc.nextInt(); k = sc.nextInt();
		map = new boolean[h+2][w+2]; put = new boolean[h+2][w+2]; tmp = new boolean[h+2][w+2];
		for(int i=1;i<=h;i++) {
			String l = sc.next();
			for(int j=1;j<=w;j++) tmp[i][j] = map[i][j] = l.charAt(j-1) == '.';
		}
		for(int y=1;y<=h;y++) for(int x=1;x<=w;x++) if(map[y][x]) {
			dfs(x, y);
		}
		for(int y=1;y<=h;y++) {
			StringBuilder sb = new StringBuilder();
			for(int x=1;x<=w;x++) {
				if(!tmp[y][x]) sb.append('#');
				else if(put[y][x]) sb.append('X');
				else sb.append('.');
			}
			System.out.println(sb);
		}
	}
	
	int[] dx = {-1,0,1,0};
	int[] dy = {0,-1,0,1};
	void dfs(int x, int y) {
		map[y][x] = false;
		for(int i=0;i<4;i++) if(map[y+dy[i]][x+dx[i]]) {
			dfs(x+dx[i], y+dy[i]);
		}
		
		if(k > 0) {
			put[y][x] = true; k--;
		}
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}

	public static void main(String[] args) {
		new C().run();
	}
}


