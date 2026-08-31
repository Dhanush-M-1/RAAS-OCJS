import java.io.BufferedReader;
import java.io.Reader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Denis Nedelyaev
 */
public class Main {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA(in, out);
		solver.solve(1);
		out.close();
	}
}

class TaskA {
    private final FastScanner in;
    private final PrintWriter out;

    public TaskA(FastScanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public void solve(int testNumber) throws IOException {
        int n = in.nextInt();
        String s = in.next();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int c = 0;
                for (int k = i; k < n; k += j) {
                    if (s.charAt(k) == '*') {
                        c++;
                        if (c == 5) {
                            out.println("yes");
                            return;
                        }
                    } else {
                        c = 0;
                    }
                }
            }
        }
        out.println("no");
    }
}

class FastScanner {
    private BufferedReader br;
    private String line = "";
    private int pos;

    public FastScanner(InputStream is) {
        this(new BufferedReader(new InputStreamReader(is)));
    }

    public FastScanner(Reader reader) {
        br = new BufferedReader(reader);
    }

    public String next() throws IOException {
        if (!goToNextToken()) {
            return null;
        }
        return readString();
    }

    public int nextInt() throws IOException {
        if (!goToNextToken()) {
            return 0;
        }
        return readInt();
    }

    private boolean goToNextToken() throws IOException {
        if (br == null) {
            return false;
        }

        while (pos == line.length()) {
            line = br.readLine();

            if (line == null) {
                br = null;
                return true;
            }

            pos = 0;

            skipWhitespace();
        }

        return true;
    }

    private String readString() {
        int start = pos;

        while (pos < line.length()) {
            char c = line.charAt(pos);

            if (c == ' ' || c == '\t') {
                break;
            }

            pos++;
        }

        String result = line.substring(start, pos);

        skipWhitespace();

        return result;
    }

    private int readInt() {
        int result = 0;

        int sign = 1;
        if (line.charAt(pos) == '-') {
            sign = -1;

            pos++;
        }

        while (pos < line.length()) {
            char c = line.charAt(pos);

            if (c == ' ' || c == '\t') {
                break;
            }

            pos++;

            result *= 10;
            result += c - '0';
        }

        skipWhitespace();

        return sign * result;
    }

    private void skipWhitespace() {
        while (pos < line.length()) {
            char c = line.charAt(pos);

            if (c != ' ' && c != '\t') {
                break;
            }

            pos++;
        }
    }
}

