import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    // どれかが残り二つの合計値になっていたらYes
    if(a == b + c || b == c + a || c == a + b) {
      System.out.println("Yes");
    // さもなくばNo
    } else {
      System.out.println("No");
    }
  }
}
