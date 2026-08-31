import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

  // 5
  // 1 5 7 8 123
  // 1 5 7 123 -1
  // 1 5 7 -1 -1

  Test() {
    Scanner in = new Scanner(System.in);
    int totalErrors = in.nextInt();
    int[][] errors = new int[3][totalErrors];
    for (int line = 0; line < 3; line++) {
      for (int index = 0; index < totalErrors - line; index++) {
        errors[line][index] = in.nextInt();
      }
      if (line == 1) {
        errors[line][totalErrors - 1] = Integer.MAX_VALUE;
      } else if (line == 2) {
        errors[line][totalErrors - 1] = Integer.MAX_VALUE;
        errors[line][totalErrors - 2] = Integer.MAX_VALUE;
      }
      Arrays.sort(errors[line]);
    }
    for (int line = 0; line < 2; line++) {
      for (int index = 0; index < totalErrors - line; index++) {
        if (errors[line][index] != errors[line + 1][index]) {
          out.println(errors[line][index]);
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    new Test();
  }
}