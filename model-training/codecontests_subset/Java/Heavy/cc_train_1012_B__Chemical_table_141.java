import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class code0 {
    private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private static InputReader in;
    private static PrintWriter out;
    //////////////////////////////////////////////////////////
    private static int min(int... a){int min=a[0]; for(int i:a) min=Math.min(min, i); return min;}
    private static int max(int... a){int max=a[0]; for(int i:a) max=Math.max(max, i); return max;}
    private static long min(long... a){long min=a[0]; for(long i:a)min=Math.min(min, i); return min;}
    private static long max(long... a){long max=a[0]; for(long i:a)max=Math.max(max, i); return max;}
    private static String strm(String str, long m) {
        String ans = "";
        while(m > 0) {
            if ((m&1) == 1) ans = ans.concat(str);
            str = str.concat(str); m >>= 1;
        } return ans;
    }
    private static long mod(long a, long mod) {long res = a%mod; return res>=0 ? res : res+mod;}
    private static int mod(int a, int mod) {int res = a%mod; return res>=0 ? res : res+mod;}
    private static long modpow(long x, long n, long mod) {
        x = mod(x, mod);
        long res = 1;
        while (n > 0) {
            if ((n&1) == 1) res = mod(res*x, mod);
            x = mod(x*x, mod);
            n >>= 1;
        } return res;
    }
    private static long gcd(long a, long b) {return b == 0 ? Math.abs(a) : gcd(b, a % b);}
    private static int gcd(int a, int b) {return b == 0 ? Math.abs(a) : gcd(b, a % b);}
    private static long gcd(long... a) {long gcd=a[0]; for(long x:a) gcd=gcd(gcd, x); return gcd;}
    private static int gcd(int... a) {int gcd=a[0]; for(int x:a) gcd=gcd(gcd, x); return gcd;}
    private static long lcm(long a, long b) {return Math.abs(a / gcd(a, b) * b);}
    private static boolean isEven(int num) {return ((num&1) == 0);}
    private static boolean isOdd(int num) {return !isEven(num);}
    private static boolean isEven(long num) {return ((num&1) == 0);}
    private static boolean isOdd(long num) {return !isEven(num);}
    private static class Pair<T> {
        public T x, y;
        public Pair(T x, T y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Pair)) return false;
            Pair<T> pair = (Pair<T>)obj;
            return this.x == pair.x && this.y == pair.y;
        }
        @Override
        public String toString() {
            return ("(" + this.x + "," + this.y + ")");
        }
        @Override
        public int hashCode() {
            return (this.x+" "+this.y).hashCode();
        }
    }
    private static class Triplet<T> {
        public T x, y, z;
        public Triplet(T x, T y, T z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Triplet)) return false;
            Triplet<T> triplet = (Triplet<T>)obj;
            return this.x == triplet.x && this.y == triplet.y && this.z == triplet.z;
        }
        @Override
        public String toString() {
            return ("(" + this.x + "," + this.y + "," + this.z + ")");
        }
        @Override
        public int hashCode() {
            return (this.x+" "+this.y+" "+this.z).hashCode();
        }
    }
    //////////////////////////////////////////////////////////
    private static final int mod = 1_000_000_007;
    static class Node {
        Node parent;
        int rank, data, setSize;
    }
    static class DisjointSet {
        private HashMap<Integer, Node> hm = new HashMap<>();
        private int numOfSets = 0;
        private void makeSet(int data) {
            Node node = new Node();
            node.parent = node;
            node.rank = 0;
            node.data = data;
            node.setSize = 1;
            hm.put(data, node);
            numOfSets++;
        }
        private boolean union(int data1, int data2) {
            Node parent1 = findSet(hm.get(data1)), parent2 = findSet(hm.get(data2));
            if (parent1.data == parent2.data) return false;
            if (parent1.rank >= parent2.rank) {
                parent1.rank = parent1.rank == parent2.rank ? parent1.rank+1 : parent1.rank;
                parent2.parent = parent1;
                parent1.setSize += parent2.setSize;
            } else {
                parent1.parent = parent2;
                parent2.setSize += parent1.setSize;
            }
            numOfSets--;
            return true;
        }
        private boolean isPresent(int data) {return hm.containsKey(data);}
        private Node findSet(Node node) {
            if (node.parent.data == node.data) return node;
            return node.parent = findSet(node.parent);
        }
    }
    private void solve() throws Exception {
        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i=0; i<n; i++) edges[i] = new ArrayList<>();
        for (int i=0; i<q; i++) {
            int r = in.nextInt()-1, c = in.nextInt()-1;
            edges[r].add(c);
        }
        int ans = 0;
        DisjointSet ds = new DisjointSet();
        for (int i=0; i<m; i++) ds.makeSet(i);
        for (int i=0; i<n; i++) {
            if (edges[i].size() == 0) ans++;
            for (int j=1; j<edges[i].size(); j++) ds.union(edges[i].get(j-1), edges[i].get(j));
        }
        ans += ds.numOfSets - 1;
        out.printf("%d\n", ans);
    }
    private void run() throws Exception {
//        in = new InputReader();
//        in = new InputReader(new FileInputStream("input.txt"));
//        out = new PrintWriter(new FileWriter("output.txt"));
        in = oj ? new InputReader() : new InputReader(new FileInputStream("/home/raiden/Desktop/input.txt"));
        out = new PrintWriter(System.out, false);
//        out = new PrintWriter(new FileWriter("/home/raiden/Desktop/output.txt"), false);
        long ti = System.currentTimeMillis();
        solve(); out.flush();
        if (!oj) System.out.println("\n"+(System.currentTimeMillis()-ti)+"ms");
    }
    public static void main(String[] args) throws Exception {new code0().run();}
    //////////////////////////////////////////////////////////
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, numChars;
        private InputReader() {
            this.stream = System.in;
        }
        private InputReader(FileInputStream file) {
            this.stream = file;
        }
        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        private int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = (res<<3) + (res<<1) + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        private long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = (res<<3) + (res<<1) + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        private String nextLine() {
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
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}