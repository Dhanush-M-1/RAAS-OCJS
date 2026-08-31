
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

    private void solve() throws IOException {
        try {
//            solveA();
//            solveB();
//            solveC();
//            solveD();
            solveE();
//            solveF();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }

    // mods
    long MOD = (long) Math.pow(10, 9) + 7;

    private void solveA() {
        int n = nextInt();
        String s = next();
        int x = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
            }
            res = Math.max(res, x);
        }
        out.println(res);
    }

    private void solveB() {
        int n = nextInt();
        int k = nextInt();
        int[] h = IntStream.range(0, n).map(i -> nextInt()).sorted().toArray();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - (k - 1); i++) {
            res = Math.min(res, h[i + k - 1] - h[i]);
        }
        out.println(res);
    }

    private void solveC() {
        String s = next();

        if (s.length() < 26) {
            //26未満なら、後ろに最小のcharを付け足して終わり
            int[] alp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (alp[c - 'a'] > 0) {
                    out.println(-1);
                    break;
                }
                alp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (alp[i] != 0)
                    continue;
                out.println(s + (char) (i + 'a'));
                return;
            }
        } else {
            //26なら、順番を組みかえるまたは不要なものを削除する
            int index = 0;
            /*
            後ろから、昇順が崩れるところを確認
            abcdefghijklmnopqrstuvwzyx
            であれば、
            abcdefghijklmnopqrstuvw
             */
            for (int i = s.length() - 1; i >= 1; i--) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i - 1);
                if (c2 < c1) {
                    index = i;
                    break;
                }
            }
            //既に辞書順最大ため付け足せる個所はない
            if (index == 0) {
                out.println(-1);
                return;
            }
            /*
            昇順が崩れた箇所を入れ替えるだと、辞書順で大きくかつ辞書順で最小になれないので、一つ前を入れ替える
            abcdefghijklmnopqrstuvw
            であれば、
            abcdefghijklmnopqrstuv
            こうして、wを何かに入れ替える
            String[] demo = new String[]{"abcdefghijklmnopqrstuvwzyx", "abcdefghijklmnopqrstuvx", "abcdefghijklmnopqrstuvwxyz"};
            Arrays.sort(demo);
            for (String ss : demo) {
                out.println(ss);
            }
            abcdefghijklmnopqrstuvwxyz
            abcdefghijklmnopqrstuvwzyx
            abcdefghijklmnopqrstuvx
            wをwより後ろの文字のうち、一番近くて大きい文字に変える
             */

            char ch = s.charAt(index - 1);
            for (int i = s.length() - 1; i >= index; i--) {
                if (s.charAt(i) > ch) {
                    out.println(s.substring(0, index - 1) + s.charAt(i));
                    break;
                }
            }
        }


    }

    private void solveD() {
        int h = nextInt();
        int w = nextInt();
        int[][] a = IntStream.range(0, h).mapToObj(i -> {
            int[] wk = new int[w];
            for (int j = 0; j < w; j++) {
                wk[j] = nextInt();
            }
            return wk;
        }).toArray(int[][]::new);
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w - 1; j++) {
                if (a[i][j] % 2 != 0) {
                    a[i][j]--;
                    a[i][j + 1]++;
                    int wkH = i + 1;
                    int wkW = j + 1;
                    res.add(wkH + " " + wkW + " " + wkH + " " + (wkW + 1));
                }
            }
        }
        for (int i = 0; i < h - 1; i++) {
            if (a[i][w - 1] % 2 != 0) {
                a[i][w - 1]--;
                a[i + 1][w - 1]++;
                int wkH = i + 1;
                int wkW = w;
                res.add(wkH + " " + wkW + " " + (wkH + 1) + " " + wkW);
            }
        }
        out.println(res.size());
        for (String s : res) {
            out.println(s);
        }
    }

    private void solveE() {
        char[] n = next().toCharArray();
        int K = nextInt();
        long[][][] dp = new long[101][4][2];
        dp[0][0][0] = 1;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    int currentD = n[i] - '0';
                    for (int nd = 0; nd < 10; nd++) {
                        int ni = i + 1;
                        int nj = j;
                        int nk = k;
                        if (nd != 0)
                            nj++;
                        if (nj > K)
                            continue;
                        if (k == 0) {
                            if (nd > currentD)
                                continue;
                            if (nd < currentD)
                                nk = 1;
                        }
                        dp[ni][nj][nk] += dp[i][j][k];
                    }
                }
            }
        }
        out.println(dp[n.length][K][0] + dp[n.length][K][1]);
    }

    private void solveF() {

    }

    static final long CONST_INF = Long.MAX_VALUE / 4;

    public long[][] warshallFloyd(int n, int[][] edges) {
        long[][] graph = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], CONST_INF);
            graph[i][i] = 0;
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int f = edges[i][0] - 1;
            int t = edges[i][1] - 1;
            long cost = edges[i][2];
            graph[f][t] = cost;
            graph[t][f] = cost;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        return graph;
    }


    private static class GPair implements Comparable<GPair> {
        long k;
        long v;

        public GPair(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public GPair(long k, long v) {
            this.k = k;
            this.v = v;
        }

        public int compareTo(GPair pair) {
            return Long.compare(this.v, pair.v);
        }
    }


    private static class GraphNode {
        private long n;
        private Map<Long, GPair> childs;

        public GraphNode(long n) {
            this.n = n;
            childs = new TreeMap<Long, GPair>();
        }

        /**
         * not update
         *
         * @param child
         * @param d
         */
        public void addChild(long child, long d) {
            this.childs.put(child, this.childs.getOrDefault(child, new GPair(child, d)));
        }

        public GPair getChild(long child) {
            return this.childs.getOrDefault(child, new GPair(child, CONST_INF));
        }
    }

    private static class Graph {

        private Map<Long, GraphNode> graph;
        int n;

        /**
         * @param n    頂点数
         * @param list
         */
        public Graph(int n, int[][] list) {
            this.n = n;
            graph = new HashMap<Long, GraphNode>();
            /*
            隣接行列作成
            0-indexed
             */
            Arrays.stream(list).forEach(l -> {
                long a = l[0] - 1;
                long b = l[1] - 1;
                long d = l[2];
                graph.put(a, graph.getOrDefault(a, new GraphNode(a)));
                graph.get(a).addChild(b, d);
                graph.put(b, graph.getOrDefault(b, new GraphNode(b)));
                graph.get(b).addChild(a, d);
            });
            /*
            たどり着けない場所はCONST_INFで埋める
            自分へはCOST=0でたどり着ける
             */
            for (long i = 0; i < n; i++) {
                graph.put(i, graph.getOrDefault(i, new GraphNode(i)));
                GraphNode node = graph.get(i);
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        node.addChild(j, 0L);
                    else
                        node.addChild(j, CONST_INF);
                }
            }
        }

        /**
         * ワーシャルフロイド
         */
        public void warshallFloyd() {
            for (long k = 0; k < n; k++) {
                for (long i = 0; i < n; i++) {
                    for (long j = 0; j < n; j++) {
                        long min = Math.min(graph.get(i).getChild(j).v, graph.get(i).getChild(k).v + graph.get(k).getChild(j).v);
                        graph.get(i).getChild(j).v = min;
                    }
                }
            }
        }

        /**
         * 2点間の距離
         *
         * @param from
         * @param to
         * @return
         */
        public long getDistance(long from, long to) {
            return graph.get(from).getChild(to).v;
        }

    }

    private static class SegTree {
        long e = 0;

        long calcFunc(long a, long b) {
            return a + b;
        }

        int n;
        long nodes[];

        public SegTree(long[] a) {
            init(a);
        }

        public SegTree(int len, long x) {
            long a[] = new long[len];
            Arrays.fill(a, x);
            init(a);
        }

        public SegTree(int len) {
            init(len);
        }

        void init(long[] a) {
            init(a.length);
            for (int i = 0; i < a.length; i++) {
                nodes[i + n - 1] = a[i];
            }
            for (int i = n - 2; i >= 0; i--) {
                nodes[i] = calcFunc(nodes[i * 2 + 1], nodes[i * 2 + 2]);
            }
        }

        void init(int len) {
            n = 1;
            while (n < len) {
                n *= 2;
            }
            nodes = new long[n * 2 - 1];
            Arrays.fill(nodes, e);
            for (int i = n - 2; i >= 0; i--) {
                nodes[i] = calcFunc(nodes[i * 2 + 1], nodes[i * 2 + 2]);
            }
        }

        void set(final int i, long val) {
            int wkI = i + n - 1;
            nodes[wkI] = val;
            while (wkI > 0) {
                wkI = (wkI - 1) / 2;
                nodes[wkI] = calcFunc(nodes[wkI * 2 + 1], nodes[wkI * 2 + 2]);
            }
        }

        long get(int i) {
            return find(i, i + 1);
        }

        /*
       要求区間 [a, b) 中の要素の最小値を答える
       k := 自分がいるノードのインデックス
       対象区間は [l, r) にあたる
        */
        long find(int a, int b) {
            return find(a, b, 0, 0, n);
        }

        long find(int a, int b, int k, int l, int r) {
            if (r < 0)
                r = n;

            if (b <= l || r <= a)
                return e;

            if (a <= l && r <= b)
                return nodes[k];

            long val1 = find(a, b, k * 2 + 1, l, (l + r) / 2);
            long val2 = find(a, b, k * 2 + 2, (l + r) / 2, r);
            //Math.min()
            //今回は区間内の個数なのでSUM
            return val1 + val2;
        }
    }

    private static class UnionFind {
        int[] pars;

        public UnionFind(int n) {
            pars = new int[n + 1];
            Arrays.fill(pars, -1);
        }

        public int getChilds(int n) {
            int wk = getRoot(n);
            return pars[wk];
        }

        public int getRoot(int n) {
            if (pars[n] < 0)
                return n;
            return pars[n] = getRoot(pars[n]);
        }

        public boolean isSame(int a, int b) {
            return getRoot(a) == getRoot(b);
        }

        private int getSize(int a) {
            return -pars[getRoot(a)];
        }

        public void unite(int a, int b) {
            int wkA = getRoot(a);
            int wkB = getRoot(b);
            if (wkA == wkB)
                return;

            if (getSize(wkA) < getSize(wkB)) {
                int tmp = wkA;
                wkA = wkB;
                wkB = tmp;
            }
            pars[wkA] = pars[wkA] + pars[wkB];
            pars[wkB] = wkA;
        }
    }

    public long calcSimpleCombination(long n, long m, long CONST_MOD) {
        long mole = 1;
        for (long i = 1; i <= n + m; i++) {
            mole *= i;
            mole %= CONST_MOD;
        }
        long deno = 1;
        for (long i = 1; i <= n; i++) {
            deno *= i;
            deno %= CONST_MOD;
        }
        for (int i = 1; i <= m; i++) {
            deno *= i;
            deno %= CONST_MOD;
        }
        deno = modInverse(deno, CONST_MOD);
        return (mole * deno) % CONST_MOD;
    }

    long abs(double x) {
        return (long) Math.abs(x);
    }

    long round(double x) {
        return Math.round(x);
    }

    long floor(double x) {
        return (long) Math.floor(x);
    }

    long ceil(double x) {
        return (long) Math.ceil(x);
    }

    double sqrt(double x) {
        return Math.sqrt(x);
    }

    double pow(double x, double y) {
        return Math.pow(x, y);
    }

    long pow(long x, long y) {
        return (long) Math.pow(x, y);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    int upperToInt(char a) {
        return a - 'A';
    }

    int lowerToInt(char a) {
        return a - 'a';
    }

    int numToInt(char a) {
        return a - '0';
    }

    int charToInt(char a) {
        return a >= 'a' ? lowerToInt(a) : a >= 'A' ? upperToInt(a) : numToInt(a);
    }

    char intToUpper(int a) {
        return (char) (a + 'A');
    }

    char intToLower(int a) {
        return (char) (a + 'a');
    }

    char intToNum(int a) {
        return (char) (a + '0');
    }

    void reverse(String array[]) {
        String reversed[] = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = reversed[i];
        }
    }

    void reverse(int array[]) {
        int reversed[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = reversed[i];
        }
    }

    void reverse(long array[]) {
        long reversed[] = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = reversed[i];
        }
    }

    void reverse(double array[]) {
        double reversed[] = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = reversed[i];
        }
    }

    void reverse(boolean array[]) {
        boolean reversed[] = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = reversed[i];
        }
    }

    void fill(int array[], int x) {
        Arrays.fill(array, x);
    }

    void fill(long array[], long x) {
        Arrays.fill(array, x);
    }

    void fill(double array[], double x) {
        Arrays.fill(array, x);
    }

    void fill(boolean array[], boolean x) {
        Arrays.fill(array, x);
    }

    void fill(int array[][], int x) {
        for (int a[] : array) {
            fill(a, x);
        }
    }

    void fill(long array[][], long x) {
        for (long a[] : array) {
            fill(a, x);
        }
    }

    void fill(double array[][], double x) {
        for (double a[] : array) {
            fill(a, x);
        }
    }

    void fill(boolean array[][], boolean x) {
        for (boolean a[] : array) {
            fill(a, x);
        }
    }

    void fill(int array[][][], int x) {
        for (int a[][] : array) {
            fill(a, x);
        }
    }

    void fill(long array[][][], long x) {
        for (long a[][] : array) {
            fill(a, x);
        }
    }

    void fill(double array[][][], double x) {
        for (double a[][] : array) {
            fill(a, x);
        }
    }

    void fill(boolean array[][][], boolean x) {
        for (boolean a[][] : array) {
            fill(a, x);
        }
    }

    long INF = (long) 1e18 + 7;

    boolean isINF(long a) {
        return abs(a) > INF / 1000;
    }

    boolean isPlusINF(long a) {
        return a > 0 && isINF(a);
    }

    boolean isMinusINF(long a) {
        return isPlusINF(-a);
    }

    int I_INF = (int) 1e9 + 7;

    boolean isINF(int a) {
        return abs(a) > I_INF / 1000;
    }

    boolean isPlusINF(int a) {
        return a > 0 && isINF(a);
    }

    boolean isMinusINF(int a) {
        return isPlusINF(-a);
    }

    public long mod(long i) {
        return i % MOD + ((i % MOD) < 0 ? MOD : 0);
    }

    long powMod(long x, long y) {
        if (y == 0) {
            return 1;
        } else {
            long tmp = powMod(x, y / 2);
            return mod(mod(tmp * tmp) * (y % 2 == 0 ? 1 : x));
        }
    }

    long[] powsMod(long x, int max) {
        long pow[] = new long[max + 1];
        pow[0] = 1;
        for (int i = 0; i < max; i++) {
            pow[i + 1] = mod(pow[i] * x);
        }
        return pow;
    }

    long inv(long x) {
        return powMod(x, MOD - 2);
    }

    int MAX_FACT = 5_000_100;
    long fact[];
    long invFact[];

    /**
     * Combination簡易版
     * 5 C 2
     * 異なる n個のものから r個を選ぶ組み合わせの総数 nCr を求めます。
     * 5!(5*4*3*2*1)
     * /
     * 2!(2*1) *  (5-2)!(3*2*1)
     *
     * @param n
     * @param r
     * @return
     */
    private long getComb(int n, int r) {
        long tmp = 1;
        for (int i = 1; i <= r; i++) {
            tmp *= n - i + 1;
            tmp = mod(tmp);
            tmp *= inv(i);
            tmp = mod(tmp);
        }
        return tmp;
    }

    /**
     * 階乗計算の事前累積和
     * [1, 1, 2, 3, 4, 5, … FACTORIAL_NUM]
     * mod済
     */
    void prepareFact() {
        fact = new long[MAX_FACT];
        Arrays.fill(fact, 0);
        invFact = new long[MAX_FACT];
        Arrays.fill(invFact, 0);
        fact[0] = 1;
        int maxIndex = (int) min(MAX_FACT, (int) MOD);
        for (int i = 1; i < maxIndex; i++) {
            fact[i] = mod(fact[i - 1] * i);
        }
        invFact[maxIndex - 1] = inv(fact[maxIndex - 1]);
        for (int i = maxIndex - 1; i > 0; i--) {
            invFact[i - 1] = mod(invFact[i] * i);
        }
    }

    /**
     * 順列
     * nPk -> n! / (n-k)!
     *
     * @param n
     * @param r
     * @return
     */
    long permutation(int n, int r) {
        if (n < 0 || r < 0 || n < r) {
            return 0;
        }
        return mod(fact[n] * invFact[n - r]);
    }

    /**
     * 組み合わせ
     * nCk -> n! / k!・(n-k)!
     *
     * @param n
     * @param r
     * @return
     */
    long combination(int n, int r) {
        if (n < 0 || r < 0 || n < r) {
            return 0;
        }
        return mod(permutation(n, r) * invFact[r]);
    }

    /**
     * 重複組合せ nHr （同次積）
     * nHr = (n+r-1)Cr
     * 異なるn個のものから重複を許してr個取る組合せの総数
     * 例：
     * リンゴ，ミカン，牛肉の3種類の果物があります．これらの中から6個の食材を買って帰ります．
     * このとき，何通りの買い方がありますか？ただし，含まれない食材があってもよいものとします
     *
     * @param n
     * @param r
     * @return
     */
    long homogeneousProduct(int n, int r) {
        return combination((n - 1) + r, r);
    }

    /**
     * 多項係数
     * 文字aをp個,bをq個,cをr個, dをs個 あわせてn個を1列に並べるときの並べ方
     * n! / p!・q!・r!・s!
     *
     * @param n
     * @param strNum
     * @param mod
     * @return
     */

    /**
     * フェルマーの小定理を用いて逆元を求める。
     * ある数xのmod p（pは素数）の逆数x'はx' = x^(p-2)
     * 繰り返し二乗法を用いて計算する。
     * http://satanic0258.hatenablog.com/entry/2016/04/29/004730
     * {@link BigInteger#modInverse(BigInteger)}とどちらが速いか？
     *
     * @param x
     * @return
     */
    private long modInverse(long x, long mod) {
        long res = 1L;
        long k = mod - 2L;
        long y = x;
        while (k != 0) {
            if (k % 2 != 0) {
                res = (res * y) % mod;
            }
            y = (y * y) % mod;
            k /= 2;
        }
        return res;
    }


    private final PrintWriter out = new PrintWriter(System.out);
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte())
            return buffer[ptr++];
        else
            return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr]))
            ptr++;
    }

    public boolean hasNext() {
        skipUnprintable();
        return hasNextByte();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext())
            throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while (true) {
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            } else if (b == -1 || !isPrintableChar(b)) {
                return minus ? -n : n;
            } else {
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }

    public long min(long... v) {
        long min = Long.MAX_VALUE;
        for (long i : v) min = Math.min(min, i);
        return min;
    }

    public long max(long... v) {
        long max = Long.MIN_VALUE;
        for (long i : v) max = Math.max(max, i);
        return max;
    }
}
