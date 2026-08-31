import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    long sum = 0;
    for (int i = 0; i < N; i++) {
      int a = scanner.nextInt();
      sum += a - 1;
    }
    System.out.println(sum);
  }
}
