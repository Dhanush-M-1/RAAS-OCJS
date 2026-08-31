import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[][] map =new int[3][N];
		int[] cc = new int[N-1];
		int s= 0;

		for(int i=0;i<2;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N-1;i++) {
			cc[i]=sc.nextInt();
		}

		for(int i=0;i<N;i++) {
			s+=map[1][map[0][i]-1];
			if(i>0) {
				int c = map[0][i]-map[0][i-1];
				if(c==1) {
					s+=cc[map[0][i-1]-1];
				}
			}
		}
		System.out.println(s);
	}
}