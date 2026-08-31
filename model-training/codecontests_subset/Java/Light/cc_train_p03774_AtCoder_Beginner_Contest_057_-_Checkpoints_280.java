import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[][] a = new long[n][2];
    long[][] c = new long[m][2];

    for (int i = 0; i < n; i++) {
      a[i][0] = sc.nextLong();
      a[i][1] = sc.nextLong();
    }

    for (int i = 0; i < m; i++) {
      c[i][0] = sc.nextLong();
      c[i][1] = sc.nextLong();
    }

    for (int i = 0; i < n; i++) {
      long min = Integer.MAX_VALUE;
      int index = 0;
      for (int j = 0; j < m; j++) {
        if (min > Math.abs(a[i][0] - c[j][0]) + Math.abs(a[i][1] - c[j][1])) {
          min = Math.abs(a[i][0] - c[j][0]) + Math.abs(a[i][1] - c[j][1]);
          index = j + 1;
        }
      }
      System.out.println(index);
    }

  }
}