import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			int min = distance(a[i] , b[i], c[0], d[0]);
			int jmin = 0;
			for(int j = 1; j < m; j++) {
				if(distance(a[i], b[i], c[j], d[j]) < min) {
					min = distance(a[i], b[i], c[j], d[j]);
					jmin = j;
				}
			}
			System.out.println(jmin + 1);
		}
	}
	
	private static int distance(int sx, int sy, int tx, int ty) {
		return Math.abs(sx - tx) + Math.abs(sy - ty);
	}
}
