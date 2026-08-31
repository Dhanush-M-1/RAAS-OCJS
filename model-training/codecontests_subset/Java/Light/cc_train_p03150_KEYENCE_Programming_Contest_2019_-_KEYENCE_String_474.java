import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String S = scanner.next();
    for (int i = 0; i < S.length(); i++) {
      for (int j = i; j <= S.length(); j++) {
        String T = S.substring(0, i) + S.substring(j);
        if (T.equals("keyence")) {
          System.out.println("YES");
          return;
        }
      }
    }
    System.out.println("NO");
  }
}
