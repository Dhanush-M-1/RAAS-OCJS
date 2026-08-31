import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N+1];
    int[] C = new int[N+1];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    for (int i = 1; i <= N; i++) {
      B[i] = sc.nextInt();
    }
    for (int i = 1; i <= N-1; i++) {
      C[i] = sc.nextInt();
    }
    
    int ans = 0;
    int prev = -1;
    for (int i = 0; i < N; i++) {
      ans += B[A[i]];
      if (prev+1 == A[i]) {
        ans += C[prev];
      }
      prev = A[i];
    }
    
    System.out.println(ans);
  }
}