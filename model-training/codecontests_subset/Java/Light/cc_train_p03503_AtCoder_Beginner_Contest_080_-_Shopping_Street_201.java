

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//店の個数

		//そのお店が開催しているか 0 or 1
		int[][] f = new int[n][10];
		for(int i=0; i<n; i++){{
			for(int j=0; j<10; j++){
				f[i][j] = sc.nextInt();

			}
		}
		}

		//そのお店の開催時期との被りの個数によって異なる利益
		int[][] p = new int[n][11];
		for(int i=0; i<n; i++){
			for(int j=0; j<11; j++){
				p[i][j] = sc.nextInt();
			}
		}

		int[][] joi = new int[1023][10];
		String strrr;
		for(int i=0; i<1023; i++){
			for(int j=0; j<10; j++){
				strrr = Integer.toBinaryString(i+1);
				for(; strrr.length()<10;){
					strrr = "0"+strrr;
				}
				joi[i][j] = strrr.charAt(j) - '0';
			}
		}
		int[][] c = new int[1023][n];
		int[] y = new int[1023];
		for(int i=0; i<1023; i++){
			for(int j=0; j<10; j++){
				if(joi[i][j]==1){
					for(int g=0; g<n; g++){
						if(f[g][j]==1){
							c[i][g]++;
						}
					}
				}
			}
			for(int j=0; j<n; j++){
				y[i] += p[j][ c[i][j] ];
			}
		}

		int w = y[0];
		for(int i=1; i<1023; i++){
			if(w<y[i]){
				w=y[i];
			}
		}
		System.out.println(w);


	}

}
