import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = 0, w = 0, t = 0, r = 0;

    for (int i = 0; i < n; i++) {
      String s = sc.next();
      switch (s) {
      case "AC":
        a++;
        break;

      case "WA":
        w++;
        break;

      case "TLE":
        t++;
        break;

      case "RE":
        r++;
        break;
      }
    }

    System.out.println("AC x " + a);
    System.out.println("WA x " + w);
    System.out.println("TLE x " + t);
    System.out.println("RE x " + r);

  }
}