import java.util.*;
import java.math.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }

    long f = 0;

    for (int i = 0; i < n; i++) {
      f += a[i]-1;
    }

    System.out.println(f);

  }

}
