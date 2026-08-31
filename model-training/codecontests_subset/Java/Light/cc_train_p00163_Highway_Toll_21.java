
import static java.util.Arrays.deepToString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	void tr(Object... os) {
		System.err.println(deepToString(os));
	}

	Scanner sc = new Scanner(System.in);
	public void run() {
		for (;sc.hasNext();) {
			int from = sc.nextInt();
			if (from == 0) break;
			int ft = sc.nextInt() * 100 + sc.nextInt();
			int to = sc.nextInt();
			int tt = sc.nextInt() * 100 + sc.nextInt();
			int d = getD(from, to);
			int fee = getF(from, to);
			boolean half = (isin(ft) || isin(tt)) && d <= 40;
			if (half) {
				fee = (fee / 2 + 49) / 50 * 50;
			}
			System.out.println(fee);
		}
	}
	
	int getD(int a, int b) {
		if (a > b) { int tmp = a; a = b; b = tmp; }
		return t[b][a];
	}
	int getF(int a, int b) {
		if (a > b) { int tmp = a; a = b; b = tmp; }
		return t[a][b];
	}
	
	int[][] t = new int[][] {
		{0, 0, 0, 0, 0, 0, 0, 0,},
		{0, 0, 300, 500, 600, 700, 1350, 1650,},
		{0, 6, 0, 350, 450, 600, 1150, 1500,},
		{0, 13, 7, 0, 250, 400, 1000, 1350,},
		{0, 18, 12, 5, 0, 250, 850, 1300,},
		{0, 23, 17, 10, 5, 0, 600, 1150,},
		{0, 43, 37, 30, 25, 20, 0, 500,},
		{0, 58, 52, 45, 40, 35, 15, 0,}
	};
	
	boolean isin(int t) {
		return 1730 <= t && t <= 1930;
	}
}