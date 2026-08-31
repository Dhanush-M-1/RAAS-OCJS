import java.util.*;

public class Solution {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int a = sc.nextInt();
    int b = sc.nextInt();
    int dist = Math.abs(a - b) / 2;
    int steps = 1;
    int res =0 ;
    while (dist > 0) {
      dist--;
      res += 2 * steps;
      steps += 1;
    }
    if (Math.abs(a - b ) % 2 != 0) {
      res += steps;
    }
    System.out.println(res);
  }

}