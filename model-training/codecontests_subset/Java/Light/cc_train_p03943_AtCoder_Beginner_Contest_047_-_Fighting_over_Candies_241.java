import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    sc.close();

    int max = Math.max(a, Math.max(b, c));
    String result = 2 * max == a + b + c ? "Yes" : "No";
    System.out.println(result);
  }
}