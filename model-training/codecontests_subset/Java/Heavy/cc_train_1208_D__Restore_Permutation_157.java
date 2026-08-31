import java.io.*;
import java.util.*;

public class Codeforces1208D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[] s = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s[i] = Long.parseLong(st.nextToken());
		}
		
		int[] p = new int[n];
		//sum[0][i-1] is i if i is there, 0 otherwise
		//god i need to make the sums long fml
		long[][] sum = new long[19][];
		for (int i = 0; i <= 18; i++) {
			sum[i] = new long[1 + ((n-1)>>i)];
		}
		for (int i = 0; i < n; i++) {
			sum[0][i] = (long) (i+1);
		}
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j <= (n-1)>>i; j++) {
				sum[i][j] = sum[i-1][2*j];
				if (2*j+1 <= (n-1)>>(i-1)) {
					sum[i][j] += sum[i-1][2*j+1];
				}
			}
		}
		
		for (int i = n-1; i >= 0; i--) {
			//find p[i] first
			//let t be array sum[0] shifted by 1
			//want smallest j such that p[1]+p[2]+...+p[j] > s[i]
			long SUM = sum[18][0];
			int j = 0;
			for (int k = 17; k >= 0; k--) {
				j = 2*j+1;
				if (((n-1)>>k) < j) {
					j--;
				}
				else if (SUM - sum[k][j] > s[i]) {
					SUM -= sum[k][j];
					j--;
				}
			}
			p[i] = j+1;
			
			//decrement
			sum[0][j] -= (j+1);
			for (int k = 1; k <= 18; k++) {
				sum[k][j>>k] -= (j+1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			pw.print(p[i] + " ");
		}
		
		pw.close();
	}
}