import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arrN = new int[n][2];
		for (int i = 0; i < n; i++) {
			arrN[i][0] = sc.nextInt();
			arrN[i][1] = sc.nextInt();
		}
		int[][] arrM = new int[m][2];
		for (int i = 0; i < m; i++) {
			arrM[i][0] = sc.nextInt();
			arrM[i][1] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int point = 0;
			for (int j = 0; j < m; j++) {
				int d = Math.abs(arrN[i][0] - arrM[j][0]) + Math.abs(arrN[i][1] - arrM[j][1]);
				if (min > d) {
					min = d;
					point = j + 1;
				}
			}
			sb.append(point).append("\n");
		}
		System.out.println(sb);
	}
}
