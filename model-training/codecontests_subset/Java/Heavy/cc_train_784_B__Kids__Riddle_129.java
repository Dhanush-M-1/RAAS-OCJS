
import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class CF {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String ch = Integer.toHexString(n).toUpperCase();
        int s = 0;
        for (int i = 0; i < ch.length(); i++) {
            switch (ch.charAt(i)) {
                case '0':
                case '4':
                case '6':
                case '9':
                case 'A':
                case 'D':
                    s++;
                    break;
                case '8':
                case 'B':
                    s += 2;
                    break;
                default:
                    break;
            }
        }
        out.println(s);
        out.close();
    }

    public static int maxTab(int[] tab) {
        int max = 0;
        for (int i : tab) {
            max = max(i, max);
        }
        return max;
    }

    static class FastScanner {

        private BufferedReader in;
        private String[] line;
        private int index;
        private int size;

        public FastScanner(InputStream in) throws IOException {
            this.in = new BufferedReader(new InputStreamReader(in));
            init();
        }

        public FastScanner(String file) throws FileNotFoundException {
            this.in = new BufferedReader(new FileReader(file));
        }

        private void init() throws IOException {
            line = in.readLine().split(" ");
            index = 0;
            size = line.length;
        }

        public int nextInt() throws IOException {
            if (index == size) {
                init();
            }
            return Integer.parseInt(line[index++]);
        }

        public long nextLong() throws IOException {
            if (index == size) {
                init();
            }
            return Long.parseLong(line[index++]);
        }

        public float nextFloat() throws IOException {
            if (index == size) {
                init();
            }
            return Float.parseFloat(line[index++]);
        }

        public double nextDouble() throws IOException {
            if (index == size) {
                init();
            }
            return Double.parseDouble(line[index++]);
        }

        public String next() throws IOException {
            if (index == size) {
                init();
            }
            return line[index++];
        }

        public String nextLine() throws IOException {
            if (index == size) {
                init();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < size; i++) {
                sb.append(line[i]).append(" ");
            }
            return sb.toString();
        }

        private int[] nextIntArray(int n) throws IOException {
            int[] tab = new int[n];
            for (int i = 0; i < tab.length; i++) {
                tab[i] = nextInt();
            }
            return tab;
        }

        private double[] nextDoubleArray(int n) throws IOException {
            double[] tab = new double[n];
            for (int i = 0; i < tab.length; i++) {
                tab[i] = nextDouble();
            }
            return tab;
        }

    }

}
