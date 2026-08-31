import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		int[] c = new int[m];
		int[] d = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int nearestPoint = -1;
			int nearestDis = Integer.MAX_VALUE;
			
			for (int j = 0; j < m; j++) {
				int dis = calcDis(a[i], b[i], c[j], d[j]);
				if (dis < nearestDis) {
					nearestDis = dis;
					nearestPoint = j + 1;
				}
			}
			System.out.println(nearestPoint);
		}
		
		sc.close();
	}
	
	static int calcDis(int a, int b, int c, int d) {
		return Math.abs(a - c) + Math.abs(b - d);
	}
}


