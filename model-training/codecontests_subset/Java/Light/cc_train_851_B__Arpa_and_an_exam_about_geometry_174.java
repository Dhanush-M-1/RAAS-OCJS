import java.util.*;
import java.io.*;
public class B {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    long ax = in.nextInt();
    long ay = in.nextInt();
    long bx = in.nextInt();
    long by = in.nextInt();
    long cx = in.nextInt();
    long cy = in.nextInt();
    if ((bx-ax)*(bx-ax) + (by-ay)*(by-ay) == (cx-bx)*(cx-bx) + (cy-by)*(cy-by) && !((bx - ax == cx - bx) && (by - ay) == (cy - by)))
      System.out.println("Yes");
    else
      System.out.println("No");
    in.close();
  }
}