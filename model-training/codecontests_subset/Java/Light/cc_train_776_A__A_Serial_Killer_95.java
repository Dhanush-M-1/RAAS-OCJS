import java.util.*;
public class A {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String p = in.next(), q = in.next();
    int n = in.nextInt();
    System.out.println(p + " " + q);
    for (int i = 0; i < n; i++) {
      String x = in.next();
      if (p.equals(x)) {
        p = in.next();
      } else {
        q = in.next();
      }
      System.out.println(p + " " + q);
    }
  }
}
