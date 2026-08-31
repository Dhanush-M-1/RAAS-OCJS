import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[][] f = new boolean[n][10];

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < 10; ++j) {
				f[i][j] = in.nextInt() == 1;
			}
		}

		int[][] p = new int[n][11];
		for(int  i = 0; i < n ; ++i) {
			for(int j = 0; j < 11; ++j) {
				p[i][j] = in.nextInt();
			}
		}


		long max = Long.MIN_VALUE;
		for(int mask = 1; mask < 1024; ++mask) {

			long localMax = 0;
			for(int s = 0; s < n; ++s){
				int cnt = 0;
				for(int b = 0; b < 10; ++b) {
					if((mask & (1 << b)) != 0 && (f[s][b])) {
						++cnt;
					}
				}


				localMax += p[s][cnt];
			}

			
			max = Math.max(max, localMax);
		}

		System.out.println(max);

	}


}