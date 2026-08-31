import java.util.Scanner;

public class Thieves {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    char[] a = in.nextLine().toCharArray();
    for (int i = 0; i < n; i++) {
      char c = a[i];
      if (c == '.') continue;
      int t = 0;
      for (int j = 1; j < n; j++) {
        int count = 0;
        for (int k = i + j; k < n; k += j) {
          if (a[k] == c) {
            count++;
            t = Math.max(t, count);
          } else {
            break;
          }
        }
      }

      if (t >= 4) {
        System.out.println("yes");
        return;
      }
    }
    System.out.println("no");
  }
}
