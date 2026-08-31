import java.io.*;
import java.util.*;

public class Woodcutters {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] h = new int[n];
            List<Interval> intervals = new ArrayList<Interval>();
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                h[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i == 0 || (x[i - 1] < x[i] - h[i])) {
                    intervals.add(new Interval(x[i] - h[i], x[i]));
                }
                if (i == n - 1 || (x[i + 1] > x[i] + h[i])) {
                    intervals.add(new Interval(x[i], x[i] + h[i]));
                }
            }

            Collections.sort(intervals, new SortByF());
            int count = 0;
            int last_ft = 0;
            boolean first_interval = true;
            for(Interval interval:intervals) {
                if(first_interval) {
                    last_ft = interval.t;
                    count ++;
                    first_interval = false;

                }
                if(interval.s > last_ft) {
                    last_ft = interval.t;
                    count ++;
                }
            }
            out.println(count);
        }
    }

    public static class Interval {
        int s, t;
        Interval(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
    public static class SortByF implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.t - b.t;
        }
    }
    static class InputReader {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}