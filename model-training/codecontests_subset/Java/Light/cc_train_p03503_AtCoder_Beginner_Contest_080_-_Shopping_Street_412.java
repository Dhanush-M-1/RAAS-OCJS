import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[][] f = new int[n][10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				f[i][j] = scanner.nextInt();
			}
		}
		
		int[][] p = new int[n][11];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 11; j++) {
				p[i][j] = scanner.nextInt();
			}
		}
		
		int[] pe = new int[1024];
		for (int i = 1; i < 1024; i++) {
			int[] op = new int[10];
			for (int j = 0; j < op.length; j++) {
				op[j] = (i >> j) & 1;
			}
			
			pe[i] = 0;
			
			for (int j = 0; j < n; j++) {
				int c = 0;
				for (int k = 0; k < 10; k++) {
					if (op[k] == 1 && f[j][k] == 1) {
						c += 1;
					}
				}
				pe[i] += p[j][c];
			}
		}
		
		int maxp = pe[1];
		for (int i = 2; i < pe.length; i++) {
			if (maxp < pe[i]) {
				maxp = pe[i];
			}
		}
		
		System.out.println(maxp);
		
	}
}
