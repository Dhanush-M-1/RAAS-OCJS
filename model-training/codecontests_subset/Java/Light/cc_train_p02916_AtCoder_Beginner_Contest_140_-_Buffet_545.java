import java.util.*;

public class Main {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n + 1];
    int[] b = new int[n + 1];
    int[] c = new int[n];

    String dm = "";
    for (int i = 1; i <= n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 1; i <= n; i++) {
      b[i] = sc.nextInt();
    }
    for (int i = 1; i < n; i++) {
      c[i] = sc.nextInt();
    }
    
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      ans += b[a[i]];
      if (i < n && a[i+1] == a[i] + 1) ans += c[a[i]];
    }
    
    System.out.println(ans);
  }
}
