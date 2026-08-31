import java.util.*;

class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      if (n == 0) {
        break;
      }
      int[] as = new int[n];
      for (int ii = 0; ii < n; ii++) {
        as[ii] = scanner.nextInt();
      }
      int count = 0;
      int end = n;
      while (end != 0) {
        for (int ii = 0; ii < end - 1; ii++) {
          if (as[ii] > as[ii + 1]) {
            as[ii] = as[ii] + as[ii + 1];
            as[ii + 1] = as[ii] - as[ii + 1];
            as[ii] = as[ii] - as[ii + 1];
            count++;
          }
        }
        end--;
      }
      System.out.println(count);
    }
  }
}