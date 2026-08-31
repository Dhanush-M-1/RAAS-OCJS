import java.io.*;
import java.util.*;

/**
 * A simple template for competitive programming problems.
 */
public class Banana {
    //final InputReader in = new InputReader("input.txt");
    final InputReader in = new InputReader(System.in);

    final PrintWriter out = new PrintWriter(System.out);

    final int mod = 1000000007;
    boolean DEBUG = false;
    void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        UnionFind uf = new UnionFind(m+1);
        boolean[] good = new boolean[n];
        for(int i=0; i<n; i++) {
            int k = in.nextInt();
            int u = in.nextInt()-1;
            int v = k==1 ? m : in.nextInt()-1;
            if(!uf.connected(u, v)) {
                good[i] = true;
                uf.union(u, v);
            }
        }
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(good[i]) {
                ans <<= 1;
                ans %= mod;
                list.add(i+1);
            }
        }

        out.println(ans + " " + list.size());
        for(int l : list) {
            out.print(l + " ");
        }
        out.println();
    }

    public class UnionFind {
        private final int[] component;
        private final int[] size;
        private int componentCount;
    
        /**
         * Initially each object is only connected to itself.
         */
        public UnionFind(int numObjects) {
            component = new int[numObjects];
            size = new int[numObjects];
            componentCount = numObjects;
            for (int i = 0; i < numObjects; i++) {
                component[i] = i;
                size[i] = 1;
            }
        }
    
        /**
         * Returns the component ID of the object.
         */
        public int find(int p) {
            if (p < 0 || p >= component.length) throw new IllegalArgumentException("Illegal object ID.");
            int root = p;
            while (component[root] != root)
                root = component[root];
            while (root != component[p]) {
                int next = component[p];
                component[p] = root;
                p = next;
            }
            return root;
        }
    
        /**
         * Merges the components of the objects.
         */
        public void union(int p, int q) {
            if (p < 0 || p >= component.length) throw new IllegalArgumentException("Illegal object ID.");
            if (q < 0 || q >= component.length) throw new IllegalArgumentException("Illegal object ID.");
            p = find(p);
            q = find(q);
            if (p == q) return;
            componentCount--;
            if (size[p] < size[q]) {
                component[p] = q;
                size[q] += size[p];
            } else {
                component[q] = p;
                size[p] += size[q];
            }
        }
    
        /**
         * Returns true if the objects are in the same component, false otherwise.
         */
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    
        /**
         * Returns the size of the component p belong to.
         */
        public int componentSize(int p) {
            return size[find(p)];
        }
    
        /**
         * Returns the number of components.
         */
        public int count() {
            return componentCount;
        }
    }

    public static void main(String[] args) throws FileNotFoundException { Banana s = new Banana(); long t1 = System.currentTimeMillis(); s.solve(); System.err.println(System.currentTimeMillis()-t1 + " ms"); s.out.close(); }

    public Banana() throws FileNotFoundException { }

    private static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader(InputStream stream) {
            this.stream = stream;
        }

        InputReader(String fileName) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.stream = stream;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[] nextRandomArray(int n, int lim) {
            int[] arr = new int[n];
            Random r = new Random();
            for(int i=0; i<n; i++) {
                arr[i] = r.nextInt(lim);
            }
            return arr;
        }

        int[] nextRandomArray(int n) {
            int[] arr = new int[n];
            Random r = new Random();
            for(int i=0; i<n; i++) {
                arr[i] = r.nextInt();
            }
            return arr;
        }

        int[] nextRandomArray(int n, int low, int lim) {
            int[] arr = new int[n];
            Random r = new Random();
            for(int i=0; i<n; i++) {
                arr[i] = low+r.nextInt(lim-low+1);
            }
            return arr;
        }

        int[][] nextMatrix(int n, int m) {
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = nextInt();
            return matrix;
        }

        String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double nextDouble() {
            return Double.parseDouble(nextString());
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try { numChars = stream.read(buf); }
                catch (IOException e) { throw new InputMismatchException(); }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        private boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }

        private boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; }
    }


}