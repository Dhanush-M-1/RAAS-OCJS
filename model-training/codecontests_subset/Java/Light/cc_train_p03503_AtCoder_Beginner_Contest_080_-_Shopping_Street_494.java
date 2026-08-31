import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F[][][] = new int[N][5][2];
		int P[][] = new int[N][11];
		for (int i= 0;i<N;i++) {
			for (int j=0;j<5;j++) {
				for (int k=0;k<2;k++) {
					F[i][j][k] = sc.nextInt();
				}
			}
		}
		for (int i= 0;i<N;i++) {
			for (int j=0;j<11;j++) {
				P[i][j] = sc.nextInt();
			}
		}
		int sum =Integer.MIN_VALUE;
		for (int i=1;i<1024;i++) {
			int temp=0;
			int pattern[] = Main.intToArray(i);
			for (int j=0;j<N;j++) {
				int count=0;
				for (int k=0;k<10;k++) {
					if (pattern[k]== F[j][k/2][k%2]&& F[j][k/2][k%2]==1) {
						count++;
					}
				}
				temp +=P[j][count];
			}
			if (temp>sum) {
				sum =temp;
			}
		}
		System.out.println(sum);
	}

	public static int[] intToArray(int a) {
		int result[] = new int[10];
		int i =0;
		while (a>0) {
			result[i] = a%2;
			a/=2;
			i++;
		}
		return result;
	}
}