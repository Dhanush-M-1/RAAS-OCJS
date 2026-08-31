import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int N = sc.nextInt();
		int M = sc.nextInt();

		long gakusei[][] = new long[N][2];
		long point[][] = new long[M][2];

		for (int i = 0; i < N; i++) {
			gakusei[i][0] = sc.nextInt();
			gakusei[i][1] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}

		long goalhairetsu[] = new long[N];
		for (int i = 0; i < N; i++) {
			long manhattan = 999999999;
			long goal = 999999999;
			long kyori;
			for (int j = 0; j < M; j++) {
				kyori = Math.abs((gakusei[i][0] - point[j][0])) + Math.abs((gakusei[i][1] - point[j][1]));
				if (kyori < manhattan) {
					manhattan = kyori;
					goal = j + 1;
				}
			}
			goalhairetsu[i] = goal;
		}
		// 出力
		for (int i = 0; i < N; i++) {
			System.out.println(goalhairetsu[i]);
		}
	}
}
