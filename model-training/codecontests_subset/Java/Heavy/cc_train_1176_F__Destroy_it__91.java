import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	static ArrayList<Integer>[][] damage;
	static Long[][] memo;
	static int n;
	
	static long dp(int idx, int card) {
        if (idx == n) return 0;
        if (memo[idx][card] != null)
            return memo[idx][card];
        
        long ans = dp(idx + 1, card);
 
        //Single Card
        for (int k = 1; k <= 3; k++) {
            if (damage[idx][k].size() > 0) {
                long curAns = dp(idx + 1, (card + 1) % 10) + damage[idx][k].get(0);
                if (card == 9)
                    curAns += damage[idx][k].get(0);
                ans = Math.max(ans, curAns);
            }
        }
        
        //Two Ones
        if (damage[idx][1].size() > 1) {
            long curAns = dp(idx + 1, (card + 2) % 10) + damage[idx][1].get(0) + damage[idx][1].get(1);
            if (card >= 8)
                curAns += damage[idx][1].get(0);
            ans = Math.max(ans, curAns);
        }
        
        //One and Two
        if (damage[idx][1].size() > 0 && damage[idx][2].size() > 0) {
            long curAns = dp(idx + 1, (card + 2) % 10) + damage[idx][1].get(0) + damage[idx][2].get(0);
            if (card >= 8)
                curAns += Math.max(damage[idx][1].get(0), damage[idx][2].get(0));
            ans = Math.max(ans, curAns);
        }
        
        //Three Ones
        if (damage[idx][1].size() > 2) {
            long curAns = dp(idx + 1, (card + 3) % 10) + damage[idx][1].get(0) + damage[idx][1].get(1) + damage[idx][1].get(2);
            if (card >= 7)
                curAns += damage[idx][1].get(0);
            ans = Math.max(ans, curAns);
        }
 
        return memo[idx][card] = ans;
    }

	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		damage = new ArrayList[n][5];
		memo = new Long[n][10];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= 3; j++) {
				damage[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			while (k-- > 0) {
				int c = sc.nextInt();
				int d = sc.nextInt();
				damage[i][c].add(d);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= 3; j++) {
				Collections.sort(damage[i][j], (x, y) -> Integer.compare(y, x));
			}
		}

		out.println(dp(0, 0));
		out.close();
	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream system) {
		br = new BufferedReader(new InputStreamReader(system));
	}

	public Scanner(String file) throws Exception {
		br = new BufferedReader(new FileReader(file));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public Long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}