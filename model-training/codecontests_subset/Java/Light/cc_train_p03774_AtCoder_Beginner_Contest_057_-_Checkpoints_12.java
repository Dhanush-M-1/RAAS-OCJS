
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[M];
		int[] d = new int[M];
		int[] Num = new int[N];
		int max = 1000000000;
		
		for(int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			c[i] = scan.nextInt();
			d[i] = scan.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if((int)Math.abs(a[i] - c[j]) + (int)Math.abs(b[i] - d[j]) < max) {
					max = (int)Math.abs(a[i] - c[j]) + (int)Math.abs(b[i] - d[j]);
					Num[i] = j + 1;
				}
			}
			max = 1000000000;
			System.out.println(Num[i]);
		}
		
		scan.close();

	}

}
