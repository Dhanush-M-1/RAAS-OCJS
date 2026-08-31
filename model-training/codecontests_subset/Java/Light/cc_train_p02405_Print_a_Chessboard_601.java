import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (a == 0 && b == 0) break;
      else {
        for (int i = 0; i < a; i++) {
          for (int j = 0; j < b; j++) {
            if ((j + (i % 2)) % 2 == 0)System.out.printf("#");
            else System.out.printf(".");
          }
          System.out.printf("\n");
        }
      }
      System.out.printf("\n");
    }
  }
}

