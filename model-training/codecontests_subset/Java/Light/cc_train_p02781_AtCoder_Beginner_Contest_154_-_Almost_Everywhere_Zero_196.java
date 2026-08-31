import java.util.*;
import java.math.*;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int k = sc.nextInt();
    int n = s.length();
    char[] a = s.toCharArray();
    int[][][] f = new int[n + 1][k + 1][2];
    f[0][0][0] = 1;
    for(int i = 0; i < n; ++i) {
      for(int j = 0; j < k + 1; ++j) {
        for(int m = 0; m < 2; ++m) {
          int cur = a[i] - '0';
          for(int nl = 0; nl < 10; ++nl) {
            int ni = i, nj = j, nm = m;
            if(nl != 0) ++nj;
            if(nj > k) continue;
            if(m == 0) {
              if(nl > cur) continue;
              if(nl < cur) nm = 1;
            }
            f[ni + 1][nj][nm] += f[i][j][m];
          }
        }
      }
    }
    System.out.println(f[n][k][1] + f[n][k][0]);
  }
}
