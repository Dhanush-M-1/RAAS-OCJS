import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author PM
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    class AlgoZZ {
        public int[] solve(char[] s) {
            int n = s.length;
            int[] z = new int[n];
            int L = 0, R = 0;
            for (int i = 1; i < n; i++) {
                if (i > R) {
                    L = R = i;
                    while (R < n && s[R-L] == s[R]) R++;
                    z[i] = R-L; R--;
                } else {
                    int k = i-L;
                    if (z[k] < R-i+1) z[i] = z[k];
                    else {
                        L = i;
                        while (R < n && s[R-L] == s[R]) R++;
                        z[i] = R-L; R--;
                    }
                }
            }
            return z;
        }
        public boolean[] findOccurances(String S, String T) {
            StringBuilder sb = new StringBuilder(T);
            sb.append("#");
            sb.append(S);
            String SS = sb.toString();
            int[] z = solve(SS.toCharArray());
            boolean[] res = new boolean[S.length()];
            for (int at = T.length(); at < SS.length(); at++) {
                if (z[at]==T.length()) res[at - T.length()] = true;
            }
            return res;
        }
    }

    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String apo = in.next();
        String best = "";
        int bestcnt = -1;
        for (int y = 2013; y < 2016; y++) {
            for (int m = 1; m < 13; m++) {
                for (int d = 1; d <= days[m - 1]; d++) {
                    StringBuilder sb = new StringBuilder();
                    if (d < 10) sb.append('0');
                    sb.append(d + "-");
                    if (m < 10) sb.append('0');
                    sb.append(m + "-");
                    sb.append(Integer.toString(y));
boolean[] occ = new AlgoZZ().findOccurances(apo,sb.toString());
                    int cnt = 0;
                    for (int i = 0; i < occ.length; i++) if (occ[i]) ++cnt;
                    if (cnt>bestcnt) {
                        bestcnt = cnt;
                        best = sb.toString();
                    }
                }
            }
        }
        out.println(best);
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 8192);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

}

