import java.util.*;
import static java.lang.System.*;

class Main {
  public static final int MOD = 1000000007;
  public static final int INF = 1000000000;
  public static void main(String[] args) {
    Scanner sc = new Scanner(in);
    int N = sc.nextInt();
    Integer F[][] = new Integer[N][10];
    Integer P[][] = new Integer[N][11];
    for(int i=0; i<N; i++){
      for(int j=0; j<10; j++){
        F[i][j] = sc.nextInt();
      }
    }
    for(int i=0; i<N; i++){
      for(int j=0; j<11; j++){
        P[i][j] = sc.nextInt();
      }
    }
    int ans = -INF;
    for(int i=1; i<(1<<10); i++){
      int tmp = 0;
      for(int k=0; k<N; k++){
        int count = 0;
        for(int j=0; j<10; j++){
          count += F[k][j] & (i>>j & 1);
        }
        tmp += P[k][count];
      }
      ans = Math.max(ans, tmp);
    }
    out.println(ans);
  }

  public static int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a%b);
  }
}