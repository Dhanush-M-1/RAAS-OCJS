import java.util.*;
import java.io.*;

public class B {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		char[][] board = new char[4][4];

		for (int i = 0; i < 4; i++) {
			String line = in.next();
			for (int j = 0; j < 4; j++) { 
				board[i][j] = line.charAt(j);
			}
		}

		int[][] dirs = new int[][]{{0, 1}, {1, 0}, {1, 1}, {1, -1}, 
		{0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'x';

					for (int k = 0; k < dirs.length; k++) {
						int drow = dirs[k][0];
						int dcol = dirs[k][1];

						for (int ii = 0; ii < 4; ii++) {
							for (int jj = 0; jj < 4; jj++) {

								boolean valid = true;

								for (int l = 0; l < 3; l++) {
									int row = ii + l * drow;
									int col = jj + l * dcol;

									if (row < 0 || row >= 4) { valid = false; break;}
									if (col < 0 || col >= 4) { valid = false; break;}
									if (board[row][col] != 'x') { valid = false; break;}
								}

								if (valid) {
									//System.err.println(i + " " + j + " " + k);
									System.out.println("YES");
									return;
								}

							}
						}
					}


					board[i][j] = '.';
				}
			}
		}
		System.out.println("NO");
	}
}
