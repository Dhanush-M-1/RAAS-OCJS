import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int ax = s.nextInt();
    int ay = s.nextInt();
    int bx = s.nextInt();
    int by = s.nextInt();
    int cx = s.nextInt();
    int cy = s.nextInt();

    if (bx == ax) {
      if (cx == ax) {
        System.out.println("NO");
        return;
      }
    }


    long v1 = (long)(by - ay) * (cx - bx);
    long v2 = (long)(cy - by) * (bx - ax);
    if (v1 == v2) {
      System.out.println("NO");
      return;
    }

    long dab = (long)(by - ay)*(by - ay) + (long)(bx - ax)*(bx - ax);
    long dbc = (long)(cy - by)*(cy - by) + (long)(cx - bx)*(cx - bx);
    System.out.println((dab == dbc) ? "YES" : "NO");
  }

}
