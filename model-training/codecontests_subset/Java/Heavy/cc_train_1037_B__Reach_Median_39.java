import java.util.Arrays;
import java.util.Scanner;

public class Main1037B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int s = scan.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = scan.nextInt();
    }
    scan.close();
    System.out.println(solve2(array, s));
  }

  private static long solve2(int[] array, int required) {
    int[] small = new int[array.length];
    int[] big = new int[array.length];
    int si = 0;
    int bi = 0;
    for (int num : array) {
      if (num < required)
        small[si++] = num;
      else if (num > required) {
        big[bi++] = num;
      }
    }
    if (si == bi)
      return 0;// median is already ==required
    if (si > array.length / 2) {
      // sort small
      int[] smallSorted = new int[si];
      System.arraycopy(small, 0, smallSorted, 0, si);
      Arrays.sort(smallSorted);
      long op = 0;
      for (int i = si - 1; i >= array.length / 2; i--) {
        op = op + (long) (required - smallSorted[i]);
      }
      return op;
    } else if (bi > array.length / 2) {
      // sort big
      int[] bigSorted = new int[bi];
      System.arraycopy(big, 0, bigSorted, 0, bi);
      Arrays.sort(bigSorted);
      long op = 0;
      for (int i = 0; i < (bi - array.length / 2); i++) {
        op = op + (long) (bigSorted[i] - required);
      }
      return op;
    }
    return 0;
  }

}
