import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    boolean flag = false;
    if (S.matches("[a-z]*keyence")) {
      flag = true;
    }
    if (S.matches("k[a-z]*eyence")) {
      flag = true;
    }
    if (S.matches("ke[a-z]*yence")) {
     flag = true;
    }
    if (S.matches("key[a-z]*ence")) {
      flag = true;
    }
    if (S.matches("keye[a-z]*nce")) {
      flag = true;
    }
    if (S.matches("keyen[a-z]*ce")) {
      flag = true;
    }
    if (S.matches("keyenc[a-z]*e")) {
      flag = true;
    }
    if (S.matches("keyence[a-z]*")) {
      flag = true;
    }
    if (flag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}