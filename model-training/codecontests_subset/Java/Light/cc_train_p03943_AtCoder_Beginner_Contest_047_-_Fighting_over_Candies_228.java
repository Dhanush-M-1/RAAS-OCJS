import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    
    // どれかが残りの二つの合計になっていたらYes
    if(a == b + c || b == a + c || c == a + b) {
      System.out.println("Yes");
    // さもなくば、No
    } else {
      System.out.println("No");
    }
  }
}
