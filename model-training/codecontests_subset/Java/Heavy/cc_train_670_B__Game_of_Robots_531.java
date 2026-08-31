import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class robots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
		}
		long sum = 1;
		ArrayList<Long> num = new ArrayList<Long>();
		while(sum*(sum+1)/2 <= 2e9) {
			num.add((long)(sum*(sum+1)/2));
			sum++;
		}
		num.add((long)(sum*(sum+1)/2));
		int l = 0;
		int r = num.size() - 1;
		long ans = -1;
		int index = -1;
		while(l <= r) {
			int mid = l + (r-l)/2;
			if(num.get(mid) >= k) {
				ans = num.get(mid);
				index = mid;
				r = mid - 1;
			}else {
				l = mid + 1;
			}
		}
//		System.out.println(ans + " " + index);
		long start1 = ans - index;
		System.out.println(a[(int) (k - start1)]);
		
	}

	private static class Scanner {
		public BufferedReader reader;
		public StringTokenizer st;

		public Scanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				} catch (Exception e) {
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
