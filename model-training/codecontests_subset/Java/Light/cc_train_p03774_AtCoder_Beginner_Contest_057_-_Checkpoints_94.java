
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //学生数
		int M = sc.nextInt(); //チェックポイント数
		
		int[] a = new int[N]; //学生N人のx座標
		int[] b = new int[N]; //学生N人のy座標
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		int[] c = new int[M];
		int[] d = new int[M];
		
		for(int i = 0; i < M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		
		
		for(int i = 0; i < N; i++) {
			int min = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
			int near_cp = 0;
			
			for(int j = 0; j < M; j++) {
				int dist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if(dist < min) {
					min = dist;				
					near_cp = j;				
				}
			}
			System.out.println(near_cp + 1);
		}
	}
}

