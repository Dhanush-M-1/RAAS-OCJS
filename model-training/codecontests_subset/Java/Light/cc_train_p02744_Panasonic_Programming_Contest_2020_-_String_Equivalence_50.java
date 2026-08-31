import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<String> list = new ArrayList<>();
    helper(n, 'a', list, "");
    for (String str: list) System.out.println(str);
  }
  public static void helper(int n, int maxChar, ArrayList<String> list, String str) {
    if (n == 0) {
      list.add(str);
      return;
    }
    for (char c = 'a'; c <= maxChar; c++) {
      helper(n - 1, Math.max(maxChar, c + 1) , list, str + c);
    }
  }
}
