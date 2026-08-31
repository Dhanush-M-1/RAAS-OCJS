import java.util.*;
import java.io.*;

public class ReadingBooksSorting {
	static int n, k;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		n = sc.nextInt();
		k = sc.nextInt();
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		ArrayList<Integer> both = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == 1 && b == 1)
				both.add(t);
			else if (a == 1)
				aa.add(t);
			else if (b == 1)
				bb.add(t);

		}
		Collections.sort(aa);
		Collections.sort(bb);
		Collections.sort(both);
		int remA = k;
		int remB = k;
		int total = 0;
		int iA = 0;
		int iB = 0;
		int iboth = 0;
//		pw.println(aa.size() + " " + bb.size());
		while (remA > 0 && remB > 0 && iA < aa.size() && iB < bb.size() && iboth < both.size()) {
			int a1 = aa.get(iA);
			int b1 = bb.get(iB);
			int bb1 = both.get(iboth);
			if (a1 + b1 < bb1) {
				total += (a1 + b1);
				remA--;
				remB--;
				iA++;
				iB++;
			} else {
				total += bb1;
				remA--;
				remB--;
				iboth++;
			}
		}

		if (remA > 0 || remB > 0) {
			if (iA == aa.size() && iB == bb.size()) {
				while (iboth < both.size() && (remA > 0 || remB > 0)) {
					total += both.get(iboth);
					remA--;
					remB--;
					iboth++;
				}
			} else {
				if (iboth == both.size()) {
					while (iA < aa.size() && remA > 0) {
						total += aa.get(iA);
						remA--;
						iA++;
					}
					while (iB < bb.size() && remB > 0) {
						total += bb.get(iB);
						remB--;
						iB++;
					}
				}

				while (remA>0  && iA < aa.size() && iboth < both.size()) {
					int both1 = both.get(iboth);
					int a1 = aa.get(iA);
					if (remA > 0 && remB > 0 || both1 < a1) {
						total += both1;
						remB--;
						remA--;
						iboth++;
					} else if (remA > 0) {
						total += a1;
						remA--;

						iA++;
					}
				}

				while (remB>0 &&iB < bb.size() && iboth < both.size()) {
					int both1 = both.get(iboth);
					int b1 = bb.get(iB);
					if (remB > 0 && remA > 0 || both1 < b1) {
						total += both1;
						remB--;
						remA--;
						iboth++;
					} else if (remB > 0) {
						total += b1;
						remB--;

						iB++;
					}
				}
			}

		}
		if (remA > 0 || remB > 0)
			pw.println(-1);
		else {
			pw.println(total);
		}
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}
	}
}