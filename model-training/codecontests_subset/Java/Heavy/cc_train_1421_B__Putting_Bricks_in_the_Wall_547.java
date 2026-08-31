
import java.io.*;
import java.util.*;

public class B {
    static FastReader reader = new FastReader();
    //static OutputWriter out = new OutputWriter(System.out);

    static void solve(char[][] arr) {
        int n = arr.length - 1;
        int up = Character.getNumericValue(arr[n-1][n]);
        int left = Character.getNumericValue(arr[n][n-1]);
        int g1 = Character.getNumericValue(arr[n][n-2]);
        int g2 = Character.getNumericValue(arr[n-1][n-1]);
        int g3 = Character.getNumericValue(arr[n-2][n]);


        List<int[]> res = new LinkedList<>();
        if(g1 == g2 && g2 == g3) {
            if(up == g1) {
                res.add(new int[] {n -1 + 1, n + 1});
            }
            if(left == g1) {
                res.add(new int[] {n + 1, n -1 + 1});
            }
        } else if(left == up) {
            if(g1 == left) {
                res.add(new int[] {n+1, n-2+1});
            }
            if(g2 == left) {
                res.add(new int[] {n-1 + 1, n-1 + 1});
            }
            if(g3 == left) {
                res.add(new int[] {n - 2 + 1, n + 1});
            }
        } else if(g1 + g2 + g3 == 2) {
            if(g1 == 0) {
                res.add(new int[] {n+1, n-2+1});
            }
            if(g2 == 0) {
                res.add(new int[] {n-1 + 1, n-1 + 1});
            }
            if(g3 == 0) {
                res.add(new int[] {n - 2 + 1, n + 1});
            }
            if(up == 1) {
                res.add(new int[] {n-1 + 1, n + 1});//[n-1][n]
            }
            if(left == 1) {
                res.add(new int[] {n + 1, n -1 + 1});//[n][n-1]
            }
        } else {
            if(g1 == 1) {
                res.add(new int[] {n+1, n-2+1});
            }
            if(g2 == 1) {
                res.add(new int[] {n-1 + 1, n-1 + 1});
            }
            if(g3 == 1) {
                res.add(new int[] {n - 2 + 1, n + 1});
            }
            if(up == 0) {
                res.add(new int[] {n-1 + 1, n + 1});//[n-1][n]
            }
            if(left == 0) {
                res.add(new int[] {n + 1, n -1 + 1});//[n][n-1]
            }
        }
        System.out.println(res.size());
        for(int[] a : res) {
            System.out.println(a[0] + " " + a[1]);
        }
    }

    public static void main(String[] args) {
        int tests = reader.nextInt();
        for(int test = 1; test <= tests; test++) {
            int n = reader.nextInt();
            char[][] arr = new char[n][n];
            for(int i = 0; i < n; i++) {
                arr[i] = reader.next().toCharArray();
            }
            solve(arr);
        }
    }

    static final Random random = new Random();

    static void shuffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(char[] array) {
            writer.print(array);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(double[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void println(double[] array) {
            print(array);
            writer.println();
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void print(char i) {
            writer.print(i);
        }

        public void println(char i) {
            writer.println(i);
        }

        public void println(char[] array) {
            writer.println(array);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

        public void print(long i) {
            writer.print(i);
        }

        public void println(long i) {
            writer.println(i);
        }

        public void print(int i) {
            writer.print(i);
        }

        public void println(int i) {
            writer.println(i);
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }
    }
}
