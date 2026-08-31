import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    boolean[] C = new boolean[N];
    int A = sc.nextInt();
    for (int i = 0; i < N - 1; i++)
      C[A - 1] = A + 1 == (A = sc.nextInt());
    int result = 0;
    for (int i = 0; i < N; i++)
      result += sc.nextInt();
    for (int i = 0; i < N - 1; i++)
      if (C[i])
        result += sc.nextInt();
      else
        sc.nextInt();
    System.out.println(result);
  }
}