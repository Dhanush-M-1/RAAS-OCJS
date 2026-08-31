import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	private void start() {

		Scanner in = new Scanner(System.in);

		m = in.nextInt();
		n = in.nextInt();

		map = new String[m];

		for (int i = 0; i < m; i++) {
			map[i] = in.next();
		}
		t = map[0].length();
		id = new int[m][t];
		init();
		solve();
	}

	void solve() {
		int dp = 0, cp = 0;
		int cx = 0;
		int cy = 0;
		v = new int[b.size()][4][2];
		int bp = 0;
		v[0][0][0] = 1;
		boolean con = false;
		for (int i = 0; i < n; i++) {
			String pos = select(b.get(bp), dp, cp);
			StringTokenizer st = new StringTokenizer(pos, ",");
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());

			switch (dp) {
			case 0:
				cy++;
				break;
			case 1:
				cx++;
				break;
			case 2:
				cy--;
				break;
			case 3:
				cx--;
				break;
			}

			if (invalid(cx, cy)) {
				if (cp == 0) {
					cp = 1;
				} else {
					cp = 0;
					dp++;
					if (dp == 4) {
						dp = 0;
					}
				}
			} else {
				bp = id[cx][cy];
			}

			if (!con) {
				if (v[bp][dp][cp] == 0) {
					v[bp][dp][cp] = i + 2;
				} else {
					int loop = i + 2 - v[bp][dp][cp];

					while (i + loop < n - 1) {
						i += loop;
					}
					con = true;
				}
			}
		}
		System.out.println(b.get(bp).c);
	}

	// 0 right
	// 1 down
	// 2 left
	// 3 up

	private boolean invalid(int x, int y) {
		if (x < 0 || y < 0 || x >= m || y >= t) {
			return true;
		}
		if (map[x].charAt(y) == '0') {
			return true;
		}
		return false;
	}

	// cp
	// 0 ��ʱ��
	// 1 ˳ʱ��
	private String select(Block block, int dp, int cp) {
		int x, y;
		switch (dp) {
		case 0:
			y = block.y + block.w - 1;
			if (cp == 0) {
				x = block.x;
				return x + "," + y;
			} else {
				x = block.x + block.h - 1;
				return x + "," + y;
			}
		case 1:
			x = block.x + block.h - 1;
			if (cp == 0) {
				y = block.y + block.w - 1;
				return x + "," + y;
			} else {
				y = block.y;
				return x + "," + y;
			}
		case 2:
			y = block.y;
			if (cp == 0) {
				x = block.x + block.h - 1;
				return x + "," + y;
			} else {
				x = block.x;
				return x + "," + y;
			}
		case 3:
			x = block.x;
			if (cp == 0) {
				y = block.y;
				return x + "," + y;
			} else {
				y = block.y + block.w - 1;
				return x + "," + y;
			}
		default:
			break;
		}
		return "";
	}

	class Block {
		int x, y, h, w;
		char c;

	}

	int v[][][];
	List<Block> b;

	void init() {
		b = new ArrayList<Block>();
		boolean v[][] = new boolean[m][t];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < t; j++) {
				if (v[i][j]) {
					continue;
				}
				if (map[i].charAt(j) == '0') {
					continue;
				}

				char ch = map[i].charAt(j);
				int h = 0;
				int w = 0;
				for (int k = i; k < m && map[k].charAt(j) == ch; k++) {
					h++;
					w = 0;
					for (int l = j; l < t && map[k].charAt(l) == ch; l++) {
						v[k][l] = true;
						id[k][l] = b.size();
						w++;
					}
				}
				Block block = new Block();
				block.c = map[i].charAt(j);
				block.x = i;
				block.y = j;
				block.w = w;
				block.h = h;
				b.add(block);
			}
		}
	}

	int[][] id;
	String[] map;
	int m, n, t;

	public static void main(String[] args) {
		new Main().start();
	}
}
