import java.util.*;
 
public class Main {
  private static long ans = Long.MIN_VALUE;
  private static Integer[] open = new Integer[10];

  private static int N;
  private static int[][] F;
  private static int[][] P;

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    F = new int[N][10];
    P = new int[N][11];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 10; j++) {
        F[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 11; j++) {
        P[i][j] = sc.nextInt();
      }
    }

    dfs(0);
    System.out.println(ans);
  }

  private static void dfs(int i) {
    if (i == 10) {
      calc();
      return;
    }

    open[i] = 0;
    dfs(i + 1);
    open[i] = 1;
    dfs(i + 1);
  }

  private static void calc() {
    if (!Arrays.asList(open).contains(1)) return;
    long kouho = 0;
    for (int i = 0; i < N; i++) {
      int c = 0;
      for (int j = 0; j < 10; j++) {
        if (open[j] == 1 && open[j] == F[i][j]) c++; 
      }
      kouho += P[i][c];
    }
    ans = Math.max(ans, kouho);
  }

  //指定した値以上の先頭のインデックスを返す
  private static final int lowerBound(final int[] arr, final int value) {
    int low = 0;
    int high = arr.length;
    int mid;
    while (low < high) {
      mid = ((high - low) >>> 1) + low;   //(low+high)/2のオーバーフロー対策
      if (arr[mid] < value) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
 
  //指定した値より大きい先頭のインデックスを返す
  private static final int upperBound(final int[] arr, final int value) {
    int low = 0;
    int high = arr.length;
    int mid;
    while (low < high) {
      mid = ((high - low) >>> 1) + low;   //(low+high)/2のオーバーフロー対策
      if (arr[mid] <= value) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}