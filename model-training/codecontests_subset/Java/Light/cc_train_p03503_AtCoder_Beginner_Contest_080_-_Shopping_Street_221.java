import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner((System.in));
		int n = sc.nextInt();
		// それぞれの店舗の開店時間帯
		int[][] f = new int[n][10];
		// それぞれの店舗との開店時間帯数による利益
		int[][] p = new int[n][11];
		long ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++){
			f[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 10; j++){
			p[i][j] = sc.nextInt();
			}
		}

		// 開店時間帯の全ての組み合わせをループ
		int cnt = 1;
		while (cnt < Math.pow(2, 10)) {
			// 開店時間を設定
			long sum = 0;
			String open = String.format("%010d", Integer.valueOf(Integer.toBinaryString(cnt)));
		for (int i = 0; i < n; i++) {
			int same = 0;
			for (int j = 0; j < 10; j++) {
				if (open.substring(j, j + 1).equals("1") && f[i][j] == 1) {
					same++;
				}
			}
			sum += p[i][same];
		}
		if (ans < sum || cnt == 1) {
			ans = sum;
		}
		cnt++;
		}

		System.out.println(ans);

		sc.close();
	}
}
