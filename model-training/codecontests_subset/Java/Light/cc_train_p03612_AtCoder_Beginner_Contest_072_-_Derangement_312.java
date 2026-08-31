import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < N; i++) p[i] = scanner.nextInt();

    int c = 0;
    int res = 0;
    for (int i = 0; i < N; i++) {
      if (p[i] == i + 1) {
        c++;
      } else {
        res += (c + 1) / 2;
        c = 0;
      }
    }
    res += (c + 1) / 2;
    System.out.println(res);
  }
}
