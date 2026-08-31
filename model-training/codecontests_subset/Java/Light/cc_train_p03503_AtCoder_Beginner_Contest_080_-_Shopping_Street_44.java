import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] f = new int[n][10];
		int[][] p = new int[n][11];
		for(int i  = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				f[i][j] = sc.nextInt();
			}
		}
		for(int i  = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 11 ; j++) {
				p[i][j] = sc.nextInt();
			}
		}
		int ans = -1001001001;
		// 0000000000~1111111111パターン生成
		for(int mask = 1 ; mask < (1<<10) ; mask++) {
			int score = 0;
			for(int i = 0 ; i < n ; i++) {
				int cnt = 0;
				for(int j = 0 ; j < 10 ; j++) {
					if(((mask>>j)&1) == 1 && f[i][j] == 1) {
						cnt++;
					}
				}
				score += p[i][cnt];
			}
			ans = Math.max(ans, score);
		}
		System.out.println(ans);
	}
}