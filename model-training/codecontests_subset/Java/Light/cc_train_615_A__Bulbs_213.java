//package educational;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//http://codeforces.com/contest/615/problem/A
public class Bulbs {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int x = scan.nextInt();
			for (int j = 0; j < x; j++) {
				set.add(scan.nextInt());
			}
		}
		System.out.println(set.size() == m ? "YES" : "NO");
		scan.close();
	}
}
