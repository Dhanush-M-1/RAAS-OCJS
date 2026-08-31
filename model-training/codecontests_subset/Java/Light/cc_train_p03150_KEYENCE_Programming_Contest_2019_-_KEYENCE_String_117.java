import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      String s = scanner.next();
      String[] patterns = new String[] {
        "k.*eyence",
        "ke.*yence",
        "key.*ence",
        "keye.*nce",
        "keyen.*ce",
        "keyenc.*e",
      };

      for (String pattern: patterns) {
        if (s.matches(pattern)) {
          System.out.println("YES");
          return;
        }
      }
      System.out.println("NO");
    } finally {
      scanner.close();
    }
  }
}
