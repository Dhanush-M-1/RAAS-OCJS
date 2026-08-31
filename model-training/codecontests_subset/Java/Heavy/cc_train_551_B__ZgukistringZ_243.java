import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author K0T
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

    String a, b, c;
    int[] cntA, cntB, cntC;

    public void solve(int testNumber, InputReader scn, PrintWriter pw) {
        a = scn.next();
        b = scn.next();
        c = scn.next();
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        cntA = new int[30];
        cntB = new int[30];
        cntC = new int[30];
        Arrays.fill(cntA, 0);
        Arrays.fill(cntB, 0);
        Arrays.fill(cntC, 0);
        for (int i = 0; i < lenA; i++) {
            int code = (int)(a.charAt(i)) - (int)('a');
            cntA[code]++;
        }
        for (int i = 0; i < lenB; i++) {
            int code = (int)(b.charAt(i)) - (int)('a');
            cntB[code]++;
        }
        for (int i = 0; i < lenC; i++) {
            int code = (int)(c.charAt(i)) - (int)('a');
            cntC[code]++;
        }
        int result = 0;
        int resB = 0, resC = 0;
        for (int i = 0; i <= lenA; i++) {
            boolean can = true;
            int curAdd = 2_000_000_000;
            for (int j = 0;j < 26; j++) {
                if (cntC[j] == 0) {
                    continue;
                }
                curAdd = Math.min(curAdd, cntA[j] / cntC[j]);
            }
            if (i + curAdd > result) {
                result = i + curAdd;
                resB = i;
                resC = curAdd;
            }
            for (int j = 0; j < 26; j++) {
                if (cntA[j] - cntB[j] < 0) {
                    can = false;
                    break;
                }
                cntA[j] -= cntB[j];
            }
            if (can == false) {
                break;
            }
        }
        Arrays.fill(cntA, 0);
        for (int i = 0; i < lenA; i++) {
            int code = (int)(a.charAt(i)) - (int)('a');
            cntA[code]++;
        }
        for (int j = 0; j < 26; j++) {
            cntA[j] -= (resB * cntB[j]);
            cntA[j] -= (resC * cntC[j]);
        }
        for (int i = 0; i < resB; i++) {
            pw.print(b);
        }
        for (int i = 0; i < resC; i++) {
            pw.print(c);
        }
        for (int i = 0; i < 26; i++) {
            char symbol = (char)(i + (int)('a'));
            for (int j = 0; j < cntA[i]; j++) {
                pw.print(symbol);
            }
        }
        pw.println("");
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

}
