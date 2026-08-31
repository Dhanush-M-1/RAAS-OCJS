//package greedyCodeforces;

import java.util.Scanner;

public class P545c {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] loc = new Integer[n];
		Integer[] h = new Integer[n];
		Integer[] r = new Integer[n];
		in.nextLine();
		for(int i = 0; i < n; ++i){
			String[] s = in.nextLine().split(" ");
			
			loc[i] = Integer.parseInt(s[0]);
			h[i]  =  Integer.parseInt(s[1]);
			
		}
		int ret = 2;
		r[0] = loc[0];
		if(n < 3){
			System.out.println(n);
			in.close();
			return;
		}
		for(int i =1; i < n-1; ++i){
			if(r[i-1] < loc[i] - h[i]){
				r[i] = loc[i];
				ret++;
			}
			else if(loc[i+1] > loc[i] + h[i]){
				r[i] = loc[i] + h[i];
				ret++;
			}
			else{
				r[i] = loc[i];
			}
		}
		System.out.println(ret);
		in.close();
																		
	}
	
	
	

}
