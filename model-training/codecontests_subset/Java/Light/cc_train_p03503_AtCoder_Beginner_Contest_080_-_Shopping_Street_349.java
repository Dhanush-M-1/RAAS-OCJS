import java.nio.ByteBuffer;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] f = new int[n][10];
		int[][] p = new int[n][11];
		for(int i=0; i<n; i++){
			for(int j=0; j<10; j++){
				f[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<11; j++){
				p[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int ans = -1000000007;
		for(int i=1; i<1024; i++){
			int score = 0;
			int num = 0;
			//byte[] b = ByteBuffer.allocate(10).putInt(i).array();
			int[] b = new int[10];
			int mi = i;
			for(int j=9; j>=0; j--){
				b[j] = mi / (int)Math.pow(2, j);
				mi -= b[j] * (int)Math.pow(2, j);
			}
			for(int j=0; j<n; j++){
				num = 0;
				for(int k=0; k<10; k++){
					if(f[j][k] == 1 && b[k] == 1){
						num++;
					}
				}
				score += p[j][num];
			}
			if(score > ans){
				ans = score;
			}
		}
		System.out.println(ans);
	}
}
