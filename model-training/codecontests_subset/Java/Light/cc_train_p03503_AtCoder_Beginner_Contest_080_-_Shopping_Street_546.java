import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		solve();
	}
	public static void solve(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][][] f = new int[n][5][2];
		int[][] p = new int[n][11];
		int max = -1000000001;
		boolean flag = false;
		for(int i=0;i<n;i++){
			for(int j=0;j<5;j++){
				for(int k=0;k<2;k++){
					f[i][j][k] = sc.nextInt();
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<11;j++){
				p[i][j] = sc.nextInt();
			}
		}
		int x = (int)Math.pow(2,10);

		for(int i=1;i<x;i++){
			int[] count = new int[n];
			int[] counter = new int[10];
			int y = i;
			for(int j=9;j>=0;j--){
				if(y>=(int)Math.pow(2,j)){
					y -= (int)Math.pow(2,j);
					counter[j] = 1;
				}
			}
			for(int j=0;j<10;j++){
				if(counter[j]==1){
					for(int k=0;k<n;k++){
						if(f[k][j/2][j%2]==1){
							count[k]++;
						}
					}
				}
			}
			int ans = 0;
			for(int j=0;j<n;j++){
				ans += p[j][count[j]];
			}
			max = (int)Math.max(max,ans);
		}

		System.out.println(max);

	}
}
