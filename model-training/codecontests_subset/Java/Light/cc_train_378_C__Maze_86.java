import java.util.LinkedList;
import java.util.Scanner;

public class C222 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		char[][] grid = new char[n][m];
		boolean[][] v = new boolean[n][m];
		int si = 0;
		int sj = 0;
		for(int i = 0; i < n; ++i) {
			String line = sc.next();
			for(int j = 0; j < m; ++j) {
				grid[i][j] = line.charAt(j);
				if(grid[i][j] == '.') {
					si = i;
					sj = j;
				}
			}
		}
		
		int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};
		
		LinkedList<Cell> q = new LinkedList();
		q.push(new Cell(si, sj));
		v[si][sj] = true;
		while(k > 0) {
			Cell c = q.peek();
			boolean leaf = true;
			for(int p = 0; p < 4; ++p) {
				si = c.i+pos[p][0];
				sj = c.j+pos[p][1];
				if(si >= 0 && si < n && sj >= 0 && sj < m)
					if(!v[si][sj] && grid[si][sj] == '.') {
						leaf = false;
						q.push(new Cell(si, sj));
						v[si][sj] = true;
					}
			}
			if(leaf) {
				grid[c.i][c.j] = 'X';
				q.poll();
				k--;
			}
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j)
				System.out.print(grid[i][j]);
			System.out.println();
		}
	}
	
	static class Cell {
		int i, j;
		
		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
