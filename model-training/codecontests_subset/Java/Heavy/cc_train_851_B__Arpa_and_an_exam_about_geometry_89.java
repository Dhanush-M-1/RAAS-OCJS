import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;
import static java.lang.Long.max;
import static java.lang.Long.min;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.StrictMath.abs;
import static java.lang.System.err;
import static java.lang.System.exit;
import static java.util.Arrays.sort;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class A {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    static long dist(int x1, int y1, int x2, int y2) {
        return ( 1L * (x1 - x2) * (x1 - x2) + 1L * (y1 - y2) * (y1 - y2) );
    }

    static void solve() throws Exception {
        int p1x = nextInt(), p1y = nextInt(), p2x = nextInt(), p2y = nextInt(), p3x = nextInt(), p3y = nextInt();
        long det =  1L * (p1x - p2x) * (p2y - p3y) - 1L * (p2x - p3x)* (p1y - p2y);
        if (det == 0 || dist(p1x,p1y,p2x,p2y) != dist(p3x,p3y,p2x,p2y)) out.println("No");
        else out.println("Yes");
    }


    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public static int lower_bound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low] == target ? low : -1;
    }

    public static int upper_bound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high + 1 - low) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid;
        }
        return nums[low] == target ? low : -1;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static char nextChar() throws IOException {
        return next().toCharArray()[0];
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            long lEndTime = System.currentTimeMillis();
            //System.out.println("Elapsed time in seconds: " + (double)(lEndTime - lStartTime) / 1000.0);
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}