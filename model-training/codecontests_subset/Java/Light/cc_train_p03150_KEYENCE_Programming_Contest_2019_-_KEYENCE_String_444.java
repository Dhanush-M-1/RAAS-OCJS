import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String key = "keyence";
    int i = 0;

    while (i < 7) {
      if (s.charAt(i) == key.charAt(i)) {
        i++;
      } else {
        break;
      }
    }

    int rest = 7 - i;

    while (rest > 0) {
      if (s.charAt(s.length() - rest) == key.charAt(key.length() - rest)) {
        rest--;
      } else {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");

  }
}