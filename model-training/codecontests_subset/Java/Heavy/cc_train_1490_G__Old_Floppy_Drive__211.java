import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;


/*
 * @author: Ramanqul
 * */
public class Main {
    private static boolean USE_TEST_CASES = true;
    private static final double EPS = .000000001;

    private static int findLower(long arr[], long x) {
        int l = -1, r = arr.length;

        while (r > l+1) {
            int mid = (l+r)/2;

            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

    private static int binarySearch(Integer arr[][], int arrIdx, int key) {
        int l = 0, r = arr.length-1;

        while (l<=r) {
            int m = (l+r)/2;
            if (arr[m][arrIdx] < key) {
                l = m + 1;
            } else if (arr[m][arrIdx] > key) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    private static int findUpper(int arr[], int x) {
        int l = -1, r = arr.length;

        while (r > l+1) {
            int mid = (l+r)/2;

            if (arr[mid] < x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }

    private static void solve(final int testCase, MyScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n];
        int q[] = new int[m];
        H.readArray(in, a, n);
        H.readArray(in, q, m);

        TreeMap<Long, Integer> prefixMap = new TreeMap<>();
        long maxSum = a[0], prefixSum = a[0];
        prefixMap.put(maxSum, 0);

        for (int i=1;i<n;i++) {
            prefixSum += a[i];
            if (prefixSum > maxSum) {
                prefixMap.put(prefixSum, i);
                maxSum = prefixSum;
            }
        }

        for (long x: q) {
            if (x <= prefixMap.lastKey()) {
                out.print(prefixMap.ceilingEntry(x).getValue() + " ");
                continue;
            }

            if (prefixSum <= 0) {
                out.print("-1 ");
                continue;
            }

            long amount = x - prefixMap.lastKey();
            long loops = (amount + prefixSum-1) / prefixSum;
            long totalTime = loops * n + prefixMap.ceilingEntry(x - prefixSum*loops).getValue();

            out.print(totalTime + " ");
        }

        out.println();
    }

    private static void generateInput(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)));

        writer.println(1);
        final int n = 200_000;
        Random rnd = new Random();
        writer.println(n);

        for (int i=0;i<n;i++) {
            writer.print(rnd.nextInt(1+100));
            writer.print(" ");
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
//        String fileName = "sample.in";

//        generateInput(fileName);

        MyScanner sc = new MyScanner();//new BufferedInputStream(new FileInputStream(fileName)));

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = 1;

        if (USE_TEST_CASES) {
            t = sc.nextInt();
        }

        for (int i=0;i<t;i++) {
            solve(i, sc, out);
        }

        out.close();
    }

    private static class Pair<A,B> {
        public A first;
        public B second;
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<A,B,C> {
        public A first;
        public B second;
        public C third;

        public Triple(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static class H {
        public static void readArray(MyScanner in, int a[], int n) {
            for (int i=0;i<n;i++) {
                a[i] = in.nextInt();
            }
        }

        public static boolean isUnique(int ... nums) {
            Set<Integer> s = new HashSet<>();
            for (int i:nums) {
                if (s.contains(i)) {
                    return false;
                }
                s.add(i);
            }

            return true;
        }


        public static Pair<Integer, Integer>[] readIntPairs(MyScanner in, int n) {
            Pair[] pairs = new Pair[n];
            for (int i=0;i<n;i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                pairs[i] = new Pair<Integer, Integer>(x, y);
            }

            return pairs;
        }

        public static List<Integer> dfs(int start, List<Integer>[] adj) {
            boolean v[] = new boolean[adj.length+1];

            List<Integer> res = new ArrayList<>();

            Stack<Integer> st = new Stack<>();

            st.push(start);

            while (!st.isEmpty()) {
                int x = st.pop();
                if (!v[x]) {
                    res.add(x);
                    boolean allVisited = true;
                    for (int e: adj[x]) {
                        if (!v[e]) {
                            st.push(e);
                            allVisited = false;
                        }
                    }

                    if (allVisited) {
                        break;
                    }

                    v[x] = true;
                } else {
                    break;
                }
            }

            return res;
        }

        public static long gcd(long a, long b) {
            if (a == 0) {
                return b;
            }

            return gcd(b%a, a);
        }

        public static long lcm(long a, long b) {
            return (a * b) / gcd(a,b);
        }
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}