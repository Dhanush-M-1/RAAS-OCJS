import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vadim Semenov
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

    static final class TaskB {
        public void solve(int __, InputReader in, PrintWriter out) {
            int counter = in.nextInt();
            int median = in.nextInt();
            int[] array = in.nextIntArray(counter);
            ArrayUtils.sort(array);
            long answer = 0;
            for (int i = 0; i < counter; ++i) {
                if (i + i <= counter - 1) {
                    answer += Math.max(0, array[i] - median);
                }
                if (i + i >= counter - 1) {
                    answer += Math.max(0, median - array[i]);
                }
            }
            out.println(answer);
        }

    }

    static class ArrayUtils {
        private static final Random RANDOM = ThreadLocalRandom.current();

        private ArrayUtils() {
        }

        public static void shuffle(int[] array) {
            for (int i = 1; i < array.length; ++i) {
                int j = RANDOM.nextInt(i + 1);
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        public static void sort(int[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextInt();
            }
            return array;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

