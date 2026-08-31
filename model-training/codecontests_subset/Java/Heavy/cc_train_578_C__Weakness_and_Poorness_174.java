/**
 * @author derrick20
 */
import java.io.*;
import java.util.*;

public class WeaknessConvexHull {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        arr = sc.nextDoubles(N);
        ArrayList<Pair> lines = new ArrayList<>();
        /*
        Lines are stored as pairs with form (slope, intercept)
        poor_i(x) = b_i - x * i, where x is the indep var
         */
        double sum = 0;
        lines.add(new Pair(0, 0));
        for (int i = 1; i <= N; i++) {
            sum += arr[i - 1];
            Pair line = new Pair(-i, sum);
            lines.add(line);
        }
        /*
        Convex hull sweep through all the lines:

        We want to process the lines in reverse order for the upper hull
        (since steeper things will be at the start of the hull)
        On the other hand, flatter things will appear first in the lower ull
         */
        LinkedList<Pair> upperHull = new LinkedList<>();
        LinkedList<Pair> lowerHull = new LinkedList<>();

        convexHull(lowerHull, lines);
        Collections.reverse(lines);
        convexHull(upperHull, lines);
//        System.out.println(lowerHull);
//        System.out.println(upperHull);
        double ans = 1e18;
        Pair blank = new Pair(oo, oo);
        while (upperHull.size() >= 2 || lowerHull.size() >= 2) {
            Pair intLower = lowerHull.size() >= 2 ? intersection(lowerHull.getFirst(), lowerHull.get(1)) : blank;
            Pair intUpper = upperHull.size() >= 2 ? intersection(upperHull.getFirst(), upperHull.get(1)) : blank;
            if (intUpper.isBlank() || intLower.a < intUpper.a) {
                double hi = upperHull.getFirst().evalAt(intLower.a);
                double lo = intLower.b;
                double bestSeg = Math.max(hi - lo, Math.max(Math.abs(hi), Math.abs(lo)));
                ans = Math.min(ans, bestSeg);
                lowerHull.pollFirst();
            }
            else if (intLower.isBlank() || intUpper.a <= intLower.a) { // upper isn't zero and upper comes first, then we can use upper's intersection
                double hi = intUpper.b;
                double lo = lowerHull.getFirst().evalAt(intUpper.a);
                double bestSeg = Math.max(hi - lo, Math.max(Math.abs(hi), Math.abs(lo)));
                ans = Math.min(ans, bestSeg);
                upperHull.pollFirst();
            }
            else {
                System.out.println("Unaccounted for case!");
            }
        }
        if (!(upperHull.size() == 1) && (lowerHull.size() == 1)) {
            System.out.println("Didn't finish!");
        }
        out.println(ans);
        out.close();
    }

    static double[] arr;
    static double oo = 1e18;

    static void convexHull(LinkedList<Pair> hull, ArrayList<Pair> lines) {
        for (Pair next : lines) {
            while (hull.size() >= 2) {
                Pair curr = hull.getLast();
                Pair prev = hull.get(hull.size() - 2);
                if (intersection(next, prev).a <= intersection(curr, prev).a) {
                    hull.pollLast();
                }
                else {
                    break;
                }
            }
            hull.add(next);
        }
    }

    static Pair intersection(Pair p1, Pair p2) {
        double x = (p2.b - p1.b) / (p1.a - p2.a);
        double y = p1.a * x + p1.b;
        return new Pair(x, y);
    }

    static class Pair {
        double a, b;
        public Pair(double aa, double bb) {
            a = aa; b = bb;
        }
        public String toString() {
            return "(" + String.format("%.2f", a) + ", " + String.format("%.2f", b) + ")";
        }
        public double evalAt(double x) {
            return a * x + b;
        }
        public boolean isBlank() {
            return a == oo && b == oo;
        }
    }

    static class FastScanner {
        private int BS = 1<<16;
        private char NC = (char)0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            }
            catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar(){
            while(bId==size) {
                try {
                    size = in.read(buf);
                }catch(Exception e) {
                    return NC;
                }
                if(size==-1)return NC;
                bId=0;
            }
            return (char)buf[bId++];
        }

        public int nextInt() {
            return (int)nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt=1;
            boolean neg = false;
            if(c==NC)c=getChar();
            for(;(c<'0' || c>'9'); c = getChar()) {
                if(c=='-')neg=true;
            }
            long res = 0;
            for(; c>='0' && c <='9'; c=getChar()) {
                res = (res<<3)+(res<<1)+c-'0';
                cnt*=10;
            }
            return neg?-res:res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c!='.' ? cur:cur+nextLong()/cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c>32) {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c!='\n') {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if(c>32)return true;
            while(true) {
                c=getChar();
                if(c==NC)return false;
                else if(c>32)return true;
            }
        }
    }
}