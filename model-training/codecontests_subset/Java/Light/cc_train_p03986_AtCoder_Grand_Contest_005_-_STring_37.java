import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char[] X = scanner.next().toCharArray();
    int res = X.length;
    int count = 0;
    for (char ch : X) {
      if (ch == 'S') count++;
      else if (count > 0) {
        res -= 2;
        count--;
      }
    }
    System.out.println(res);
  }
}
