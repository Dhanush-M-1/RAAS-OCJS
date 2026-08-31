import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int ans = 0;
    int[] A = new int[N];
    for (int i = 0; i < N; i++) A[i] = sc.nextInt();
    for (int i = 0; i < N; i++) ans += sc.nextInt();
    int[] C = new int[N - 1];
    for (int i = 0; i < N - 1; i++) C[i] = sc.nextInt();
    for (int i = 1; i < N; i++) {
      if (A[i] == A[i - 1] + 1) ans += C[A[i - 1] - 1];
    }
    System.out.println(ans);
  }
}