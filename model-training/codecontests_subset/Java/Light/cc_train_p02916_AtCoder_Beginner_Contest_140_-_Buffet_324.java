import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    int[] C = new int[N - 1];
    for (int i = 0; i < N; i++) A[i] = scanner.nextInt() - 1;
    for (int i = 0; i < N; i++) B[i] = scanner.nextInt();
    for (int i = 0; i < N - 1; i++) C[i] = scanner.nextInt();

    int score = 0;
    int last = N;
    for (int i = 0; i < N; i++) {
      score += B[A[i]];
      if (last == A[i] - 1) score += C[last];
      last = A[i];
    }
    System.out.println(score);
  }
}
