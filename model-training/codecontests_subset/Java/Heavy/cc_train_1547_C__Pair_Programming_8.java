import java.io.*;
import java.util.*;

public class Codeforces {

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        t = fs.getInt();
        while (t-- > 0) {
            int k = fs.getInt();
            int n = fs.getInt();
            int m = fs.getInt();

            int[] mono = fs.getIntArray(n);
            int[] poly = fs.getIntArray(m);

            int number = k;

            int i = 0;
            int j = 0;
            boolean hasAns = true;
            List<Integer> list = new ArrayList<>();

            while (i < n || j < m) {
                if (i < n && mono[i] == 0) {
                    number += 1;
                    i += 1;
                    list.add(0);
                } else if (j < m && poly[j] == 0) {
                    number += 1;
                    j += 1;
                    list.add(0);
                } else if (i < n && mono[i] <= number) {
                    list.add(mono[i]);
                    i += 1;
                } else if (j < m && poly[j] <= number) {
                    list.add(poly[j]);
                    j += 1;
                } else {
                    // System.out.println(i + " " + j);
                    hasAns = false;
                    break;
                }
            }

            if (!hasAns) {
                pw.println(-1);
            } else {
                Utility.printIntList(list, pw);
            }

        }
        pw.close();
    }
}

class MOD {
    static long mod = 1000000007;

    static long add(long x, long y) {
        return (x % mod + y % mod) % mod;
    }

    static long sub(long x, long y) {
        return (x % mod - y % mod) % mod;
    }

    static long mul(long x, long y) {
        return (x % mod * y % mod) % mod;
    }

    static long pow(long x, long y) {
        long result = 1;
        x %= mod;
        while (y > 0) {
            if ((y & 1) == 1)
                result = mul(result, x);
            x = mul(x, x);
            y = y >>> 1;
        }
        return result;
    }

    static long modInv(long x) {
        return pow(x, mod - 2);
    }

}

class Utility {
    static int ceil(int a, int b) {
        if (a == 0)
            return 0;
        return (a - 1) / b + 1;
    }

    static long ceil(long a, long b) {
        if (a == 0)
            return 0;
        return (a - 1) / b + 1;
    }

    static int gcd(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long gcd(long a, long b) {
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int binarySearch(int[] ar, int x, int start, int end) {
        int l = start;
        int r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ar[mid] == x) {
                return mid;
            } else if (ar[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static int lowerBound(int[] ar, int x) {
        int l = 0;
        int r = ar.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (ar[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return r + 1;
    }

    static int upperBound(int[] ar, int x) {
        int l = 0;
        int r = ar.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (ar[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    static void sort(int[] ar) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : ar)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < ar.length; i++)
            ar[i] = l.get(i);
    }

    static void sortReverse(int[] ar) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : ar)
            l.add(i);
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < ar.length; i++)
            ar[i] = l.get(i);
    }

    static void sort(long[] ar) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : ar)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < ar.length; i++)
            ar[i] = l.get(i);
    }

    static void sortReverse(long[] ar) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : ar)
            l.add(i);
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < ar.length; i++)
            ar[i] = l.get(i);
    }

    static void printArray(int[] ar, PrintWriter pw) {
        for (int i = 0; i < ar.length; i++) {
            pw.print(ar[i] + " ");
        }
        pw.println();
    }

    static void printArray(long[] ar, PrintWriter pw) {
        for (int i = 0; i < ar.length; i++) {
            pw.print(ar[i] + " ");
        }
        pw.println();
    }

    static void printIntList(List<Integer> list, PrintWriter pw) {
        for (int i = 0; i < list.size(); i++) {
            pw.print(list.get(i) + " ");
        }
        pw.println();
    }

    static void printLongList(List<Long> list, PrintWriter pw) {
        for (int i = 0; i < list.size(); i++) {
            pw.print(list.get(i) + " ");
        }
        pw.println();
    }

    static long choose(long n, long k) {
        long res = 1;
        if (k > n - k)
            k = n - k;
        for (long i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}

class Pair implements Comparable<Pair> {
    Integer first;
    Integer second;

    Pair(Integer f, Integer s) {
        this.first = f;
        this.second = s;
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (((Pair) object).first == this.first && ((Pair) object).second == this.second && object instanceof Pair) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(first) + ":" + String.valueOf(second)).hashCode();
    }

    @Override
    public int compareTo(Pair p) {
        int f = first.compareTo(p.first);
        if (f != 0)
            return f;

        return Integer.compare(second, p.second);
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int getInt() {
        return Integer.parseInt(next());
    }

    long getLong() {
        return Long.parseLong(next());
    }

    int[] getIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = getInt();
        return a;
    }

    long[] getLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = getLong();
        return a;
    }

    List<Integer> getIntList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(getInt());
        return list;
    }

    List<Long> getLongList(int n) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(getLong());
        return list;
    }
}
