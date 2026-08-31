import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Date: 23.06.13 at 15:29
 *
 * @author Nickolay Polyarniy aka PolarNick
 */
public class ProblemA {

    public void solve() throws Exception {
        String s = nextWord();
        StringTokenizer tok = new StringTokenizer(s, "+");
        int[] count = new int[4];
        int sum = 0;
        while (tok.hasMoreTokens()) {
            count[Integer.parseInt(tok.nextToken())]++;
            sum++;
        }
        int[] res = new int[sum];
        int next = 0;
        while (next < sum) {
            for (int i = 1; i < 4; i++) {
                while (count[i] > 0) {
                    count[i]--;
                    res[next] = i;
                    next++;
                }
            }
        }
        for (int i = 0; i < sum - 1; i++) {
            out.print(res[i] + "+");
        }
        out.print(res[sum - 1]);

    }

    public static void main(String[] args) throws Exception {
        ProblemA problem = new ProblemA();
        problem.solve();
        problem.close();
    }

    BufferedReader in;
    PrintWriter out;
    String curLine;
    StringTokenizer tok;
    final String delimeter = " ";
    final String endOfFile = "";

    public ProblemA(BufferedReader in, PrintWriter out) throws Exception {
        this.in = in;
        this.out = out;
        curLine = in.readLine();
        if (curLine == null || curLine == endOfFile) {
            tok = null;
        } else {
            tok = new StringTokenizer(curLine, delimeter);
        }
    }

    public ProblemA() throws Exception {
        this(new BufferedReader(new InputStreamReader(System.in)),
                new PrintWriter(System.out));
    }

    public ProblemA(String filename) throws Exception {
        this(new BufferedReader(new FileReader(filename + ".in")),
                new PrintWriter(filename + ".out"));
    }

    public boolean hasMore() throws Exception {
        if (tok == null || curLine == null) {
            return false;
        } else {
            while (!tok.hasMoreTokens()) {
                curLine = in.readLine();
                if (curLine == null || curLine.equalsIgnoreCase(endOfFile)) {
                    tok = null;
                    return false;
                } else {
                    tok = new StringTokenizer(curLine);
                }
            }
            return true;
        }
    }

    public String nextWord() throws Exception {
        if (!hasMore()) {
            return null;
        } else {
            return tok.nextToken();
        }
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextWord());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextWord());
    }

    public int[] readIntArray(int n) throws Exception {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public void close() throws Exception {
        in.close();
        out.close();
    }

}
