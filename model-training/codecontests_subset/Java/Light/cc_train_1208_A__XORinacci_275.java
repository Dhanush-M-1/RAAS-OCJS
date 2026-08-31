import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while(0 < t) {

      int a = sc.nextInt();
      int b = sc.nextInt();
      int n = sc.nextInt();

      switch(n % 3) {
        case 0:
          System.out.println(a);
        break;
        case 1:
          System.out.println(b);
        break;
        default:
          System.out.println(a ^ b);
      }

      t--;

    }

    sc.close();

  }

}