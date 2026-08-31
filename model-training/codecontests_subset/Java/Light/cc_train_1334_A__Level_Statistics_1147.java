

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {

			int n = nik.nextInt();

			int[][] a = new int[n][2];
			boolean b = true;

			a[0][0] = nik.nextInt();
			a[0][1] = nik.nextInt();
			if (a[0][0] < a[0][1]) {
				b = false;
			}

			int maxa = a[0][0];
			int maxb = a[0][1];
			for (int i = 1; i < n; i++) {
				a[i][0] = nik.nextInt();
				a[i][1] = nik.nextInt();
				if (a[i][1] < a[i - 1][1] || a[i][0] < a[i - 1][0]) {
					b = false;

				} else if (a[i][1] - a[i - 1][1] > a[i][0] - a[i - 1][0]) {
					b = false;

				}
			}

			if (b) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

}