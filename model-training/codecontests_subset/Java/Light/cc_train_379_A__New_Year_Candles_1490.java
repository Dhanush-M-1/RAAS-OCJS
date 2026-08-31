import java.util.Scanner;

public class newyearcandles {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int a = s.nextInt(), b = s.nextInt();

    int ans = a;
    while (a / b > 0) {
      ans += a / b;
      a  = (a / b) + a % b;
    }

    System.out.println(ans);
  }
}
