import java.util.Scanner;

public class Main1043A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      long st = System.currentTimeMillis();
      int n = in.nextInt();
      int[] arr = new int[n];
      int max = 0;
      int a = 0;
      int b = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
        a += arr[i];
        max = max > arr[i] ? max : arr[i];
      }
      // System.out.println("a=" + a);
      // System.out.println("max=" + max);

      if (n == 1) {
        max = 2 * max + 1;
      } else {
        while (b <= a) {
          b = 0;
          for (int i = 0; i < n; i++) {
            b += (max - arr[i]);
          }
          if (b <= a) {
            max++;
          }
        }
      }
      // System.out.println("b=" + b);
      System.out.println(max);
      long en = System.currentTimeMillis();
      // System.out.println(en - st);

    }
    in.close();
  }
}
