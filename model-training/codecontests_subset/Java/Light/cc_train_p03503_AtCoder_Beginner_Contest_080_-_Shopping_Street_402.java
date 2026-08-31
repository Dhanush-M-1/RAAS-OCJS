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
		int ans = -Integer.MAX_VALUE;
		for(int mask = 1 ; mask < (1<<10) ; mask++) {
			int[] cnt = new int[n];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					if(f[i][j] == 1 && (mask&(1<<j)) >= 1) {
						cnt[i]++;
					}
				}
			}
			int sum = 0;
			for(int i = 0 ; i < n ; i++) {
				sum += p[i][cnt[i]];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}
