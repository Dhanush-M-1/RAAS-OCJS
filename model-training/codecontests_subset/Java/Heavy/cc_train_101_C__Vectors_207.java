import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AlexFetisov
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
        long x = in.nextLong();
        long y = in.nextLong();
        long rx = in.nextLong();
        long ry = in.nextLong();
        long addX = in.nextLong();
        long addY = in.nextLong();
        if (x == rx && y == ry) {
            out.println("YES");
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (ok(rx - x, ry - y, addX, addY)) {
                out.println("YES");
                return;
            }
            long t = rx;
            rx = -ry;
            ry = t;
        }

        out.println("NO");
    }

    boolean ok(long x1, long y1, long x2, long y2) {
        if (x2 == 0 && y2 == 0) return x1 == 0 && y1 == 0;
        long a1 = x2;
        long b1 = -y2;
        long c1 = x1;
        long a2 = y2;
        long b2 = x2;
        long c2 = y1;
        long z = a1 * b2 - a2 * b1;
        long dx = b1 * c2 - c1 * b2;
        long dy = c1 * a2 - a1 * c2;
        if (z == 0) {
            if (dx != 0 || dy != 0) {
                return false;
            }
            return c1 % IntegerUtils.gcd(Math.abs(a1), Math.abs(b1)) == 0;
        }
        return dx % z == 0 && dy % z == 0;

    }


}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer stt;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            return null;
        }
    }

    public String nextString() {
        while (stt == null || !stt.hasMoreTokens()) {
            stt = new StringTokenizer(nextLine());
        }
        return stt.nextToken();
    }

    public long nextLong() {
        return Long.parseLong(nextString());
    }

}

class IntegerUtils {

    public static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}

