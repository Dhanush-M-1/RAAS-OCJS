import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];
		int[] c = new int[m + 1];
		int[] d = new int[m + 1];
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 1; i <= m; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		int min, op;
		for(int i = 1; i <= n; i++) {
			min = Math.abs(a[i] - c[1]) + Math.abs(b[i] - d[1]);
			op = 1;
			for(int j = 2; j <= m; j++) {
				if(min > Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j])) {
					min = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
					op = j;
				}
				
			}
			System.out.println(op);
		}
		
	}
}