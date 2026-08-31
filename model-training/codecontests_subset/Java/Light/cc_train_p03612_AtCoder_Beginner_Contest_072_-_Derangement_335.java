import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		final Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}

		int a = 0;
		if (p[N - 1] == N) {
			a++;
			int t = p[N - 1];
			p[N - 1] = p[N - 2];
			p[N - 2] = t;
		}

		for (int i = 0; i < N - 1; i++) {
			if (p[i] == i + 1) {
				int t = p[i + 1];
				p[i + 1] = p[i];
				p[i] = t;
				a++;
			}
		}

		System.out.println(a);
	}
}
