import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collections;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nguyen Trung Hieu - vuondenthanhcong11@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int count = in.readInt();
        int dayCount = in.readInt();
        int[] weight = IOUtils.readIntArray(in, count);
        int[] bookIdx = IOUtils.readIntArray(in, dayCount);
        MiscUtils.decreaseByOne(bookIdx);

        int[] idx = new int[count];
        int cur = 0;
        boolean[] visited = new boolean[count];
        for (int i = 0; i < dayCount; i++) {
            if (!visited[bookIdx[i]]) {
                idx[cur++] = bookIdx[i];
                visited[bookIdx[i]] = true;
            }
        }

        for (int i = 0; i < count; i++) {
            if (!visited[i]) {
                idx[cur++] = i;
            }
        }

        int[] saveIdx = Arrays.copyOf(idx,count);
        long answer1 = 0;
        for (int x : bookIdx) {
            cur = 0;
            while (x != idx[cur]) {
                answer1 += weight[idx[cur]];
                cur++;
            }

            for (int i = cur; i > 0; i--) {
                idx[i] = idx[i - 1];
            }
            idx[0] = x;
        }

        idx = Arrays.copyOf(saveIdx, count);

        int temp = idx[0];
        idx[0] = idx[1];
        idx[1] = temp;

        long answer2 = 0;
        for (int x : bookIdx) {
            cur = 0;
            while (x != idx[cur]) {
                answer2 += weight[idx[cur]];
                cur++;
            }

            for (int i = cur; i > 0; i--) {
                idx[i] = idx[i - 1];
            }
            idx[0] = x;
        }

//        out.printLine(answer1);
//        out.printLine(saveIdx);

        out.printLine(Math.min(answer1, answer2));
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

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

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}

class IOUtils {

    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }

}

class MiscUtils {

    public static void decreaseByOne(int[]...arrays) {
        for (int[] array : arrays) {
            for (int i = 0; i < array.length; i++)
                array[i]--;
        }
    }

}
