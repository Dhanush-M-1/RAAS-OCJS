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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int goLeftCnt = 0;  //includes standing
        int goRighCnt = 0;
        int standCnt = 0;
        int prevx = Integer.MIN_VALUE;
        int prevh = 0;
        for (int i = 0; i < n; i++) {
//            System.out.println(goLeftCnt + " | " + standCnt + " | " + goRighCnt);
            int x = in.nextInt();
            int h = in.nextInt();
            ///////////////////
            int nStandCnt = Math.max(standCnt,goLeftCnt);
            if (prevx + prevh < x) nStandCnt = Math.max(nStandCnt,goRighCnt);

            int nGoLeftCnt = 0;
            if (prevx < x-h) nGoLeftCnt = Math.max(standCnt,goLeftCnt)+1;
            if (prevx + prevh < x - h) nGoLeftCnt = Math.max(nGoLeftCnt, goRighCnt + 1);

            int nGoRightCnt = nStandCnt+1;

            prevx = x;
            prevh = h;
            goLeftCnt = nGoLeftCnt;
            goRighCnt = nGoRightCnt;
            standCnt = nStandCnt;
        }
        int res = Math.max(standCnt, Math.max(goLeftCnt, goRighCnt));
        out.println(res);
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

