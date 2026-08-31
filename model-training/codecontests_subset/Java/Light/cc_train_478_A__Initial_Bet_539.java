import java.util.Scanner;

public class A {

  public static void main(String[] args) {
    Scanner inScanner = new Scanner(System.in);
    int count = 0;
    for (int i = 0; i < 5; i++) {
      count += inScanner.nextInt();
    }
    System.out.println(count > 0 && count % 5 == 0 ? count / 5 : -1);
  }
}
