import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n], b = new int[n];
		int[] c = new int[m], d = new int[m];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int j = 0; j < m; j++) {
			c[j] = sc.nextInt();
			d[j] = sc.nextInt();
		}
		int dist, min_dist, checkpoint;
		for(int i = 0; i < n; i++) {
			min_dist = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
			checkpoint = 0;
			for(int j = 1; j < m; j++) {
				dist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if(dist < min_dist) {
					min_dist = dist;
					checkpoint = j;
				}
			}
			System.out.println(checkpoint + 1);
		}
	}
}