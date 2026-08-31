import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[][] G = new long[N][2];
		for (int i = 0; i < N; i++) {
			long[] temp = new long[2];
			temp[0] = sc.nextInt();
			temp[1] = sc.nextInt();
			G[i] = temp;
		}
		long[][] C = new long[M][2];
		for (int i = 0; i < M; i++) {
			long[] temp = new long[2];
			temp[0] = sc.nextInt();
			temp[1] = sc.nextInt();
			C[i] = temp;
		}
		for (int i = 0; i < N; i++) {
			int near = 0;
			long range = Long.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				long distance = Math.abs(G[i][0] - C[j][0]) + Math.abs(G[i][1] - C[j][1]);
				if (distance < range) {
					range = distance;
					near = j;
				}
			}
			System.out.println(near + 1);
		}
	}

}