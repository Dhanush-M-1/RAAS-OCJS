import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Arthur Petukhovsky petuhovskiy@yandex.ru
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        static boolean inversed = false;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            List<CompResult> list = new ArrayList<>();
            if (x <= 1D && y <= 1D && z <= 1D) inversed = true;
            list.add(new CompResult("x^y^z", pow(x, y, z)));
            list.add(new CompResult("x^z^y", pow(x, z, y)));
            list.add(new CompResult("(x^y)^z", pow(x, y * z)));
            list.add(new CompResult("(x^z)^y", pow(x, y * z)));
            list.add(new CompResult("y^x^z", pow(y, x, z)));
            list.add(new CompResult("y^z^x", pow(y, z, x)));
            list.add(new CompResult("(y^x)^z", pow(y, x * z)));
            list.add(new CompResult("(y^z)^x", pow(y, x * z)));
            list.add(new CompResult("z^x^y", pow(z, x, y)));
            list.add(new CompResult("z^y^x", pow(z, y, x)));
            list.add(new CompResult("(z^x)^y", pow(z, y * x)));
            list.add(new CompResult("(z^y)^x", pow(z, y * x)));
            System.err.println(list);
            Collections.sort(list);
            out.println(list.get(0).string);
        }

        double pow(double x, double y) {
            if (inversed) x = 1D / x;
            if (x <= 1D) return -100500D;
            return Math.log(Math.log(x)) + Math.log(y);
        }

        double pow(double x, double y, double z) {
            if (inversed) x = 1D / x;
            if (x <= 1D) return -100500D;
            return Math.log(y) * z + Math.log(Math.log(x));
        }

    }

    static class FastScanner {
        final static int BUFFER_SIZE = 65536;
        BufferedReader br;
        char[] buf = new char[BUFFER_SIZE];
        int len = 0;
        int it = 0;
        boolean end = false;

        boolean delim(char c) {
            return c == ' ' || c == '\n' || c == '\r';
        }

        void fillBuffer() {
            try {
                len = br.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void ensureBuffer() {
            if (it == len) {
                it = 0;
                fillBuffer();
                if (len == -1) end = true;
            }
        }

        void moveNext() {
            while (!end) {
                ensureBuffer();
                if (!delim(buf[it])) return;
                while (it < len && delim(buf[it])) it++;
            }
        }

        public String next() {
            moveNext();
            StringBuilder sb = new StringBuilder();
            while (!end) {
                int l = it;
                while (++it < len && !delim(buf[it])) ;
                sb.append(buf, l, it - l);
                ensureBuffer();
                if (delim(buf[it])) break;
            }
            return sb.toString();
        }

        public FastScanner(String file) {
            try {
                br = new BufferedReader(new FileReader(file), BUFFER_SIZE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is), BUFFER_SIZE);
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    static class CompResult implements Comparable<CompResult> {
        String string;
        double result;
        int num;
        static int count = 1;

        public CompResult(String string, double result) {
            this.string = string;
            this.result = result;
            this.num = count++;
        }


        public int compareTo(CompResult o) {
            if (Double.compare(result, o.result) != 0)
                return (TaskD.inversed ? 1 : -1) * Double.compare(result, o.result);
            return Integer.compare(num, o.num);
        }


        public String toString() {
            return "{" + String.valueOf(result) + "; " + string + "}";
        }

    }
}

