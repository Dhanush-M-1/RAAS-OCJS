import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][2];
		int[][] c = new int[m][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			c[i][0] = sc.nextInt();
			c[i][1] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		int num = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			num = 0; min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				if(Math.abs(c[j][0]-a[i][0])+Math.abs(c[j][1]-a[i][1])<min) {
					min = Math.abs(c[j][0]-a[i][0])+Math.abs(c[j][1]-a[i][1]);
					num = j;
				}
			}
			sb.append(num+1);
			sb.append("\n");
		}
		System.out.println(new String(sb));
		sc.close();
	}
}