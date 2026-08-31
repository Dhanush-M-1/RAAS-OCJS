
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] position = new int[n][2];
		for (int i = 0; i < position.length; i++) {
			position[i][0] = sc.nextInt();
			position[i][1] = sc.nextInt();
		}
		
		int[][] cp = new int[m][2];
		for (int i = 0; i < cp.length; i++) {
			cp[i][0] = sc.nextInt();
			cp[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int ans = 0;
			for (int j = 0; j < m; j++) {
				int distance = Math.abs(position[i][0] - cp[j][0]) + Math.abs(position[i][1] - cp[j][1]);
				if (distance < min) {
					min = distance;
					ans = j + 1;
				}
;			}
			System.out.println(ans);
		}
	}
}