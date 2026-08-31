import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zyflair Griffane
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		PandaScanner in = new PandaScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		H solver = new H();
		solver.solve(1, in, out);
		out.close();
	}
}

class H {
    public void solve(int testNumber, PandaScanner in, PrintWriter out) {
        int n = in.nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                res.append(Integer.toString(i * j, n) + "  ");
            }
            res.setLength(res.length() - 1);
            res.append("\n");
        }
        Pattern regex = Pattern.compile(" (\\d\\d)");
        Matcher regexMatcher = regex.matcher(res.toString());
        String str = regexMatcher.replaceAll("$1");
        out.println(str);
    }
}

class PandaScanner {
    public BufferedReader br;
    public StringTokenizer st;
    public InputStream in;

    public PandaScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(this.in = in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    public String next() {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
            return next();
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    }

