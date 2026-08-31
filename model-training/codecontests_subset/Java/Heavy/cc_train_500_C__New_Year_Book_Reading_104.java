import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author George Marcus
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
        int N = in.nextInt();
        int M = in.nextInt();
        int[] W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = in.nextInt();
        }
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = in.nextInt();
            B[i]--;
        }

        int[] pos = new int[N];
        Arrays.fill(pos, M);
        for (int i = 0; i < M; i++) {
            int b = B[i];
            if (pos[b] == M) {
                pos[b] = i;
            }
        }

        Book[] books = new Book[N];
        for (int i = 0; i < N; i++) {
            books[i] = new Book(pos[i], i);
        }
        Arrays.sort(books);

        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = books[i].idx;
        }

        long ans = 0;
        for (int i = 0; i < M; i++) {
            int b = B[i];
            int p = -1;
            long sum = 0;
            for (int j = 0; j < N && p == -1; j++) {
                if (C[j] == b) {
                    p = j;
                }
                else {
                    sum += W[C[j]];
                }
            }
            ans += sum;
            for (int j = p - 1; j >= 0; j--) {
                C[j + 1] = C[j];
            }
            C[0] = b;
        }

        out.println(ans);
    }

    private class Book implements Comparable<Book> {
        public int pos;
        public int idx;

        private Book(int pos, int idx) {
            this.pos = pos;
            this.idx = idx;
        }

        public int compareTo(Book o) {
            if (pos != o.pos) {
                return pos - o.pos;
            }
            return idx - o.idx;
        }
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
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public String nextString() {
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

