import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner sc = new Scanner((System.in));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] s = new int[N][2];
		int[][] c = new int[M][2];
		for(int i = 0; i < N; i++) {
			s[i][0] = sc.nextInt();
			s[i][1] = sc.nextInt();
		}
		for(int i = 0; i < M; i++) {
			c[i][0] = sc.nextInt();
			c[i][1] = sc.nextInt();
		}

		for(int i =0; i < N; i++) {
			int min = Math.abs(s[i][0] -c[0][0]) + Math.abs(s[i][1] -c[0][1]);
			int tmp = 0;
			int num = 1;
			for(int j = 0; j < M; j++) {
				tmp = Math.abs(s[i][0] -c[j][0]) + Math.abs(s[i][1] -c[j][1]);
				if(tmp < min) {
					min = tmp;
					num = j + 1;
				}
			}
			System.out.println(num);
		}
		}
}