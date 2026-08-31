

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public ArrayList<Integer> sh;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] f = new int[n][10];
		int[][] p = new int[n][11];
		int re = Integer.MIN_VALUE;
		
		for(int i = 0;i < n;++i){
			for(int j = 0;j < 10;++j){
				f[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i < n;++i){
			for(int j = 0;j < 11;++j){
				p[i][j] = sc.nextInt();
			}
		}

		for(int i = 1;i < 1024;++i){
			String bin = Integer.toBinaryString(i);
			int[] sh = new int[n];
			int tm = 0;
			bin = String.format("%10s", bin).replaceAll(" ", "0");
			//比較して被ってる分を数える
			for(int j = 0;j < 10;++j){
				int d = bin.charAt(j);
				if(d == '1'){
					for(int k = 0;k < n;++k){
						if(f[k][j] == 1) sh[k] += 1;
					}
				}
			}
			
			for(int k = 0;k < n;++k){
				tm += p[k][sh[k]];
			}
			
			re = Math.max(re, tm);
		}

		System.out.println(re);
	}
}
