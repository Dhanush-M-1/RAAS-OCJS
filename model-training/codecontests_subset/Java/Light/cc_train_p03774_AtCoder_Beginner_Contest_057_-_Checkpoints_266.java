
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, m, a[][], c[][];
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][2];
		c = new int[m][2];
		for(int i = 0; i < n; ++i) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		for(int i = 0; i < m; ++i) {
			c[i][0] = sc.nextInt();
			c[i][1] = sc.nextInt();
		}
		
		int min;
		int min_num;
		int d = 0;
		for(int i = 0; i < n; ++i) {
			min = 2000000000;
			min_num = 0;
			for(int j = 0; j < m; ++j) {
				d = Math.abs(a[i][0] - c[j][0]) + Math.abs(a[i][1] - c[j][1]); 
				if(min > d) {
					min = d;
					min_num = j + 1;
				}
			}
			System.out.println(min_num);
		}
		
		sc.close();
	}

}
