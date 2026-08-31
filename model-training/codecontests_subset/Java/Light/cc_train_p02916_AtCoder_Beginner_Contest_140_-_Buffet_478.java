import java.util.Scanner;
public class Main {
  static Scanner scan=new Scanner(System.in);
  public static void main(String[] args) {
    int n = scan.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n-1];
    for (int i = 0; i < n; ++i) {
      a[i] = scan.nextInt();
      --a[i];
    }
    for (int i = 0; i < n; ++i) {
      b[i] = scan.nextInt();
    }
    for (int i = 0; i < n-1; ++i) {
      c[i] = scan.nextInt();
    }

    int ans = b[a[0]];
    for (int i = 0; i < n-1; ++i) {
      if (a[i]+1 == a[i+1]) {
        ans += c[a[i]];
      }
      ans += b[a[i+1]];
    }

    System.out.println(ans);
  }
}
