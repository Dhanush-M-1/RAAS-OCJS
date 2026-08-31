import java.util.*;
import java.io.*;

public class maze {
	static char[][] map;
	static int k;
	static int added;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();
		k = in.nextInt();
		map = new char[r][c];
		in.nextLine();
		for(int i = 0; i < r; i++) {
			map[i] = in.nextLine().toCharArray();
		}
		added = 0;
		loop:
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == '.') {
					AddWalls(i, j);
					break loop;
				}
			}
		}
		display(map);
	}

	public static int AddWalls(int r, int c) {
		if(r < 0 || c < 0 || r >= map.length || c >= map[0].length) {
			return 0;
		}
		if(map[r][c] == '@' || map[r][c] == '#' || map[r][c] == 'X') {
			return 0;
		}
		if(added == k) {
			return 0;
		}
		map[r][c] = '@';
		int recur = 0;
		for(int i = 0; i < 4; i++) {
			recur += AddWalls(r + dx[i], c + dy[i]);
		}
		map[r][c] = '.';
		if(recur == 0 && added < k) {
			map[r][c] = 'X';
			added++;
			return 0;
		}
		return 1;
	}

	public static void display(char[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
