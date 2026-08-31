import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();
    long P = sc.nextLong();
    HashMap<Long, Long> map = new HashMap<>();
    for (long i = 2; i * i <= P; i++) {
      while (P % i == 0) {
        if (map.containsKey(i)) {
          long tmp = map.get(i);
          map.put(i, tmp + 1);
        } else {
          map.put(i, 1L);
        }
        P /= i;
      }
    }
    if (P != 1) {
      map.put(P, 1L);
    }
    long ans = 1;
    for (Long key : map.keySet()) {
      if (map.get(key) >= N) {
        ans *= (long)Math.pow(key, map.get(key) / N);
      }
    }
    System.out.println(ans);
  }
}
