import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static final long MOD = 998244353;

  private static int[][][] posLeft = new int[11][11][10];
  private static int[][][] posRight = new int[11][11][10];
  private static long[] tenPowers = new long[22];

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i += 1) {
      for (int j = 1; j <= 10; j += 1) {
        simulate(i, j);
      }
    }
    for (int i = 0; i < tenPowers.length; i += 1) {
      tenPowers[i] = pow(10, i);
    }

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[] count = new int[11];
    long[] nums = new long[n];

    for (int i = 0; i < n; i += 1) {
      nums[i] = in.nextLong();
      count[countDigits(nums[i])] += 1;
    }

    long res = 0;
    for (long num : nums) {
      int digits = countDigits(num);
      for (int i = 1; i <= 10; i += 1) {
        for (int d = 0; d < digits; d += 1) {
          long digit = getDigit(num, d);

          res += (digit * count[i] * getPowerLeft(digits, i, d)) % MOD;
          res %= MOD;

          res += (digit * count[i] * getPowerRight(digits, i, d)) % MOD;
          res %= MOD;
        }
      }
    }
    System.out.println(res);
  }

  private static void simulate(int digitsLeft, int digitsRight) {
    DigitPopper left = new DigitPopper(digitsLeft);
    DigitPopper right = new DigitPopper(digitsRight);

    int pos = 0;
    while (!left.done() || !right.done()) {
      if (!right.done()) {
        posRight[digitsRight][digitsLeft][right.getNext()] = pos;
        pos += 1;
      }
      if (!left.done()) {
        posLeft[digitsLeft][digitsRight][left.getNext()] = pos;
        pos += 1;
      }
    }
  }

  private static long getPowerLeft(int digits, int otherDigits, int pos) {
    return tenPowers[posLeft[digits][otherDigits][pos]];
  }

  private static long getPowerRight(int digits, int otherDigits, int pos) {
    return tenPowers[posRight[digits][otherDigits][pos]];
  }

  private static long getDigit(long num, long pos) {
    while (pos > 0) {
      num /= 10;
      pos -= 1;
    }
    return num % 10;
  }

  private static long pow(long base, long exp) {
    long res = 1;
    while (exp > 0) {
      res *= base;
      res %= MOD;
      exp -= 1;
    }
    return res;
  }

  private static int countDigits(long num) {
    int digits = 0;
    while (num > 0) {
      digits += 1;
      num /= 10;
    }
    return digits;
  }
}

class DigitPopper {
  private int digits;
  private int nextDigit;

  public DigitPopper(int digits) {
    this.digits = digits;
    this.nextDigit = 0;
  }

  public boolean done() {
    return nextDigit >= digits;
  }

  public int getNext() {
    return done() ? (-1) : (nextDigit++);
  }
}

class Scanner {
  private BufferedReader br;
  private StringTokenizer st;

  public Scanner(InputStream in) {
    br = new BufferedReader(new InputStreamReader(in));
  }

  public int nextInt() {
    return Integer.parseInt(nextToken());
  }

  public long nextLong() {
    return Long.parseLong(nextToken());
  }

  private String nextToken() {
    while (st == null || !st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }
}
