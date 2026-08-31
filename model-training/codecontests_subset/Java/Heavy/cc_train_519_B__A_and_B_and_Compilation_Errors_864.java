
import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.*;

public class Task {

    public static void main(String[] args) {

        Thread t = new Thread(null, null, "Solution", 100000000) {

            @Override
            public void run() {
                InputStream inputstream = System.in;
                OutputStream outputstream = System.out;

                InputReader in = new InputReader(inputstream);
                PrintWriter out = new PrintWriter(outputstream);

                MathAlgo ma = new MathAlgo();
                PreCompute pc = new PreCompute();
                GraphAlgo ga = new GraphAlgo();

                int T = 1;
                //   T = Integer.parseInt(in.readString());
                for (int i = 1; i <= T; i++) {
                    Solution solver = new Solution();
                    solver.solve(i, in, out, pc, ma, ga);
                }
                out.close();
            }
        };
        t.start();
    }
}

class PreCompute {

    public void compute() {

    }
}

class Solution {

    public void solve(int testno, InputReader in, PrintWriter out, PreCompute pc, MathAlgo ma, GraphAlgo ga) {

        int n = in.readInt();

        int xor1 = 0;

        for (int i = 0; i < n; i++) {
            int t = in.readInt();
            xor1 ^= t;
        }
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            int t = in.readInt();
            xor2 ^= t;
        }

        int xor3 = 0;
        for (int i = 0; i < n - 2; i++) {
            int t = in.readInt();
            xor3 ^= t;
        }

        out.println(xor1 ^ xor2);
        out.println(xor2 ^ xor3);

    }
}

class GraphAlgo {

}

class MathAlgo {

    final long MOD = 100000000 + 7;
    boolean[] checkPrime;
    long[] primeArray;
    long[][] pascalMatrix;

    public long add(long a, long b, long MOD) {
        return (((a + b) % MOD + MOD) % MOD);
    }

    public long mul(long a, long b, long MOD) {
        return (((((a % MOD) * (b % MOD)) % MOD) + MOD) % MOD);
    }

    public void swap(long[] arr, int pos1, int pos2) {
        long temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public void reverse(long[] arr, int start, int finish) {
        int size = finish - start + 1;
        if (size == 0 || size == 1) {
            return;
        }
        for (int i = start, j = finish; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    private void takePrime(int size) {
        int cnt = 0;
        for (int i = 2; i <= size; i++) {
            if (checkPrime[i] == true) {
                cnt++;
            }
        }
        primeArray = new long[cnt];
        int index = 0;
        for (int i = 2; i <= size; i++) {
            if (checkPrime[i] == true) {
                primeArray[index++] = i;
            }
        }
    }

    public void calculatePrime(int size) {
        checkPrime = new boolean[size + 1];
        Arrays.fill(checkPrime, true);
        checkPrime[0] = false;
        checkPrime[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (checkPrime[i] == true) {
                for (int j = i * i; j <= size; j += i) {
                    checkPrime[j] = false;
                }
            }
        }
        takePrime(size);
    }

    public long gcd(long large, long small) {
        if (small == 0) {
            return (large);
        }
        return (gcd(small, large % small));
    }

    public long pow(long base, long p, long mod) {
        long ans = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                ans = mul(ans, base, mod);
            }
            base = mul(base, base, mod);
            p >>= 1;
        }
        return (ans);
    }

    public void constructPascal(int N) {

        pascalMatrix = new long[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            pascalMatrix[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                pascalMatrix[i][j] = pascalMatrix[i - 1][j - 1] + pascalMatrix[i - 1][j];
            }
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readLine() {
        int c = read();
        while (checkEndLine(c)) {
            c = read();
        }
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            if (checkEndLine(c) == true) {
                break;
            }
            c = read();
        } while (!checkEndLine(c));
        return res.toString();
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long readLong() {
        return Long.parseLong(readString());
    }

    public double readDouble() {
        return Double.parseDouble(readString());
    }

    public float readFloat() {
        return Float.parseFloat(readString());
    }

    public static boolean checkEndLine(int c) {
        return c == '\n' || c == -1 || c == '\r';
    }

    public static boolean isSpaceChar(int c) {
        return c == '\n' || c == '\r' || c == '\t' || c == -1 || c == ' ';
    }
}
