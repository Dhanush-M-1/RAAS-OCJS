import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[M];
		int[] d = new int[M];
		for(int i = 0;i < N;i ++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 0;i < M;i ++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		for(int i = 0;i < N;i ++) {
			int min = 0, minidx = 0, dist = 0;
			for(int k = 0;k < M;k ++) {
				dist = Math.abs(a[i] - c[k]) + Math.abs(b[i] - d[k]);
				if(min > dist || k == 0) {
					min = dist;
					minidx = k + 1;
				}
			}
			System.out.println(minidx);
		}
	}
}