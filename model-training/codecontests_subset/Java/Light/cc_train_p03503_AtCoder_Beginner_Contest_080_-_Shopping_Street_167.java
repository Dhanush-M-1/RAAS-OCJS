import java.util.Scanner;

public class Main {

	static int ans = -2001001001;
	static int[] a = new int[10];
	static int[][] f, p;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		f = new int[n][10];
		p = new int[n][11];
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
		dfs(0);
		System.out.println(ans);
	}

	// 0000000000~1111111111の配列aを生成
	public static void dfs(int pos) {
		if(pos == 10) {
			func();
			return;
		}
		a[pos] = 0; dfs(pos + 1);
		a[pos] = 1; dfs(pos + 1);
	}

	// 0000000000~1111111111のそれぞれを全部試して計算する関数
	public static void func() {
		if(check()) return;
		int score = 0;
		for(int i = 0 ; i < n ; i++) {
			int cnt = 0;
			for(int j = 0 ; j < 10 ; j++) {
				if((a[j]&f[i][j]) == 1) cnt++;
			}
			score += p[i][cnt];
		}
		ans = Math.max(ans, score);
	}

	// a[i]が全て0かどうかのチェック
	public static boolean check() {
		boolean ok = true;
		for(int i = 0 ; i < 10 ; i++) {
			if(a[i] == 1) ok = false;
		}
		return ok ? true : false;
	}

}