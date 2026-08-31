import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] F = new int[N][10];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				F[i][j] = sc.nextInt();
			}
		}
		
		int[][] P = new int[N][11];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 11; j++) {
				P[i][j] = sc.nextInt();
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < (1 << 10); i++) {
			
			int x = 0;
			for (int n = 0; n < N; n++) {
				int count = 0;
				for (int j = 0; j < 10; j++) {
					if (((i>>>j)&1) == 1 && F[n][j] == 1) count++;
				}
				x += P[n][count];
			}
			max = Math.max(max, x);
		}
		
		System.out.println(max);
	}
}