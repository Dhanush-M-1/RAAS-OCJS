import java.io.BufferedReader;
import java.io.InputStreamReader;


public class C222Div2
{
	static int cnt = 0;
	static void dfs(int[][] mark, char[][] maze, int r, int c, int k)
	{
		if (mark[r][c] != 0 || maze[r][c] == '#') return;
		mark[r][c] = 1;
		if (cnt == k) return;
		if (r+1 < mark.length) dfs(mark,maze,r+1,c,k);
		if (r-1 >= 0) dfs(mark,maze,r-1,c,k);
		if (c+1 < mark[0].length) dfs(mark,maze,r,c+1,k);
		if (c-1 >= 0) dfs(mark,maze,r,c-1,k);
		if (cnt == k) return;
		maze[r][c] = 'X';
		cnt++;
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] toks = in.readLine().split("\\s+");
		int n = Integer.parseInt(toks[0]), m = Integer.parseInt(toks[1]), k = Integer.parseInt(toks[2]);
		char[][] maze = new char[n][];
		for (int i = 0; i < n; ++i) maze[i] = in.readLine().toCharArray();
		int[][] mark = new int[n][m];
		for (int r = 0; r < n; ++r) for (int c = 0; c < m; ++c) dfs(mark,maze,r,c,k);
		for (int i = 0; i < n; ++i) System.out.println(new String(maze[i]));
	}
}
