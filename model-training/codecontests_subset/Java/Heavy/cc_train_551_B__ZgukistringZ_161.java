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
    private int[] letterCount(String c) {
        int[] res = new int[26];
        for (int i = 0; i < c.length(); i++) {
            res[c.charAt(i)-'a']++;
        }
        return res;
    }
    private boolean subtract(int[] target, int[] what, int cnt) {
        boolean isOK = true;
        for (int i = 0; i < target.length; i++) {
            target[i] -= what[i] * cnt;
            if (target[i]<0) isOK=false;
        }
        return isOK;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a, b, c;
        a=in.next(); b=in.next(); c=in.next();
        if (b.length()<c.length()) {
            String t = c;
            c = b;
            b = t;
        }
        int[] have = letterCount(a);
        int[] bb = letterCount(b);
        int[] cc = letterCount(c);
        int best = 0, bestnb = 0, bestnc = 0;
        for (int nb = 0; nb < a.length(); nb++) {
            int[] nhave = have.clone();
            if (subtract(nhave,bb,nb)==true) {
                int nc = 1000000;
                for (int i = 0; i < 26; i++) {
                    if (cc[i]!=0) nc = Math.min(nc, nhave[i] / cc[i]);
                }
                if (nc==1000000) continue;
                if (nc+nb>best) {
                    best = nc+nb;
                    bestnb = nb;
                    bestnc = nc;

                }
            } else break;
        }
        StringBuilder answerer = new StringBuilder();
        for (int i = 0; i < bestnb; i++) answerer.append(b);
        for (int i = 0; i < bestnc; i++) answerer.append(c);
        int[] nhave = have.clone();
        subtract(nhave, bb, bestnb);
        subtract(nhave, cc, bestnc);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < nhave[i]; j++) {
                answerer.append((char)('a' + i));
            }
        }
        out.println(answerer.toString());

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

