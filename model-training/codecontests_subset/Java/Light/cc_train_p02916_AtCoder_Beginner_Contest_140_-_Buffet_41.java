import java.util.Scanner;

public class Main {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A[] = new int[N];
    int B[] = new int[N];
    int C[] = new int[N - 1];
    int sum = 0;

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      B[i] = sc.nextInt();
    }

    for (int i = 0; i < N - 1; i++) {
      C[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      int num = A[i];
      sum += B[num - 1];

      if (i != 0 && A[i] - A[i - 1] == 1) {
        sum += C[A[i - 1] - 1];
      }
    }

    System.out.println(sum);

    sc.close();
  }
}
