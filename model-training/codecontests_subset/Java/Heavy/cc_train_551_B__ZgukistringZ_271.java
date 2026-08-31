import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by smalex on 20/09/15.
 */
public class P551B {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));

    String c = next();
    String a = next();
    String b = next();
    int[] aStat = createState(a);
    int[] bStat = createState(b);
    int[] cStat = createState(c);
    int bestA = 0;
    int bestB = 0;
    mainfor:
    for (int i = 0; ; i++) {
      int k = Integer.MAX_VALUE;
      for (int j = 0; j < 26; j++) {
        if (cStat[j] < aStat[j] * i) {
          break mainfor;
        }
        if (bStat[j] != 0) {
          k = Math.min(k, (cStat[j] - (aStat[j] * i)) / bStat[j]);
        }
      }
      if (i + k > bestA + bestB) {
        bestA = i;
        bestB = k;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bestA; i++) {
      sb.append(a);
    }
    for (int i = 0; i < bestB; i++) {
      sb.append(b);
    }
    for (int i = 0; i < 26; i++) {
      cStat[i] -= aStat[i] * bestA + bStat[i] * bestB;
      for (int j = 0; j < cStat[i]; j++) {
        sb.append((char) (i + 'a'));
      }
    }
    System.out.println(sb.toString());
  }

  private static int[] createState(String a) {
    int[] aStat = new int[26];
    for (int i = 0; i < a.length(); i++) {
      aStat[a.charAt(i) - 'a']++;
    }
    return aStat;
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static int[] nextIntArray(int len, int start) throws IOException {
    int[] a = new int[len];
    for (int i = start; i < len; i++)
      a[i] = nextInt();
    return a;
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static long[] nextLongArray(int len, int start) throws IOException {
    long[] a = new long[len];
    for (int i = start; i < len; i++)
      a[i] = nextLong();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }
}
