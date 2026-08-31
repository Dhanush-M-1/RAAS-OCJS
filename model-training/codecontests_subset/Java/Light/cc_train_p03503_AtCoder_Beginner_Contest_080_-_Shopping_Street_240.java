import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] F = new boolean[N][10];
		int[][] P = new int[N][11];
		
		for(int i = 0;i < N;++i)
			for(int j = 0;j < 10;++j)
				F[i][j] = sc.nextInt() == 1;
		for(int i = 0;i < N;++i)
			for(int j = 0;j < 11;++j)
				P[i][j] = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		for(int i = 1;i < 1024;++i) {
			boolean[] isOpen = new boolean[10];
			for(int j = 0;j < 10;++j)
				isOpen[j] = (i>>>j)%2 == 1;
			int[] duplicate = new int[N];
			for(int j = 0;j < N;++j)
				for(int k = 0;k < 10;++k)
					if(isOpen[k] && F[j][k])
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