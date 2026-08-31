import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] f = new int[n][10];
		int[][] p = new int[n][11];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				f[i][j] = sc.nextInt();
			}
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < 11 ; j++) {
				p[i][j] = sc.nextInt();
			}
		}
		int ans = -1001001001;
		for(int mask = 1 ; mask < (1<<10) ; mask++) {
			int money = 0;
			for(int i = 0 ; i < n ; i++) {
				int cnt = 0;
				for(int j = 0 ; j < 10 ; j++) {
					if((mask&(1<<j)) >= 1 && f[i][j] == 1) cnt++;
				}
				money += p[i][cnt];
			}
			ans = Math.max(ans, money);
		}
		System.out.println(ans);
	}
}
