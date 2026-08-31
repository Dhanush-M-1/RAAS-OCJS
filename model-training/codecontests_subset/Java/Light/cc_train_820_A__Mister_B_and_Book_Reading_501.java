import java.util.*;

public final class Solution1{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    int v0 = sc.nextInt();
    int v1 = sc.nextInt();
    int a = sc.nextInt();
    int l = sc.nextInt();
    int days = 0;
    int x = 0;
    int y = 0;
      while (c > y) {
        x = (v0) + days*(a);
        if (x < v1) {
          y += x;
      //    System.out.println((x)+" : "+y);
        } else {
          y += v1;
      //    System.out.println(v1+" : "+y);
        }
        if (days > 0) {
          y -= l;
        }

        days++;
      }

    // }
System.out.println(days);
  }
}
