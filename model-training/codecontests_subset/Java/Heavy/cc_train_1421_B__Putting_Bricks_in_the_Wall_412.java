import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author xwchen
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

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while (T-- > 0) {
                int n = in.nextInt();
                char[][] s = new char[n][n];
                for (int i = 0; i < n; ++i) {
                    s[i] = in.nextLine().toCharArray();
                }
                ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
                ArrayList<Pair<Integer, Integer>> inverts = new ArrayList<>();
                pairs.add(new Pair<>(0, 1));
                pairs.add(new Pair<>(1, 0));
                pairs.add(new Pair<>(n - 1, n - 2));
                pairs.add(new Pair<>(n - 2, n - 1));
                for (int k = 0; k < 2; ++k) {
                    int other = k ^ 1;
                    inverts.clear();
                    if (getType(pairs.get(0), s) != k) {
                        inverts.add(pairs.get(0));
                    }
                    if (getType(pairs.get(1), s) != k) {
                        inverts.add(pairs.get(1));
                    }
                    if (getType(pairs.get(2), s) != other) {
                        inverts.add(pairs.get(2));
                    }
                    if (getType(pairs.get(3), s) != other) {
                        inverts.add(pairs.get(3));
                    }
                    if (inverts.size() <= 2) {
                        break;
                    }
                }
                out.println(inverts.size());
                for (Pair<Integer, Integer> pair : inverts) {
                    out.println((pair.x + 1) + " " + (pair.y + 1));
                }
            }
        }

        int getType(Pair<Integer, Integer> pair, char[][] s) {
            return (s[pair.x][pair.y] == '0') ? 0 : 1;
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public InputReader(InputStream inputStream) {
            this.reader = new BufferedReader(
                    new InputStreamReader(inputStream));
        }

        public String next() {
            while (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            String ret = "";
            try {
                ret = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class Pair<K, V> implements Comparable<Pair> {
        public K x;
        public V y;

        public Pair(K x, V y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {

        }

        public int compareTo(Pair o) {
            if (compareNumber(x, o.x) != 0) {
                return compareNumber(x, o.x);
            } else {
                return compareNumber(y, o.y);
            }
        }

        private int compareNumber(Object o1, Object o2) {
            if (o1 instanceof Integer && o2 instanceof Integer) {
                return ((Integer) o1).compareTo((Integer) o2);
            } else if (o1 instanceof Long && o2 instanceof Long) {
                return ((Long) o1).compareTo((Long) o2);
            } else if (o1 instanceof Double && o2 instanceof Double) {
                return ((Double) o1).compareTo((Double) o2);
            } else {
                System.out.println("Unsupported Type");
                return 0;
            }
        }

    }
}

