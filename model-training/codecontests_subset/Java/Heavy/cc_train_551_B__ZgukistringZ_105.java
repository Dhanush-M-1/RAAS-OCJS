import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
    final int Inf = 0x3f3f3f3f;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] A = in.next().toCharArray();
        char[] B = in.next().toCharArray();
        char[] C = in.next().toCharArray();

        int[] cntA = new int[26], cntB = new int[26], cntC = new int[26];
        for (char p: A) cntA[p - 'a']++;
        for (char p: B) cntB[p - 'a']++;
        for (char p: C) cntC[p - 'a']++;

        int ans = 0, ans1 = 0, ans2 = 0;
        for (int i = 0; ; ++i) {
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                cntA[j] -= cntB[j] * i;
                if (cntA[j] < 0) ok = false;
            }
            int nans = Inf;
            for (int j = 0; j < 26; ++j)
                if (cntC[j] != 0)
                    nans = Math.min(nans, cntA[j] / cntC[j]);

            if (ok) {
                if (ans < nans + i) {
                    ans = nans + i;
                    ans1 = i;
                    ans2 = nans;
                }
            }

            for (int j = 0; j < 26; ++j) {
                cntA[j] += cntB[j] * i;
                if (cntA[j] < 0) ok = false;
            }

            if (!ok) break;
        }
        String Bs = new String(B), Cs = new String(C);

        StringBuffer S = new StringBuffer();
        for (int i = 0; i < ans1; ++i)
            S.append(Bs);
        for (int i = 0; i < ans2; ++i)
            S.append(Cs);
        for (int i = 0; i < 26; ++i) {
            int x = cntA[i] - cntB[i] * ans1 - cntC[i] * ans2;
            for (int j = 0; j < x; ++j)
                S.append((char) (i + 'a'));
        }
        
        out.println(S.toString());
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new UnknownError();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new UnknownError();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));

        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}

