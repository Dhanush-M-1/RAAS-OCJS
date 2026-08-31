import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    static long mod = 1000000007L;
    static FastScanner scanner;
    static long BOUND = 1000000000000L;

    static int[] groups;
    static List<Integer>[] connections;

    public static void main(String[] args) {
        scanner = new FastScanner();
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] ops = scanner.nextIntArray(n);
        int[] sums = new int[n + 1];

        sums[0] = 0;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + ops[i];
        }
        int[] max = new int[n];
        max[n-1] = sums[n];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], sums[i + 1]);
        }

        int applied = 0;
        for (int i = 0; i < n; i++) {
            max[i] = max[i] + applied;
            applied -= ops[i];
        }

        //int applied = 0;
        for (int i = 0; i < n; i++) {
            max[i] = Math.min(d - max[i], d);
            if (ops[i] == 0 && max[i] < 0) {
                System.out.println(-1);
                return;
            }
        }

        int days = 0;
        int[] balances = new int[n + 10];
        balances[0] = 0;
        for (int i = 0; i < n; i++) {
            if (ops[i] != 0) {
                balances[i + 1] = balances[i] + ops[i];
                if (balances[i + 1] > d) {
                    System.out.println(-1);
                    return;
                }
            } else {
                if (balances[i] < 0) {
                    balances[i+1] =max[i];
                    days++;
                } else {
                    balances[i + 1] = balances[i];
                }
            }
        }
        System.out.println(days);
        //System.out.println(max);
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        int[] nextIntArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long[] nextLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }

        String[] nextStringArray(int n) {
            String[] res = new String[n];
            for (int i = 0; i < n; i++) res[i] = nextToken();
            return res;
        }
    }

    static class PrefixSums {
        long[] sums;

        public PrefixSums(long[] sums) {
            this.sums = sums;
        }

        public long sum(int fromInclusive, int toExclusive) {
            if (fromInclusive > toExclusive) throw new IllegalArgumentException("Wrong value");
            return sums[toExclusive] - sums[fromInclusive];
        }

        public static PrefixSums of(int[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }

        public static PrefixSums of(long[] ar) {
            long[] sums = new long[ar.length + 1];
            for (int i = 1; i <= ar.length; i++) {
                sums[i] = sums[i - 1] + ar[i - 1];
            }
            return new PrefixSums(sums);
        }
    }

    static class ADUtils {
        static void sort(int[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }

        static void reverse(int[] arr) {
            int last = arr.length / 2;
            for (int i = 0; i < last; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
        }

        static void sort(long[] ar) {
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                long a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
            Arrays.sort(ar);
        }
    }

    static class MathUtils {
        static long[] FIRST_PRIMES = {
                2,     3,      5,      7,     11,     13,     17,     19,     23,     29,
                31,     37,     41,     43,     47,     53,     59,     61,     67,     71,
                73,     79,     83,     89  ,   97 ,    101,    103,    107,    109,    113,
                127,    131,    137,    139,    149,    151,    157,    163,    167,    173,
                179,    181,    191,    193,    197,    199,    211,    223,    227,    229,
                233,    239,    241,    251,    257,    263,    269,    271,    277,    281,
                283,    293,    307,    311,    313,    317,    331,    337,    347,    349,
                353,    359,    367,    373,    379,    383,    389,    397,    401,    409,
                419,    421,    431,    433,    439,    443,    449,    457,    461,    463,
                467,    479,    487,    491,    499,    503,    509,    521,    523,    541,
                547,    557,    563,    569,    571,    577,    587,    593,    599,    601,
                607,    613,    617,    619,    631,    641,    643,    647,    653,    659,
                661,    673,    677,    683,    691,    701,    709,    719,    727,    733,
                739,    743,    751,    757,    761,    769,    773,    787,    797,    809,
                811,    821,    823,    827,    829,    839,    853,    857,    859,    863,
                877,    881,    883,    887,    907,    911,    919,    929,    937,    941,
                947,    953,    967,    971,    977,    983,    991,    997,   1009,   1013,
                1019,   1021,   1031,   1033,   1039,   1049,   1051};

        static long[] primes(int to) {
            long[] all = new long[to + 1];
            long[] primes = new long[to + 1];
            all[1] = 1;
            int primesLength = 0;
            for (int i = 2; i <= to; i ++) {
                if (all[i] == 0) {
                    primes[primesLength++] = i;
                    all[i] = i;
                }
                for (int j = 0; j < primesLength && i * primes[j] <= to && all[i] >= primes[j]; j++) {
                    all[(int) (i * primes[j])] = primes[j];
                }
            }
            return Arrays.copyOf(primes, primesLength);
        }

        static long modpow(long b, long e, long m) {
            long result = 1;

            while (e > 0) {
                if ((e & 1) == 1) {
            /* multiply in this bit's contribution while using modulus to keep
             * result small */
                    result = (result * b) % m;
                }
                b = (b * b) % m;
                e >>= 1;
            }

            return result;
        }

        static long submod(long x, long y, long m) {
            return (x - y + m) % m;
        }
    }
}

//4 - 1 * 6 * 2 = 12

//5 - 4 * 6 * 2 = 48
//5(2) - 4 * 1 * 6 * 1 = 24

//3 - 2 * 2 = 4
//4(1) - 3 * 2 * 2 = 12
//4(2) - 3 * 2 = 6

//--------------------
// 7 3
// 4 - 1 * 6 * 6 = 36 C(3,3)
// 5 - 1 *            c(4,3)
//                    c(5,3)

// 1
// 1

