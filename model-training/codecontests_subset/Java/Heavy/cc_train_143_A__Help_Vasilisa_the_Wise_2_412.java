import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;






public class A {



	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();

		int x = (d1 + c1 - r2) / 2;
		int a = r1 - x;
		int b = c1 - x;
		int c = r2 - c1 + x;

		if (x < 10 && a < 10 && b < 10 && c < 10 && x > 0 && a > 0 && b > 0 && c > 0 && x!=a && x != c && x != b && a != b && a != c && b!=c  && (a + x) == r1 && (b + c) == r2 && (x + b) == c1 && (a + c) == c2 && (x + c) == d1 && (a + b) == d2) {
			out.println(x + " " + a);
			out.println(b + " " + c);
		}

		else
			out.println(-1);

		out.close();
	}





// public static euclidTriplet euclidExtended(int a, int b) {
// 	if (b == 0)
// 		return new euclidTriplet(1, 0, a);

// 	euclidTriplet ans = euclidExtended(b, a % b);

// 	return new euclidTriplet(ans.y, ans.x - (a / b) * ans.y, ans.gcd);
// }


// public static int  gcd(int a, int b) {
// 	if (a == 0)
// 		return b;

// 	return gcd(b % a, a);
// }

}

// class euclidTriplet {
// 	int x, y, gcd;
// 	euclidTriplet(int x, int y, int gcd) {
// 		this.x = x;
// 		this.y = y;
// 		this.gcd = gcd;
// 	}
// }


// class comp implements Comparator<long []> {
// 	public int compare(long [] arr1, long[] arr2) {
// 		if ((2 * arr2[0] + arr2[1]) > (2 * arr1[0] + arr1[1]))
// 			return 1;

// 		else
// 			return -1;
// 	}
// }


class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	int [] nextIntArray(int n) {
		int [] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();

		return arr;

	}


	long nextLong() {
		return Long.parseLong(next());
	}

	long [] nextLongArray(int n) {
		long [] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextLong();

		return arr;

	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}