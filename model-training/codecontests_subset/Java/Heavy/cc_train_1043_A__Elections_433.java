//  http://codeforces.com/problemset/problem/1043/A
//  A. Elections

import java.util.Scanner;

public class A00 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] array = new int[n];
		int[] array2 = new int[n];
		long sum = 0;
		array[0] = sc.nextInt();
		int max = array[0];
		sum += array[0];
		for (int j = 1; j < n; j++) {
			array[j] = sc.nextInt();
			sum += array[j];
			if (array[j] > max) {
				max = array[j];
			}
		}
		long sum2 = 0;
		for (int j = 0; j < n; j++) {
			array2[j] = max - array[j];
			sum2 += array2[j];
		}

		while((sum2)<=(sum)) {
			sum2+=n;
			max++;
		}
		System.out.println(max);
	}
}
