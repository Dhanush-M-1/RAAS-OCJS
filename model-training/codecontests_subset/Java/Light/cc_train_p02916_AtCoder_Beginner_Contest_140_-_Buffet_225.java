import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] a = new int[n + 5];
    int[] b = new int[n + 5];
    int[] c = new int[n + 5];
    int res = 0;

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }

    for (int i = 0; i < n - 1; i++) {
      if (i != n - 1) c[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      int cur = a[i] - 1;
      res += b[cur];
      if (i != n - 1) {
        int next = a[i+1] - 1;
        if (cur + 1 == next) res += c[cur];
      }
    }

    System.out.println(res);
  }
}
