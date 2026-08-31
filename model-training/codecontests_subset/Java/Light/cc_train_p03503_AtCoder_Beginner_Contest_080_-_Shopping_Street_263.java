import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] F = new int[N][10];
		int[][] P = new int[N][11];
		
		for(int i = 0;i < N;++i)
			for(int j = 0;j < 10;++j)
				F[i][j] = sc.nextInt();
		for(int i = 0;i < N;++i)
			for(int j = 0;j < 11;++j)
				P[i][j] = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		for(int i = 1;i < 1024;++i) {
			int[] duplicate = new int[N];
			for(int j = 0;j < N;++j)
				for(int k = 0;k < 10;++k)
					if(((i >>> k)%2 == 1) && F[j][k] == 1)
						++duplicate[j];
			int score = 0;
			for(int j = 0;j < N;++j)
				score += P[j][duplicate[j]];
			if(score > max)
				max = score;
		}
		System.out.println(max);
		sc.close();
	}
}
