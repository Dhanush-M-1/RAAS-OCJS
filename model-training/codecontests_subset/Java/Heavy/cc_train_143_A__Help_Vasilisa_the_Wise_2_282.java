/*import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		PrintWriter pr = new PrintWriter(System.out, true);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Scanner s = new Scanner(System.in);
		// StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(in.readLine());
		if (n == 1) {
			pr.println("17 17");
			return;
		}
		ArrayList<Integer> list = func(n);
		if (list.size() < 2) {
			list.add(1);
		}
		long aMin = list.get(0);
		long bMin = list.get(1);
		long resMin = n * 2 + 9 + n * 6;
		long resMax = n * 2 + 9 + n * 6;
		pr.println(resMin + " " + resMax);
		// n*2+9+n*6
	}

	public static ArrayList<Integer> func(int n) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				set.add(i);
				set.add(n/i);
			}
		}
		
		return list;
	}
}*/
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		PrintWriter pr = new PrintWriter(System.out, true);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Scanner s = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					for (int m = 1; m <= 9; m++) {
						if ((i == j) || (i == k) || (i == m) || (j == k)
								|| (j == m) || (k == m))
							continue;
						if (i + j == r1 && k + m == r2 && i + k == c1
								&& m + j == c2 && i + m == d1 && k + j == d2) {
							pr.println(i + " " + j);
							pr.println(k + " " + m);
							return;
						}
					}
				}
			}
		}
		pr.println("-1");
	}
}
