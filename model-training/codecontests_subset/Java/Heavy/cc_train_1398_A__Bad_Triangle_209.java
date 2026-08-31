import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) {

		FastScanner fs = new FastScanner();

		int t = fs.nextInt();

		while (t-- > 0) {
			
			int n = fs.nextInt();
			int[] nums = fs.readIntArray(n);
			
			int ab = nums[0] + nums[1];
			
			boolean flag = false;
			int i = 2;
			for(i=2;i<n;i++) {
				if(ab <= nums[i]) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				System.out.println(1 + " " + 2 + " " + (i+1));
			} else {
				System.out.println("-1");
			}
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		int[] readIntArray(int n) {
			int[] temp = new int[n];

			for (int i = 0; i < n; i++) {
				temp[i] = nextInt();
			}

			return temp;
		}

		char[] readCharArray(int n) {
			char[] temp = new char[n];

			for (int i = 0; i < n; i++) {
				temp[i] = next().charAt(0);
			}

			return temp;
		}
	}
}
