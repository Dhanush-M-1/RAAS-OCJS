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
		for(int i = 1 ; i < (1<<10) ; i++) {
			int money = 0;
			for(int j = 0 ; j < n ; j++) {
				int cnt = 0;
				for(int k = 0 ; k < 10 ; k++) {
					if(((i>>k)&1) == 1 && f[j][k] == 1) {
						cnt++;
					}
				}
				money += p[j][cnt];
			}
			ans = Math.max(ans, money);
		}
		System.out.println(ans);
	}
}
