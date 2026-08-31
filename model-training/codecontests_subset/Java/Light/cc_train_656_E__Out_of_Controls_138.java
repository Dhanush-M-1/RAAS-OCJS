import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class E {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt();
		int[][] grid = new int[n][n];
		read(0, grid, n, scan);
		go(0, grid, n);
		out.println(solve(0, grid, n));
		out.close();
	}
	
	static int read(int at, int[][] grid, int n, Scanner scan){
		readLine(at, 0, grid, n, scan);
		return at==n-1?1:read(at+1, grid, n, scan);
	}
	
	static int readLine(int i, int j, int[][] grid, int n, Scanner scan){
		grid[i][j] = scan.nextInt();
		return j==n-1?1:readLine(i, j+1, grid, n, scan);
	}
	
	static int go(int i, int[][] grid, int n){
		go2(i, 0, grid, n);
		return i==n-1?1:go(i+1, grid, n);
	}
	
	static int go2(int i, int j, int[][] grid, int n){
		go3(i, j, 0, grid, n);
		return j==n-1?1:go2(i, j+1, grid, n);
	}
	
	static int go3(int i, int j, int k, int[][] grid, int n){
		grid[j][k] = Math.min(grid[j][k], grid[j][i]+grid[i][k]);
		return k==n-1?1:go3(i, j, k+1, grid, n);
	}
	
	static int solve(int i, int[][] grid, int n){
		int res = Math.max(-1, solve2(i, 0, grid, n));
		return i==n-1?-1:Math.max(res, solve(i+1, grid, n));
	}
	
	static int solve2(int i, int j, int[][] grid, int n){
		return j==n-1?grid[i][j]:Math.max(grid[i][j], solve2(i, j+1, grid, n));
	}

}
