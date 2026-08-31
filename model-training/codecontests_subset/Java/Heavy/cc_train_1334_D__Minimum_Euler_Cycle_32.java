//package CodeforcesJava;

import java.io.*;
import java.util.*;

public class Main {

    public void solve(InputProvider in, PrintWriter out) throws IOException {
        int testCount = in.nextInt();
        for (int test = 0; test < testCount; test++) {
            long pointCount = in.nextLong();
            long firstIndex = in.nextLong();
            long lastIndex = in.nextLong();
            long firstGroup = 2 * (pointCount - 1);
            boolean needLast = lastIndex == countElements(firstGroup, pointCount - 1) + 1;
            if (firstIndex < pointCount * (pointCount - 1) + 1) {
                if (needLast) {
                    lastIndex--;
                }
                long minGuess = 0;
                long maxGuess = pointCount - 1;
                while (maxGuess > minGuess + 1) {
                    long middleGuess = (maxGuess + minGuess) / 2;
                    long middleGuessCount = countElements(firstGroup, middleGuess);
                    if (firstIndex <= middleGuessCount) {
                        maxGuess = middleGuess;
                    } else {
                        minGuess = middleGuess;
                    }
                }
                while (countElements(firstGroup, minGuess + 1) < firstIndex) {
                    minGuess++;
                }
                long distance = firstIndex - countElements(firstGroup, minGuess);
                long levelPoint = minGuess + 1;
                long point;
                long pairPoint;
                if ((distance & 1) == 1) {
                    point = levelPoint;
                    pairPoint = (distance + 1) / 2 + levelPoint;
                } else {
                    point = distance / 2 + levelPoint;
                    out.print(point + " ");
                    firstIndex++;
                    if (point == pointCount) {
                        point = levelPoint + 1;
                        pairPoint = point + 1;
                    } else {
                        pairPoint = point + 1;
                        point = levelPoint;
                    }
                }
                boolean printMain = true;
                for (long i = firstIndex; i <= lastIndex; i++) {
                    if (printMain) {
                        out.print(point + " ");
                        printMain = false;
                    } else {
                        out.print(pairPoint + " ");
                        printMain = true;
                        if (pairPoint < pointCount) {
                            pairPoint++;
                        } else {
                            point++;
                            pairPoint = point + 1;
                        }
                    }
                }
            }
            if (needLast) {
                out.print("1 ");
            }
            out.print("\n");
        }
    }

    private long countElements(long first, long count) {
        return (2 * first - 2 * (count - 1)) * count / 2;
    }

    public static void main(String[] args) throws Exception {
        try (InputProvider input = new InputProvider(System.in);
             PrintWriter output = new PrintWriter(System.out)) {
            new Main().solve(input, output);
        }
    }

    public static class InputProvider implements AutoCloseable {

        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputProvider(Reader reader) {
            this.reader = new BufferedReader(reader);
        }

        public InputProvider(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public String next() throws IOException {
            if (Objects.isNull(tokenizer) || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        @Override
        public void close() throws Exception {
            reader.close();
        }

    }

}