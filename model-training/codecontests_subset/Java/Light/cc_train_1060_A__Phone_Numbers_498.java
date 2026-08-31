import java.util.*;

public class Solution {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int n = sc.nextInt();
    char[] s = sc.next().toCharArray();
    int cnt = 0;
    for (char c : s) if (c == '8') cnt++;
    System.out.println(Math.min(cnt, n / 11));
  }
}