import java.util.Scanner;

public class CF526A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    String str = sc.nextLine();
    int n = str.length();
    boolean ok = false;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= n / 4; j++) {
        if (i + 4 * j < n && str.charAt(i) == '*' && str.charAt(i + j) == '*'
            && str.charAt(i + 2 * j) == '*' && str.charAt(i + 3 * j) == '*'
            && str.charAt(i + 4 * j) == '*') {
          ok = true;
        }
      }
    }
    System.out.println(ok ? "yes" : "no");
    sc.close();
  }
}
