import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Errors {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Map<Integer, Integer> m1 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int d = in.nextInt();
      int v = m1.containsKey(d) ? m1.get(d) + 1 : 1;
      m1.put(d, v);
    }
    Map<Integer, Integer> m2 = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      int d = in.nextInt();
      if (m1.get(d) == 1) {
        m1.remove(d);
      } else {
        m1.put(d, m1.get(d) - 1);
      }

      int v = m2.containsKey(d) ? m2.get(d) + 1 : 1;
      m2.put(d, v);
    }
    for (int i = 0; i < n - 2; i++) {
      int d = in.nextInt();
      if (m2.get(d) == 1) {
        m2.remove(d);
      } else {
        m2.put(d, m2.get(d) - 1);
      }
    }
    System.out.println(m1.keySet().iterator().next());
    System.out.println(m2.keySet().iterator().next());
  }
}
