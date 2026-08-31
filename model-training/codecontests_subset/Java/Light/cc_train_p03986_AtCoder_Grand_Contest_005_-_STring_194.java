import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String X = sc.next();
    int s = 0;
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < X.length(); i++) {
      if (X.charAt(i) == 'S') {
        s++;
      } else {
        if (s > 0) {
          s--;
        } else {
          ans.append('T');
        }
      }
    }
    while (s-- > 0) {
      ans.append('S');
    }
    System.out.println(ans.length());
  }
}