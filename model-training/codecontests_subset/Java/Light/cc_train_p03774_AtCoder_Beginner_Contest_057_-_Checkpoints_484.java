import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] student = new int[N][2];
		int[][] checkpoint = new int[M][2];
		for(int i = 0;i < N;++i) {
			student[i][0] = sc.nextInt();
			student[i][1] = sc.nextInt();
		}
		for(int i = 0;i < M;++i) {
			checkpoint[i][0] = sc.nextInt();
			checkpoint[i][1] = sc.nextInt();
		}
		sc.close();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < N;++i) {
			int ans = 0;
			int min = Integer.MAX_VALUE;
			for(int j = 0;j < M;++j) {
				int div = Math.abs(student[i][0] - checkpoint[j][0])
						+ Math.abs(student[i][1] - checkpoint[j][1]);
				if(min > div) {
					min = div;
					ans = j+1;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
