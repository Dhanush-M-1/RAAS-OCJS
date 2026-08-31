import java.util.Scanner;

public class TaskB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = new int[4][4];
		for (int i = 0; i < 4; i++) {
			String s = in.next();
			for (int j = 0; j < 4; j++) {
				if (s.charAt(j) == 'x') {
					a[i][j] = 1;
				}
				if (s.charAt(j) == 'o') {
					a[i][j] = -1;
				}
			}
		}
		boolean ans = false;
		for (int i = 0; i < 4; i++) {
			if (a[i][0] + a[i][1] + a[i][2] == 2) {
				ans = true;
			}
			if (a[i][3] + a[i][1] + a[i][2] == 2) {
				ans = true;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (a[0][i] + a[1][i] + a[2][i] == 2) {
				ans = true;
			}
			if (a[3][i] + a[1][i] + a[2][i] == 2) {
				ans = true;
			}
		}
		if (a[0][0] + a[1][1] + a[2][2] == 2) {
			ans = true;
		}
		if (a[3][3] + a[1][1] + a[2][2] == 2) {
			ans = true;
		}
		if (a[0][1] + a[1][2] + a[2][3] == 2) {
			ans = true;
		}
		if (a[1][0] + a[2][1] + a[3][2] == 2) {
			ans = true;
		}
		if (a[3][0] + a[2][1] + a[1][2] == 2) {
			ans = true;
		}
		if (a[0][3] + a[2][1] + a[1][2] == 2) {
			ans = true;
		}
		if (a[3][1] + a[2][2] + a[1][3] == 2) {
			ans = true;
		}
		if (a[2][0] + a[1][1] + a[0][2] == 2) {
			ans = true;
		}
		if (ans) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
