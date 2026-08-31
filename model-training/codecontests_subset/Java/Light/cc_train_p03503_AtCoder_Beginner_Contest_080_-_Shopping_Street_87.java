import java.util.*;
import static java.lang.System.*;

public class Main {
	public static void main(String[] args){
    Scanner sc = new Scanner(in);
    int n = sc.nextInt();
		int[][] f = new int[n][10];
		long[][] p = new long[n][11];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				f[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 11; j++) {
				p[i][j] = sc.nextLong();
			}
		}

		long answer = Long.MIN_VALUE;

		for (int i = 1; i < (1 << 10); i++) {
			long point = 0;
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 9; k >= 0; k--) {
					if (((i >> k) & f[j][9-k]) == 1) {
						cnt++;
					}
				}
				point += p[j][cnt];
			}
			answer = Math.max(answer, point);
		}

		System.out.println(answer);
	}
}
