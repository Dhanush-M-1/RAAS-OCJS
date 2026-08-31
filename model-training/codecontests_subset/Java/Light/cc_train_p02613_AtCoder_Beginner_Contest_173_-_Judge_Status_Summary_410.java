import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 入力を受け取る
    int N = sc.nextInt();
    int ac = 0;
    int wa = 0;
    int tle = 0;
    int re = 0;
    for (int i = 0; i < N; i++) {
      String S = sc.next();
      if (S.equals("AC")) {
        ac++;
      } else if (S.equals("WA")) {
        wa++;
      } else if (S.equals("TLE")) {
        tle++;
      } else {
        re++;
      }
    }
    System.out.println("AC x " + ac);
    System.out.println("WA x " + wa);
    System.out.println("TLE x " + tle);
    System.out.println("RE x " + re);
  }
}