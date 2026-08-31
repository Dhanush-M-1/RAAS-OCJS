import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[M];
		int[] d = new int[M];
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			int p = 0;
			int min = 0;
			for(int j = 0; j < M; j++) {
				int x = Math.abs(a[i] - c[j]);
				int y = Math.abs(b[i] - d[j]);
				if(j == 0) {
					min = x + y;
					p = j;
				} else {
					if(x + y < min) {
						min = x + y;
						p = j;
					}
				}
			}
			System.out.println(p + 1);
		}
	}
}
