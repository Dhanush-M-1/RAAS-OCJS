import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Anna on 01.04.2016.
 */
public class Template {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Template task = new Template();
        task.open();
        task.solve();
        task.close();
    }
//
//    ArrayList<Integer> primes = new ArrayList<Integer>();
//    int[] minPrimeDivisor;
//
//    int getPrimes(int n) {
//        int cnt = 0;
//        minPrimeDivisor = new int[n + 1];
//        for (int i = 2; i <= n; i++) {
//            if (minPrimeDivisor[i] == 0) {
//                minPrimeDivisor[i] = i;
//                primes.add(i);
//                cnt++;
//            }
//
//            for (Integer prime : primes) {
//                if (prime <= minPrimeDivisor[i] && (1L * prime * i <= n)) {
//                    minPrimeDivisor[prime * i] = prime;
//                    cnt++;
//                } else break;
//            }
//        }
//        return cnt;
//    }
//
//    int simpleGCD(int a, int b) {
//        if (b == 0) return a;
//        return simpleGCD(b, a % b);
//    }
//
//    class Pair {
//        int x, y, value;
//
//        Pair(int x, int y, int value) {
//            this.x = x;
//            this.y = y;
//            this.value = value;
//        }
//    }
//
//    Pair gcd(int a, int b) {
//        if (a == 0) return new Pair(0, 1, b);
//        Pair res = gcd(b % a, a);
//        int y = res.x;
//        int x = res.y - (b / a) * res.x;
//        res.x = x;
//        res.y = y;
//        return res;
//    }

    class Decomposition {

        int[] array;
        long[] sums;
        int cntSums;
        int sizeOfSum;
        int maxValue;

        Decomposition(int[] a, int n, int maxValue) {
            sizeOfSum = (int) Math.sqrt(n);
            cntSums = n / sizeOfSum + (n % sizeOfSum == 0 ? 0 : 1);
            array = a.clone();
            this.maxValue = maxValue;
            sums = new long[cntSums];
            for (int i = 0; i < cntSums; i++) {
                for (int j = i * sizeOfSum; j < n && j < (i + 1) * sizeOfSum; j++) {
                    if (array[j] > maxValue) array[j] = maxValue;
                    sums[i] += array[j];
                }
            }
        }


        long getSum(int queryLeft, int queryRight) {
            if (queryLeft > queryRight) return 0;
            int fromSum = queryLeft / sizeOfSum;
            int toSum = queryRight / sizeOfSum;

            long answer = 0;

            if (fromSum == toSum) {
                for (int i = queryLeft; i <= queryRight; i++) {
                    answer += array[i];
                }
                return answer;
            }

            for (int i = fromSum + 1; i < toSum; i++) {
                answer += sums[i];
            }

            for (int i = queryLeft; i < (fromSum + 1) * sizeOfSum; i++) {
                answer += array[i];
            }

            for (int i = toSum * sizeOfSum; i <= queryRight; i++) {
                answer += array[i];
            }

            return answer;
        }

        void putValue(int pos, int value) {
            int posSum = pos / sizeOfSum;
            if (value > maxValue) value = maxValue;
            sums[posSum] -= array[pos];
            array[pos] = value;
            sums[posSum] += value;
        }

    }


    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        int q = nextInt();
        int[] arr = new int[n];
        Decomposition decompositionA = new Decomposition(arr, n, a);
        Decomposition decompositionB = new Decomposition(arr, n, b);

        for (int i = 0; i < q; i++) {
            int type = nextInt();
            if (type == 1) {
                int day = nextInt() - 1;
                int value = nextInt();
                arr[day] += value;
                decompositionA.putValue(day, arr[day]);
                decompositionB.putValue(day, arr[day]);
            } else {
                int fromRepair = nextInt() - 1;
                int toRepair = fromRepair + k - 1;
                long answ = decompositionB.getSum(0, fromRepair - 1)
                        + decompositionA.getSum(toRepair + 1, n - 1);
                out.println(answ);
            }
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }


    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }


    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            st = new StringTokenizer(str);
        }
        return st.nextToken();
    }

    private void close() {
        out.close();
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }
}
