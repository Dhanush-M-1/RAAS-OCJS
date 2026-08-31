//package com.pb.codeforces.practice;

import java.util.Scanner;

public class CF545C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		for(int i=0; i<n; i++) {
			x[i] = in.nextInt();
			h[i] = in.nextInt();
		}
		if(n <= 2) { System.out.println(n); }
		else{
			int cnt = 2;
			int l = x[0];
			for(int i=1; i<n-1; i++) {
				if((x[i] - h[i]) > l) { cnt++; l = x[i]; continue; }
				else if((x[i]+h[i]) < x[i+1]) { cnt++; l = x[i]+h[i]; continue; }
				else { l = x[i]; }
			}
			System.out.println(cnt);
		}
	}
}
