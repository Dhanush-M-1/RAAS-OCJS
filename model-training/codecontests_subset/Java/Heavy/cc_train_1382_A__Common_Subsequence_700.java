import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n = fs.nextInt();
			int m = fs.nextInt();

			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			ArrayList<Integer> res = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				a.add(fs.nextInt());
			}

			for (int i = 0; i < m; i++) {
				b.add(fs.nextInt());
			}

			if (a.size() > b.size()) {
				ArrayList<Integer> c = a;
				a = b;
				b = c;

				int nn = n;
				n = m ;
				m = nn;
			}

			boolean tr = false;

			for (int i = 0; i < n; i++) {
				if (b.contains(a.get(i))) {
					System.out.println("YES");
					System.out.println("1 " + a.get(i));
					tr = true;
					break;
				}
			}
			if (!tr) {
				System.out.println("NO");
			}
		}
	}

	static double cntOfPermutations(double n ) {
		return  Math.floor(n * (n + 1) / 2);
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}


}
