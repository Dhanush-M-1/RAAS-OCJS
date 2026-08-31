import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] f = new int[n][10];
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				f[i][j] = in.nextInt();
			}
		}
		int[][] p = new int[n][11];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=10;j++) {
				p[i][j] = in.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=1023;i++) {
			int[] joisino = new int[10];
			for(int j=0;j<10;j++) {
				joisino[j] = (i>>j)&1;
			}
			int sum = 0;
			for(int j=0;j<n;j++) {
				int c = 0;
				for(int k=0;k<10;k++) {
					c += joisino[k] * f[j][k];
				}
				sum += p[j][c];
			}
			if(sum>max) max = sum;
		}
		System.out.println(max);
		in.close();

	}

}