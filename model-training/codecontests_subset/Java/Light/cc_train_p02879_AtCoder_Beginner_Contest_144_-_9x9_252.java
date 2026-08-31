import java.util.*;

public class Main {
  public static void main(String... args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int B = scan.nextInt();
    System.out.println(1<=A && A<=9 && 1<=B && B<=9 ? A*B : -1);
    scan.close();
  }
}