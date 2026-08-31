
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class C {

	public static void main(String[] srgs) throws NumberFormatException, IOException {
		Scanner nik = new Scanner(System.in);

		int n = nik.nextInt();
		long[] a = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = nik.nextLong();
		}

		StringBuilder st = new StringBuilder();
		st.append(1 + " " + n + "\n");

		for (int i = 1; i <= n; i++) {

			st.append((n * (-1) * a[i]) + " ");
		}
		st.append("\n");
		if (n > 1) {
			st.append(2 + " " + n + "\n");

			for (int i = 2; i <= n; i++) {
				st.append(((n - 1) * a[i]) + " ");
			}
			st.append("\n");
		} else {
			st.append("1 1\n" + "0\n");
		}

		st.append("1 1\n");
		long temp = (-1) * (a[1] + (n * (-1) * a[1]));
		st.append(temp + "\n");
		System.out.println(st);
	}
}