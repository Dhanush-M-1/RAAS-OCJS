import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] a = new int[n];
    int ans = 0;
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(sc.next());
      ans += (a[i] - 1);
    }
    System.out.println(ans);
  }
}
