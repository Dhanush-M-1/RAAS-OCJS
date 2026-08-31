import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int [][] mat = new int[n][n];
		for (int i = 0; i < mat.length; ++i) {
			char [] c = sc.next().toCharArray();
			for (int j = 0; j < c.length; ++j) {
				int tmp = c[j] <= '9'?c[j]-'0':c[j]-'A'+10;
				for (int j2 = 3; j2 >= 0; --j2) {
					mat[i][j*4+j2] = tmp % 2;
					tmp /= 2;
				}
			}
		}
		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat.length; ++j) {
				if(i > 0)
					mat[i][j] += mat[i-1][j];
				if(j > 0)
					mat[i][j] += mat[i][j-1];
				if(i > 0 && j > 0)
					mat[i][j] -= mat[i-1][j-1];
			}
		}
//		for(int []i:mat)
//			System.out.println(Arrays.toString(i));
		int max = 0;
		for (int f = 1; f*f <= mat.length; ++f) {
			if(n % f != 0) continue;
			if(can(mat, f))
				max = Math.max(max, f);
			if(can(mat, n/f))
				max = Math.max(max, n/f);
		}
		out.println(max);
		out.close();
	}
	static boolean can(int [][] mat, int x){
		int i = x-1, j = x-1;
		while(i < mat.length){
			int sum = mat[i][j];
			if(i-x >= 0)
				sum -= mat[i-x][j];
			if(j-x >= 0)
				sum -= mat[i][j-x];
			if(i-x >= 0 && j-x >= 0)
				sum += mat[i-x][j-x];
			if(sum != 0 && sum != x*x)
				return false;
			if(j == mat.length-1){
				i += x;
				j = x-1;
			}
			else j += x;
		}
		return true;
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
