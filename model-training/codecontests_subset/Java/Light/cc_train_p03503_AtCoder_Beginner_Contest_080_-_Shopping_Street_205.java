import java.util.Scanner;

class Main{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt(); // # of shops
		int[][] F = new int[N][10];
		int[][] P = new int[N][11];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) F[i][j] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 11; j++) P[i][j] = sc.nextInt();
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i < (1 << 10); i++) {
			int[] c = new int[N];
			for(int j = 0; j < N; j++) {
				// 店jと一致する時間帯を計算
				for(int k = 0; k < 10; k++) {
					if(((i >> k) & 1) == 1 && F[j][k] == 1) c[j]++;
				}
			}
			int tmp = 0;
			for(int j = 0; j < N; j++) tmp += P[j][c[j]];
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}