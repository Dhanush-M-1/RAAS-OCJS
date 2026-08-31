
import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class CF {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String ch = in.next();
        String cd = "";
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            String c = ch.substring(i, i+2);
            String cc = ch;
            int s = 0;
            while(cc.contains(c)){
                cc = cc.substring(0, cc.indexOf(c))+"."+cc.substring(cc.indexOf(c)+1);
                s++;
            }
            if (s>max){
                cd = c;
                max = s;
            }
        }
        out.println(cd);
        out.close();
    }

    public static int upper_bound(int[] tab, int l, int h, long x) {
        while (l < h) {
            int mid = (l + h) / 2;
            if (tab[mid] <= x) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
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
            for (; index < size; index++) {
                sb.append(line[index]).append(" ");
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

        private long[] nextLongArray(int n) throws IOException {
            long[] tab = new long[n];
            for (int i = 0; i < tab.length; i++) {
                tab[i] = nextLong();
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
