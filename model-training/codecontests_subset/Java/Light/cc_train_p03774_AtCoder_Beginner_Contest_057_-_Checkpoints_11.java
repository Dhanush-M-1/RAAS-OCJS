import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] c = new int[M];
    int[] d = new int[M];
    for (int i = 0; i < M; i++) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      int min = Integer.MAX_VALUE;
      int index = -1;
      for (int j = 0; j < M; j++) {
        int dist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
        if (dist < min) {
          min = dist;
          index = j;
        }
      }
      System.out.println(index + 1);
    }
  }
}