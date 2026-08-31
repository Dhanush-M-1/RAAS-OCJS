import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < N; i++) p[i] = scanner.nextInt();

    int total = 0;
    for (int i = 0; i < N; i++) {
      if (p[i] == i + 1) total++;
    }
    for (int i = 1; i < N; i++) {
      if (p[i] == i + 1 && p[i - 1] == i) {
        total--;
        i++;
      }
    }
    System.out.println(total);
  }
}
