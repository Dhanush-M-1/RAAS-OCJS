import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int[] arr = { a, b, c };
    Arrays.sort(arr);
    if (arr[0] + arr[1] == arr[2]) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

}
