import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
    }

    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
    }

    int[] c = new int[n-1];
    for (int i = 0; i < n - 1; i++) {
        c[i] = sc.nextInt();
    }

    int ans = 0;
    int l = -1;
    for (int i = 0; i < n; i++) {
        ans += b[a[i]-1];

        if (i-1 >= 0) {
            if (a[i-1]+1 == a[i]) {
                ans += c[a[i-1] - 1];
            }
        }
    }

    System.out.println(ans);
  }
}