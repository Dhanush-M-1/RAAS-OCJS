import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		int i = 0;
		for(i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}
		for(i = 0; i < m; i++) {
			c[i] = scan.nextInt();
			d[i] = scan.nextInt();
		}
		for(i = 0; i < n; i++) {
			int x = a[i] - c[0];
			int y = b[i] - d[0];
			if(x < 0) {
				x = x * (-1);
			}
			if(y < 0) {
				y = y * (-1);
			}
			int min = x + y;
			int check = 1;
			for(int j = 1; j < m; j++) {
				x = a[i] - c[j];
				y = b[i] - d[j];
				if(x < 0) {
					x = x * (-1);
				}
				if(y < 0) {
					y = y * (-1);
				}
				int t = x + y;
				if(t < min) {
					min = t;
					check = j + 1;
				}
			}
			System.out.println(check);
		}
	}
}