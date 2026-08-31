

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int c[] = new int[m];
		int d[] = new int[m];
		for(int i = 0; i < m; i++){
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			int index = 0;
			int minDist = Integer.MAX_VALUE;

			for(int j = 0; j < m; j++){
				int tmpDist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);

				if(tmpDist < minDist){
					index = j;
					minDist = tmpDist;
				}
			}

			System.out.println(index + 1);
		}
    }
}