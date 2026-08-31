import java.io.*;
import java.util.*;

public class CirculationAffection {
  private static int[][] solutions;
  private static int[] a;
  private static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(in.readLine());
    a = new int[N];
    char[] input = in.readLine().toCharArray();
    for(int i = 0; i < N; i++)
      a[i] = input[i] - 'a';
    solutions = new int[27][N+1];
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++) {
      String[] rq = in.readLine().split(" ");
      System.out.println(solve(Integer.parseInt(rq[0]), (rq[1].charAt(0) - 'a')));
    }
  }
  public static int solve(int m, int c) {
    int M = m;
    if(solutions[c][m] != 0)
      return solutions[c][m];
    else {
      int i = 0;
      int j = -1;
      int max = 1;
      while(i < N) {
        while(m >= 0 && j < N-1) {
          j++;
          m -= a[j] == c ? 0 : 1;
          if(j == N-1 && m >= 0) {
            m--;
            j++;
          }
        }
        m++;
        j--;
        if(j - i + 1 > max)
          max = j - i + 1;
        m += a[i] == c ? 0 : 1;
        i++;
      }
      solutions[c][M] = max;
      return max;
    }
  }
}