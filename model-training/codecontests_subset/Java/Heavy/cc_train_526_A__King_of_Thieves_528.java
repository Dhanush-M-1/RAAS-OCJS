import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static boolean isContest = true;
    //region shit

    BufferedReader in;
    PrintWriter out;
    StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        Main sol = new Main();
        if (sol.isContest) {
            sol.in = new BufferedReader(new InputStreamReader(System.in));
            sol.out = new PrintWriter(System.out);
        } else {
            sol.in = new BufferedReader(new FileReader("input.txt"));
            sol.out = new PrintWriter("output.txt");
        }
        sol.solve();
        sol.in.close();
        sol.out.close();
    }

    private int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    private String nextToken() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(in.readLine());
        }
        return stringTokenizer.nextToken();
    }
    //endregion


    private void solve() throws Exception {
        int n = nextInt();
        char[] c = nextToken().toCharArray();
        out.println(isValid(c) ? "yes" : "no");
    }

    private boolean isValid(char[] c) {
        int n = c.length;
        loopStart:
        for (int start = 0; start < n; start++) {
            if (c[start] == '.') {
                continue loopStart;
            }

            loopJump:
            for (int jump = 1; jump < n; jump++) {
                if (start + 4 * jump > n - 1) {
                    break loopJump;
                }
                for (int i = 0; i < 5; i++) {
                    if (c[start + i * jump] == '.') continue loopJump;
                }
                return true;
            }
        }
        return false;
    }

}