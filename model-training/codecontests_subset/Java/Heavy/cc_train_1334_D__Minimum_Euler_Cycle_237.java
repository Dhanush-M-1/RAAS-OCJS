import java.io.*;
import java.util.*;

public class eulercycc {


    /**
     * @return Index of rightmost number <=key. Inclusive
     */
    private static int bsUpperBound(int n, long key) {
        // Modified Arrays.binarySearch
        int low = 0;
        int high = n;
        long N2 = n*2;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = ((N2 - 1 - mid)*mid);
            long cmp = midVal - key;
            if (cmp < 0) {
                low = mid + 1;
            }
            else if (cmp > 0) {
                high = mid - 1;
            }
            else {
                return mid; // key found
            }
        }
        return high+1;  // key not found, returns number after
    }
    public static void main(String[] args) throws Exception {
        R in = new R();
        int TESTCASES = in.nextInt();
        StringBuilder out = new StringBuilder();
        for (int TC = 0; TC < TESTCASES; TC++) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();
            long p = bsUpperBound(n, l);

            for (long i = l; i <= r; i++) {
                // n-1 inside the partition

                if (i > ((n*2 - 1 - p)*p) ) {
                    p++;
                }
                if (i == (long)n * (n-1) + 1) {
                    out.append("1\n");

                } else if ((i&1)!=0) {
                    // even
                    out.append(p).append(' ');

                } else {
                    long thing = n*2  - p;
                    thing *= (p-1) ;
                    out.append((i - thing) / 2 + p).append(' ');
                }
            }
            out.setCharAt(out.length()-1, '\n');
        }
        System.out.print(out);
        System.out.flush();
    }
    //<editor-fold desc="R">

    /**
     * This class is for fast input. Please ignore.
     */
    public static class R {
        private BufferedReader br;
        /**
         * Should be set to null at end of line
         */
        private StringTokenizer st;

        public R() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public R(String filename) throws IOException {
            br = new BufferedReader(new FileReader(filename + ".in"));
        }

        public R(BufferedReader reader) {
            br = reader;
        }

        public BufferedReader getReader() {
            return br;
        }

        public StringTokenizer getStringTokenizer() {
            return st;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
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

        /**
         * Note:
         * CAN MODIFY the BufferedReader's location and the string tokenizer!!!
         * Recommended to only use with next().
         */
        public boolean lineHasNext() throws IOException {
            if (st == null) {
                String s = br.readLine();
                if (s == null) return false;
                st = new StringTokenizer(s);
            }
            return st.hasMoreTokens();
        }

        /**
         * Note:
         * CAN MODIFY the BufferedReader's location and the string tokenizer!!!
         * Recommended to only use with next().
         */
        public boolean hasNext() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        /**
         * Skips a line. Sets st to null if has tokens left, and otherwise
         * reads a line.
         */
        public void skipLine() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                br.readLine(); // Otherwise, would do nothing.
            }
            st = null;
        }

        /**
         * This will set st to null, and this ignores current line
         */
        public String[] nextLine() throws IOException {
            String s = br.readLine();
            if (s == null) return null;
            st = new StringTokenizer(s);
            ArrayList<String> result = new ArrayList<>();
            while (st.hasMoreTokens()) {
                result.add(st.nextToken());
            }
            st = null;
            return result.toArray(new String[0]);
        }

        /**
         * sets st to null!
         */
        public String[] nextTower(int lines) throws IOException {
            String[] tower = new String[lines];
            st = null;
            for (int i = 0; i < lines; i++) {
                tower[i] = br.readLine();
            }
            return tower;
        }

        public int[] nextIntLine() throws IOException {
            return intArr(nextLine());
        }

        public long[] nextLongLine() throws IOException {
            return longArr(nextLine());
        }

        public int[] nextIntTower(int lines) throws IOException {
            return intArr(nextTower(lines));
        }

        public long[] nextLongTower(int lines) throws IOException {
            return longArr(nextTower(lines));
        }

        public int[] intArr(String[] strings) throws IOException {
            int[] ints = new int[strings.length];
            int i = 0;
            for (String s : strings) {
                ints[i] = Integer.parseInt(s);
                i++;
            }
            return ints;
        }

        public long[] longArr(String[] strings) throws IOException {
            long[] longs = new long[strings.length];
            int i = 0;
            for (String s : strings) {
                longs[i] = Long.parseLong(s);
                i++;
            }
            return longs;
        }

        public double[] doubleArr(String[] strings) {
            double[] doubles = new double[strings.length];
            int i = 0;
            for (String s : strings) {
                doubles[i] = Double.parseDouble(s);
                i++;
            }
            return doubles;
        }

        /**
         * This will set st to null
         */
        public char[] nextCharArray() throws IOException {
            st = null;
            String s = br.readLine();
            return s == null ? null : s.toCharArray();
        }

        /**
         * This will set st to null
         * Boolean at pos i true if char at pos i == c
         */
        public boolean[] nextBoolArray(char c) throws IOException {
            char[] chars = nextCharArray();
            if (chars == null) return null;
            boolean[] booleans = new boolean[chars.length];
            for (int i = 0; i < chars.length; i++) {
                booleans[i] = chars[i] == c;
            }
            return booleans;
        }

        public int[][] next2Dint(int lines) throws IOException {
            int[][] result = new int[lines][];
            for (int i = 0; i < lines; i++) {
                result[i] = nextIntLine();
            }
            return result;
        }

        public long[][] next2Dlong(int lines) throws IOException {
            long[][] result = new long[lines][];
            for (int i = 0; i < lines; i++) {
                result[i] = nextLongLine();
            }
            return result;
        }

        public char[][] next2Dchar(int lines) throws IOException {
            char[][] result = new char[lines][];
            for (int i = 0; i < lines; i++) {
                result[i] = nextCharArray();
            }
            return result;
        }

        public boolean[][] next2Dbool(int lines, char c) throws IOException {
            boolean[][] result = new boolean[lines][];
            for (int i = 0; i < lines; i++) {
                result[i] = nextBoolArray(c);
            }
            return result;
        }
    }
    //</editor-fold>
}