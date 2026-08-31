import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < N; i++) p[i] = scanner.nextInt() - 1;
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (p[i] == i) {
        count++;
        if (i < N - 1 && p[i + 1] == i + 1) i++;
      }
    }
    System.out.println(count);
  }
}
