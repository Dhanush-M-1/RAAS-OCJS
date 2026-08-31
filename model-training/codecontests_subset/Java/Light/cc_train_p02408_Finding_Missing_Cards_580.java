import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int[][] card = { new int[13], new int[13], new int[13], new int[13] };
    char[] suit = { 'S', 'H', 'C', 'D' };

    for (int i = 0; i < n; i++) {
      String s = stdin.next();
      int j = stdin.nextInt() - 1;
      if (s.equals("S")) {
        card[0][j] = 1;
      } else if (s.equals("H")) {
        card[1][j] = 1;
      } else if (s.equals("C")) {
        card[2][j] = 1;
      } else {
        card[3][j] = 1;
      }
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {
        if (card[i][j] == 0) {
          System.out.printf("%s %d%n", suit[i], j + 1);
        }
      }
    }
  }

}