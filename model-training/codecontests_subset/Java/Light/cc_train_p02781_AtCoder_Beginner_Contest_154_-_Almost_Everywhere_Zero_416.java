import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] ns = scanner.next().toCharArray();
    int N = ns.length;
    int[] digits = new int[N];
    for (int i = 0; i < N; i++) digits[i] = ns[i] - '0';
    int K = scanner.nextInt();

    long res = 0;
    for (List<Integer> l : comb(N, K)) {
      int r;
      if (l.get(0) == 0) {
        switch (K) {
          case 1:
            r = digits[0];
            break;
          case 2:
            if (allzero(digits, 0, l.get(1))) {
              r = (digits[0] - 1) * 9 + digits[l.get(1)];
            } else {
              r = digits[0] * 9;
            }
            break;
          case 3:
            if (allzero(digits, 0, l.get(1))) {
              if (allzero(digits, l.get(1), l.get(2))) {
                r = (digits[0] - 1) * 9 * 9;
                if (digits[l.get(1)] > 0) {
                  r += (digits[l.get(1)] - 1) * 9 + digits[l.get(2)];
                }
              } else {
                r =((digits[0] - 1) * 9 + digits[l.get(1)]) * 9;
              }
            } else {
              r = digits[0] * 9 * 9;
            }
            break;
          default:
            throw new IllegalStateException();
        }
      } else {
        r = 1;
        for (int i = 0; i < K; i++) r *= 9;
      }
      res += r;
    }
    System.out.println(res);
  }

  private static boolean allzero(int[] digits, int i, int j) {
    i++;
    for (; i < j; i++) if (digits[i] != 0) return false;
    return true;
  }

  private static List<List<Integer>> comb(int n, int k) {
    return combiter(0, n, k);
  }

  private static List<List<Integer>> combiter(int s, int n, int k) {
    if (s > n) return new ArrayList<>();
    if (k == 0) {
      List<List<Integer>> res = new ArrayList<>();
      res.add(new ArrayList<>());
      return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> a = combiter(s + 1, n, k - 1);
    for (List<Integer> aa : a) {
      aa.add(0, s);
      res.add(aa);
    }
    List<List<Integer>> b = combiter(s + 1, n, k);
    res.addAll(b);
    return res;
  }
}
