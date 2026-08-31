import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F[][] = new int[N][10];
		int P[][] = new int[N][11];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				F[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= 10; j++) {
				P[i][j] = sc.nextInt();
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < Math.pow(2, 10); i++) {
			if(i == 0) continue;
			int temp = 0;
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				for(int k = 0; k < 10; k++) {
					if((1 & i >> k) == 1) {
						if(F[j][k] == 1) cnt++;;
					}
				}
				temp += P[j][cnt];
			}
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
	}
}
