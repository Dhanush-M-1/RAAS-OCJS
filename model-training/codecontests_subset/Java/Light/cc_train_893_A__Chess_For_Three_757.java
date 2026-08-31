import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    boolean flag = true;
    int x = 1, y = 2;
    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      if (a == x || a == y) {
        y = 6 - x - y;
        x = a;
      }
      else flag = false;
    }
    if (flag) System.out.println("YES");
    else System.out.println("NO");
  }
}