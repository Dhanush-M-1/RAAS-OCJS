import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(in, out);
        out.close();
    }
}

class TaskE {

    private double tab[];

    private double tmp[];

    public void solve(InputReader in, OutputWriter out) {
        int n = in.nextInt();
        tab = new double[n];
        tmp = new double[n];
        double left = Integer.MAX_VALUE;
        double right = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            tab[i] = in.nextInt();
            left = Math.min(left, tab[i]);
            right = Math.max(right, tab[i]);
        }

        for(int i=0;i<40;i++) {
            double x = (left + right) / 2;
            if(check(x)) {
                right = x;
            } else {
                left = x;
            }
        }

        for(int i=0;i<n;i++) {
            tmp[i] = tab[i] - right;
        }
        out.printLine(getMax());
    }

    private boolean check(double x) {
        for (int i = 0; i < tab.length; i++) {
            tmp[i] = tab[i] - x;
        }
        double max = getMax();
        double min = getMin();

        return max < -min;
    }

    public double getMax() {
        double max = 0;
        double current = 0;
        for(int i=0;i<tmp.length;i++) {
            current += tmp[i];
            if(current < 0) current = 0;
            max = Math.max(max, current);
        }
        return max;
    }

    public double getMin() {
        double min = 0;
        double current = 0;
        for(int i=0;i<tmp.length;i++) {
            current += tmp[i];
            if(current > 0) current = 0;
            min = Math.min(min, current);
        }
        return min;
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

    public boolean hasNext() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }

}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}