import java.util.*;

public class Main {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      cnt = isPrime(sc.nextInt()) ? cnt + 1 : cnt;
    }
    System.out.println(cnt);
  }

  static boolean isPrime(int x) {
    if (x == 2)
      return true;
    if (x < 2 || x % 2 == 0)
      return false;

    // 合成数xはp<=sqrt x を満たす素因子pを持つ
    int sqrt = (int) Math.sqrt((double) x);
    for (int i = 3; i <= sqrt; i = i + 2) {
      if (x % i == 0)
        return false;
    }
    return true;
  }
}

