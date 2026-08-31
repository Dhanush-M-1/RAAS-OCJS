import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        numDays = sc.nextInt();
        fixTime = sc.nextInt();
        prodRateNormal = sc.nextInt();
        prodRateOdd = sc.nextInt();
        int numUpdates = sc.nextInt();

        Tree normal = new Tree(numDays);
        Tree odd = new Tree(numDays);

        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < numUpdates; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int day = sc.nextInt() - 1;
                int numOrders = sc.nextInt();
                long sumNormal = normal.getSingle(day);
                long sumNormal2 = Math.min(sumNormal+numOrders, prodRateNormal);
                sumNormal2 -= sumNormal;
                normal.add(day, sumNormal2);
                long sumOdd = odd.getSingle(day);
                long sumOdd2 = Math.min(sumOdd+numOrders, prodRateOdd);
                sumOdd2 -= sumOdd;
                odd.add(day, sumOdd2);
            } else {
                int day = sc.nextInt() - 1;
                int oddStart = 0;
                int oddEnd = day-1;
                int normalStart = day+fixTime;
                int normalEnd = numDays-1;
                long left = 0;
                long right = 0;
                if (oddEnd >= 0) {
                    left = odd.getRangeSum(oddStart, oddEnd);
                }
                if (normalStart < numDays) {
                    right = normal.getRangeSum(normalStart, normalEnd);
                }
                long sum = left + right;
//                System.out.printf("[%d, %d] + [%d, %d]\n", oddStart, oddEnd, normalStart, normalEnd);
//                System.out.printf("%d + %d = %d\n", left, right, sum);
                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb);
    }
    static int numDays;
    static int fixTime;
    static int prodRateNormal;
    static int prodRateOdd;

    public static class SumSegmentTree {
        int start;
        int end;
        SumSegmentTree Left;
        SumSegmentTree Right;
        long sum;
        long actualProduction;
        long actualProductionNormal;

        public SumSegmentTree(int start2, int end2) {
            if (start2 > end2) {
                throw new AssertionError();
            }
            start = start2;
            end = end2;
            if (start2 != end2){
                Left = new SumSegmentTree(start2, start2 + (end2 - start2) / 2);
                Right = new SumSegmentTree(start2 + (end2 - start2) / 2 + 1, end2);
            }
            else{
                Left = null;
                Right = null;
            }
            sum = 0;
            actualProduction = 0;
            actualProductionNormal = 0;
        }

        public long add(int index, int amount) {
            if (start <= index && end >= index) {
                sum = sum + amount;
//                actualProduction = Math.min(prodRateOdd, sum);
            }
            if (start > index || end < index){
                return 0;
            }
            if (start == end) {
                actualProduction = Math.min(prodRateOdd, sum);
                return actualProduction;
            }
//            actualProduction = 0;
            actualProduction += Left.add(index, amount);
            actualProduction += Right.add(index, amount);
            return actualProduction;
        }

        public long fakeAdd(int index) {
            if (start > index || end < index){
                return 0;
            }
            if (start == end) {
                actualProductionNormal = Math.min(prodRateNormal, sum);
                return actualProductionNormal;
            }
//            actualProductionNormal = 0;
            actualProductionNormal += Left.fakeAdd(index);
            actualProductionNormal += Right.fakeAdd(index);
            return actualProductionNormal;
        }

        public long update(int left, int right, int prodRate) {
            if (start > right || end < left){
                return 0;
            }
            if (start == end) {
                actualProduction = Math.min(prodRate, sum);
                return actualProduction;
            }
            actualProduction = 0;
            actualProduction += Left.update(left, right, prodRate);
            actualProduction += Right.update(left, right, prodRate);
            return actualProduction;
        }

        public long rangeSearch(int left, int right) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && right >= end){
                return actualProduction;
            }
            return Left.rangeSearch(left, right) + Right.rangeSearch(left, right);
        }

        public long rangeSearch2(int left, int right) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && right >= end){
                return actualProductionNormal;
            }
            return Left.rangeSearch2(left, right) + Right.rangeSearch2(left, right);
        }

        public void string() {
            string("", this);
        }

        public void string(String indent, SumSegmentTree a) {
            System.out.println(indent + "RANGE: " + a.start + "-" + a.end);
            System.out.println(indent + "SUM: " + a.sum);
            if (a.start != a.end) {
                string(indent + "\t", a.Left);
                string(indent + "\t", a.Right);
            }
        }
    }

    static class Tree {
        private long[] tree;

        /* Initialize all elements to zero. */
        Tree(int size) {
            this.tree = new long[size];
        }

        /* O(log n) get sum of tree[0..idx], inclusive */
        long getPartialSum(int idx) {
            long res = 0;
            while (idx >= 0) {
                res += tree[idx];
                idx = (idx & (idx + 1)) - 1;
            }
            return res;
        }

        /* O(log n) update.  t[idx] += val */
        void add(int idx, long val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx |= (idx + 1);
            }
        }

        /* O(log n) return t[idx] */
        long getSingle(int idx){
            long sum = tree[idx];
            if (idx > 0) {
                int z = (idx & (idx + 1)) - 1;
                idx--;
                while (idx != z) {
                    sum -= tree[idx];
                    idx = (idx & (idx + 1)) - 1;
                }
            }
            return sum;
        }

        /* O(log n) return sum(t[idx] for idx in range[from, to]) */
        long getRangeSum(int from, int to) {
            return getPartialSum(to) - getPartialSum(from - 1);
        }

        /* can also do: scaling in O(n),
         * searching for given cumulative freq in O(log n),
         * adding to entire range in O(log n)
         */
    }

    static void shuffle(int[] arr) {
        Random rng = new Random();
        int length = arr.length;
        for (int idx = 0; idx < arr.length; idx++) {
            int toSwap = idx + rng.nextInt(length-idx);
            int tmp = arr[idx];
            arr[idx] = arr[toSwap];
            arr[toSwap] = tmp;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        public FastScanner() {
            this(new InputStreamReader(System.in));
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
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
