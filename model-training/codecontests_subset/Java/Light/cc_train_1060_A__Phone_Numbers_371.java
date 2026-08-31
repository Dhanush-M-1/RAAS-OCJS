//  http://codeforces.com/problemset/problem/1060/A
//  A. Phone Numbers


import java.util.Scanner;

public class A01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();
		int a8 = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '8') {
				++a8;
			}
		}
		
		long toot = n/11;
		long soot = Math.min(toot, a8);
		System.out.println(soot);

	}
}