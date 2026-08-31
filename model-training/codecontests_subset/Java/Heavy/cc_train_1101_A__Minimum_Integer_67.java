
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)  {
        __SolutionBase begin = new __SolutionBase();
        begin.Solve();
    }
}
class __SolutionBase {

    public void Solve() {
        init();
        Solution();
        out.close();
    }

    private void Solution() {
        List<Long> answer = new ArrayList<>();
        int n = readInt();
        for (int i = 0; i < n;i++){
            long L = readLong();
            long r = readLong();
            long d = readLong();
            /*
            long ans = 1;
            stop:
            {
                if (L % d == 0) {
                    ans = L - d;
                    if (ans <= 0)
                        break stop;
                    while (ans > 0) {
                        ans -= d;
                    }
                    ans += d;
                }else ans = (long)(L/d) * d;
            }
            if (ans > 0)
                answer.add(ans);
            else answer.add((long)(r/d)*(long)d + d);
            */
            if (d < L)
                answer.add(d);
            else{
                long a = r/d;
                answer.add(a*d + d);
            }
        }
        for (long elem:answer)
            out.println(elem);
    }

    /**
     * readLong, readDouble and other are similar
     *
     * @return int type from input
     */
    private int readInt() {
        return Integer.parseInt(readString());
    }

    private long readLong() {
        return Long.parseLong(readString());
    }
    /**
     * Tokens are separated by space or endExclusive of line
     *
     * @return non-empty string token from input (or null if there is no any token)
     */
    private String readString() {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (null == nextLine) return null;
            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken();
    }

    /**
     * @return whole line from input
     */
    private String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok = new StringTokenizer(" ");

    /**
     * For local testing I use pair 'input.txt'/'output.txt' in the project root
     */
    private void init() {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }
}