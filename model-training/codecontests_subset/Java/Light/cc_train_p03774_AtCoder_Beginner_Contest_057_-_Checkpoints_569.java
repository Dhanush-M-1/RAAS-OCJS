import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(), M = scan.nextInt();
		int[][] student = new int[N][2];
		int[][] check = new int[M][2];

		for(int i=0; i<N; i++) {
			student[i][0] = scan.nextInt();
			student[i][1] = scan.nextInt();
		}

		for(int i=0; i<M; i++) {
			check[i][0] = scan.nextInt();
			check[i][1] = scan.nextInt();
		}

		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minj=0;
			for(int j=0; j<M; j++) {
				int d =  Math.abs(student[i][0]-check[j][0])+Math.abs(student[i][1]-check[j][1]);
				if(d<min) {
					min=d;
					minj = j;
				}
			}
			System.out.println(minj+1);
		}

	}

}