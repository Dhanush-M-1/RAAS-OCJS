import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    long[][] A = new long[N][2];
    long[][] C = new long[M][2];
    for (int i = 0; i < N; i++) A[i] = new long[] {scanner.nextInt(), scanner.nextInt()};
    for (int i = 0; i < M; i++) C[i] = new long[] {scanner.nextInt(), scanner.nextInt()};

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      long min = 10_000_000_000L;
      int id = M + 1;
      for (int j = 0; j < M; j++) {
        long d = Math.abs(A[i][0] - C[j][0]) + Math.abs(A[i][1] - C[j][1]);
        if (d <= min) {
          if (d < min) id = j;
          else id = Math.min(id, j);
          min = d;
        }
      }
      sb.append(id + 1).append('\n');
    }
    System.out.print(sb.toString());
  }
}
