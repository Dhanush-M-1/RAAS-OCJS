import java.util.Scanner;

/**
 * Created by shalin on 27/6/17.
 */
public class MisterB {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int c = in.nextInt();
    int v0 = in.nextInt();
    int v1 = in.nextInt();
    int a = in.nextInt();
    int l = in.nextInt();

    int days = getDays(c, v0, v1, a, l);
    System.out.println(days);
  }

  private static int getDays(int c, int v0, int v1, int a, int l) {
    int days = 0;
    int pageFinished = 0;

    while (pageFinished < c) {
      int velocity = Math.min(v0 + (days * a), v1);
      if (days > 0) {
        // we must read l pages from last time
        pageFinished -= l;
      }
      pageFinished += velocity;
      days++;
    }
    return days;
  }
}
