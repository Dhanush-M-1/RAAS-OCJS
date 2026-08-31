import java.io.*;
import java.util.*;
public class jmain {

	/**
	 * @param args
	 */

	static BufferedReader brscan = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner scan = new Scanner(System.in);

	static class Node {
		int id;
		public Node(int id) {
			this.id = id;

		}
	}



	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n = scan.nextInt();
		int x = scan.nextInt();
		int[] parents = new int[n+1];
		boolean[] is_last = new boolean[n+1];
		Arrays.fill(is_last, true);
		for (int ii=1; ii<=n; ii++ ) {
			int now = scan.nextInt();
			parents[ii] = now;
			is_last[now] = false;
		}
		ArrayList<Integer> comb = new ArrayList<Integer>(n);
		int beaver = -1;
		for (int ii=1; ii<=n; ii++) {
			
			if (is_last[ii]) {

				int count_el = 1;
				boolean has_beaver =false;
				
				int idx_n = parents[ii];
				if (ii==x) {
					has_beaver = true;
				}
				while (idx_n != 0) {
					count_el += 1;
					if (idx_n == x) {
						beaver = count_el;
						has_beaver = true;
					}
					idx_n = parents[idx_n];
				}
				if (has_beaver) {
					if (ii==x) {
						has_beaver = true;
						beaver = count_el;
					} else {
						beaver = count_el - beaver + 1;
					} 
				}
				else {
					comb.add(count_el);
				}
			}
		}
		// combination //
		Collections.sort(comb);
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for (Integer ii : comb) {
			for (int idx_n = n-ii; idx_n >=0 ; idx_n--) {
				if (dp[idx_n]==true) {
					dp[idx_n + ii] = true;
				}
			}
		}
		for (int ii=0; ii<=n; ii++) {
			if (dp[ii]) {
				pw.println(ii+beaver);
			}
		}
		pw.close();

	}

}