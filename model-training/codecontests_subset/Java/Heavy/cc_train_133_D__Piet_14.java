import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class D96 {
	static Scanner in = new Scanner(System.in);
	static PrintWriter w = new PrintWriter(System.out, true);

	static int ni() {
		return in.nextInt();
	}

	static String nl() {
		return in.nextLine();
	}

	public static void main(String[] args) {
		int m = ni(), c = ni();
		nl();
		String[] l = new String[m];
		for (int i = 0; i < m; i++) {
			l[i] = nl();
		}
		int n = l[0].length();
		Block black = new Block();
		Block[][] b = new Block[m][n];
		Block[] ab = new Block[2500];
		int abc = 0;
		boolean notall = true;
		while (notall) {
			notall = false;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (b[i][j] == null) {
						notall = true;
						if(l[i].charAt(j)=='0') {
							b[i][j] = black;
							int ti = i;
							for(;ti < m;ti++) if (l[ti].charAt(j)=='0') b[ti][j]  = black; else break;
							int tj = j;
							for(;tj < n;tj++) if (l[i].charAt(tj)=='0') b[i][tj]  = black; else break;
						} else {
							char ch = l[i].charAt(j);
							Block nx = new Block();
							nx.color = ch;
							ab[abc++] = nx;
							int di = 0;
							for(;i+di < m && (l[i+di].charAt(j)==ch);di++);
							int dj = 0;
							for(;j+dj < n && (l[i].charAt(j+dj)==ch);dj++);

							for (int k = 0; k < dj; k++) {
								for (int o = 0; o < di; o++) {
									b[i+o][j+k] = nx;
								}
							}
							nx.td[0] = new int[]{i, j+dj};
							nx.td[1] = new int[]{i+di-1, j+dj};
							nx.td[2] = new int[]{i+di, j+dj-1};
							nx.td[3] = new int[]{i+di, j};
							nx.td[4] = new int[]{i+di-1, j-1};
							nx.td[5] = new int[]{i, j-1};
							nx.td[6] = new int[]{i-1, j};
							nx.td[7] = new int[]{i-1, j+dj-1};
						}
					}
				}
			}
		}
		for (int i = 0; i < abc; i++) {
			for (int j = 0; j < 8; j++) {
				Block bl = ab[i];
				int[] dirs = bl.td[j];
				if (dirs[0] < 0 || dirs[0] >= m ||dirs[1] < 0 ||dirs[1] >= n) bl.dirs[j]=null;
				else if (b[dirs[0]][dirs[1]] == black) bl.dirs[j]=null;
				else bl.dirs[j]=b[dirs[0]][dirs[1]];
			}
		}
		Block block = b[0][0];
		int di = 0;
		for (int i = 0; i < c; i++) {
			if (block.td[0][0]==33&&block.td[0][1]==48) {
				int df = 1;
			}
			if (block.dirs[di] == null) {
				di++;
				di%=8;
			} else {
				block = block.dirs[di];
			}
		}
		w.println(block.color);
	}
	static class Block {
		char color;
		Block[] dirs = new Block[8];
		int[][] td = new int[8][2];
	}

}
