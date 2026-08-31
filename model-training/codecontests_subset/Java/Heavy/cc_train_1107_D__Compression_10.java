import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        int t = 1;
        for (int i = 1; i <= t; i++) {
            Problem problem = new Problem();
            problem.solve(i);
        }
    }
}

class Problem {
    Parser parser = new Parser();

    public void solve(int testNum) {
        int n = parser.parseInt();

        int[][] arr = new int[n + 9][n + 9];
        for(int i = 1; i <= n; i++) {
            char[] s = parser.parseString().toCharArray();
            for(int j = 0; j < s.length; j++) {
                int c = s[j] >= 'A' ? s[j] - 'A' + 10 : s[j] - '0';
                arr[i][j * 4 + 1] = (c & (1 << 3)) > 0 ? 1 : 0;
                arr[i][j * 4 + 2] = (c & (1 << 2)) > 0 ? 1 : 0;
                arr[i][j * 4 + 3] = (c & (1 << 1)) > 0 ? 1 : 0;
                arr[i][j * 4 + 4] = (c & (1 << 0)) > 0 ? 1 : 0;
            }
        }

        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += arr[i][j];
                arr[i][j] = sum + arr[i - 1][j];
            }
        }

        for(int i = n; i >= 1; i--) {
            if(n % i != 0) continue;
            boolean is = true;
            for(int j = i; j <= n; j += i) {
                for(int k = i; k <= n; k += i) {
                    int sum = arr[j][k] - arr[j][k - i] - arr[j - i][k] + arr[j - i][k - i];
                    if(sum != 0 && sum != i * i) {
                        is = false;
                        break;
                    }
                }
                if(!is) {
                    break;
                }
            }
            if(is) {
                System.out.println(i);
                return;
            }
        }
    }
}

class MathUtil {

    public static List<Integer> getPrimes(int r) {
        if (r < 2) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        result.add(2);
        boolean[] is = new boolean[r + 1];
        for (int i = 4; i <= r; i += 2) {
            is[i] = true;
        }
        for (int i = 3; i <= r; i += 2) {
            if (is[i]) continue;
            result.add(i);
            for (long j = (long) i * i; j <= r; j += i) {
                is[(int) j] = true;
            }
        }
        return result;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long pow(long x, long y) {
        return pow(x, y, Function.identity());
    }

    public static long pow(long x, long y, long mod) {
        return pow(x, y, v -> v % mod);
    }

    private static long pow(long x, long y, Function<Long, Long> action) {
        long res = 1;
        long t = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                res *= t;
                res = action.apply(res);
            }
            t *= t;
            t = action.apply(t);
            y /= 2;
        }
        return res;
    }
}

class DisjointSet {

    private final int[] f;

    public DisjointSet(int size) {
        f = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            f[i] = i;
        }
    }

    public int find(int u) {
        if (f[u] == u) return u;
        return f[u] = find(f[u]);
    }

    public boolean merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return false;
        if (u > v) {
            int t = u;
            u = v;
            v = t;
        }
        f[u] = v;
        return true;
    }
}

class Parser {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;

    public int parseInt() {
        fill();
        return Integer.parseInt(tokenizer.nextToken());
    }

    public long parseLong() {
        fill();
        return Long.parseLong(tokenizer.nextToken());
    }

    public double parseDouble() {
        fill();
        return Double.parseDouble(tokenizer.nextToken());
    }

    public String parseLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String parseString() {
        fill();
        return tokenizer.nextToken();
    }

    private void fill() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}