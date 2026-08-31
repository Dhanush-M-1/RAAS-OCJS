//package practice;

import java.util.Scanner;

public class cf1101_a {

	static int func(int l , int r , int d ) {
		int x = d;
		while(true) {
			if(x >= l && x <= r) x =  r + d - r % d;
			else return x;
		}
	}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int cases = sc.nextInt();
	sc.nextLine();
	for(int i = 0 ; i < cases ; i++) {
		int l = sc.nextInt();
		int r = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(func(l, r, d));
		sc.nextLine();
	}
	sc.close();
	}

}
