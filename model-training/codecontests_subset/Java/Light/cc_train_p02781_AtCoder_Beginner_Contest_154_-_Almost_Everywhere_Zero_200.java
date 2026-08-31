//--- pE ---//
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws java.lang.Exception {
		new Solution();
	}
}


class Solution {
	Scanner scanner;



	public Solution() {
		scanner = new Scanner(System.in);

		// scanner.nextLine();
		while (scanner.hasNext()) {
			run_case();
		}
	}


	private void run_case() {
		// scanner.nextLine();
		String line = scanner.nextLine();
		// int N = Integer.parseInt(line);
		char[] num = line.toCharArray();
		line = scanner.nextLine();
		int K = Integer.parseInt(line);
		this.K = K;

		long res = countInRange(num);

		this.K = K-1;
		long res2 = countInRange(num);

		System.out.println(res - res2);
		return;
	}

	List<Integer> num;
	int K;
	int M = 101;
	long[][][] dp;
	private long countInRangeUtil(int pos, int cnt, int tight ) {
	    if (pos == num.size()) {
	        // If count of non zero digits
	        // is less than or equal to K
	        if (cnt <= K)
	            return 1;
	        return 0;
	    }

	    // If this result is already computed
	    // simply return it
	    if (dp[pos][cnt][tight] != -1)
	        return dp[pos][cnt][tight];

	    int ans = 0;

	    // Maximum limit upto which we can place
	    // digit. If tight is 1, means number has
	    // already become smaller so we can place
	    // any digit, otherwise num[pos]
	    int limit = (tight!=0 ? 9 : num.get(pos));

	    for (int dig = 0; dig <= limit; dig++) {
	        int currCnt = cnt;

	        // If the current digit is nonzero
	        // increment currCnt
	        if (dig != 0)
	            currCnt++;

	        int currTight = tight;

	        // At this position, number becomes
	        // smaller
	        if (dig < num.get(pos))
	            currTight = 1;

	        // Next recursive call
	        ans += countInRangeUtil(pos + 1, currCnt, currTight);
	    }
	    return dp[pos][cnt][tight] = ans;
	}

	private long countInRange (char[] x) {
	    num = new ArrayList<Integer>();
		int sz = x.length;
		for (int i=sz-1; i>=0; i--) {
			num.add(x[i] - '0');
		}
	    // while (x!=0) {
	    //     num.add(x % 10);
	    //     x /= 10;
	    // }
	    Collections.reverse(num);

	    // Initialize dp
		dp = new long[M][M][2];
	    for(int i=0;i<M;i++)
	        for(int j=0;j<M;j++)
	            for(int k=0;k<2;k++)
	            	dp[i][j][k]=-1;
	    return countInRangeUtil(0, 0, 0);
	}


	private int[] strToIntArray(String str) {
	    String[] vals = str.split("\\s+");
	    int sz = vals.length;
	    int[] res = new int[sz];
	    for (int i=0; i<sz; i++) {
	        res[i] = Integer.parseInt(vals[i]);
	    }
	    return res;
	}
}
