//package Codeforces479;

import java.util.Scanner;

public class BProblem {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next(), res = "";
		int ans = 0, c = 0;
		for (int i = 0; i < str.length()-1; i++) {
			c = 0;
			for (int j = 0; j < str.length()-1; j++)
				if (str.substring(i,i+2).equals(str.substring(j, j+2))) c++;
			if (c > ans) {
				ans = c;
				res = str.substring(i, i+2);
			}
		}
		
		System.out.println(res);
		
	}
}
