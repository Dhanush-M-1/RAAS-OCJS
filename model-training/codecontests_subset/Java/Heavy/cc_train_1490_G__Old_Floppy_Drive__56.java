import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class F {

    static class Pair {
        long a;
        long b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = getInt(reader.readLine());
        while (t-- > 0) {
            int[] inp = getArray(reader.readLine());
            int n = inp[0];
            int m = inp[1];
            long[] a = getLongArray(reader.readLine());
            long[] xl = getLongArray(reader.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            long sum = 0;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (sum > max) {
                    max = sum;
                    map.put(max, i);
                }
            }
            for (int i = 0; i < m; i++) {
                long x = xl[i];
                if (x <= map.lastKey()) {
                    int ind = map.ceilingEntry(x).getValue();
                    System.out.print(ind + " ");
                    continue;
                }
                if (sum <= 0) {
                    System.out.print(-1 + " ");
                    continue;
                }
                long needed = x - max;
                long cycles = (needed + sum - 1) / sum;
                long ans = cycles * n + map.ceilingEntry(x - sum * cycles).getValue();
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    private static int[] getArray(String readLine) {
        String strings[] = readLine.split(" ");
        int n = strings.length;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }
        return a;
    }

    private static long[] getLongArray(String readLine) {
        String strings[] = readLine.split(" ");
        int n = strings.length;
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(strings[i]);
        }
        return a;
    }

    private static int lowerBound(ArrayList<Long> a, int n, int x) {
        int l = -1; //a[ans] <l
        int r = n; //a[ans]>=r
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (l != -1) {
            while (l > 0 && a.get(l) == x) l--;
            if (l == 0 && a.get(0) >= x) return l;
            else l++;
            return l;
        }
        return l + 1;
    }

    private static int getInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
