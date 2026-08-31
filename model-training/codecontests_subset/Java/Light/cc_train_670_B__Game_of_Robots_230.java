
//  https://codeforces.com/problemset/problem/670/B
//	  B. Game of Robots


import java.util.*;

public class A14 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long array[] = new long[(int) n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextLong();
		}
		sc.close();
		int inc = 1;
		long total =0;
		while (k>total+inc) {
			total+=inc++;
		}

		
		long x = k-total;
		
		System.out.println(array[(int) x-1]);
	}
}