import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < N; i++) {
      p[i] = sc.nextInt();
    }
    
    int ans = 0;
    for (int i = 0; i < N-1; i++) {
      if (p[i] == i+1) {
        int tmp = p[i];
        p[i] = p[i+1];
        p[i+1] = tmp;
        ans++;
      }
    }
    if (p[N-1] == N) {
        int tmp = p[N-1];
        p[N-1] = p[N-2];
        p[N-2] = tmp;
        ans++;
    }
    
    System.out.println(ans);
  }
}