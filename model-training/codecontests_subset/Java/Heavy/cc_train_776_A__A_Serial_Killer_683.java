// A serial killer - codeforces
// 

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next().toString();
    String b = sc.next().toString();
    sc.nextLine();
    int n = sc.nextInt();
    sc.nextLine();
    System.out.println(a + " " + b);
    for (int i = 0; i < n; i++) {
      String aa = sc.next().toString();
      String bb = sc.next().toString();
      sc.nextLine();
      if (a.equals(aa)) {
        // System.out.print(1);
        a = bb;
      } else if (a.equals(bb)) {
        // System.out.print(2);
        a = aa;
      } else if (b.equals(aa)) {
        // System.out.print(3);
        b = bb;
      } else {
        // System.out.print(4);
        b = aa;
      }
      System.out.println(a + " " + b);
    }

  }
}