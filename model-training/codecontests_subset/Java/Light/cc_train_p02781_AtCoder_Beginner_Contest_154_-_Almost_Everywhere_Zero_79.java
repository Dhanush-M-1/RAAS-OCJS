import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String N = scan.next();
    int K = scan.nextInt();
    scan.close();

    int[][] dp0 = new int[N.length()][4];
    int[][] dp1 = new int[N.length()][4];
    dp0[0][3] = 0;
    dp0[0][2] = 0;
    dp0[0][1] = N.charAt(0) - '0' - 1;
    dp0[0][0] = 1;
    dp1[0][3] = 0;
    dp1[0][2] = 0;
    dp1[0][1] = 1;
    dp1[0][0] = 0;

    for(int i=0; i<N.length()-1; i++) {
      if(N.charAt(i+1) - '0' == 0) {
        dp0[i+1][3] = dp0[i][2] * 9 + dp0[i][3];
        dp0[i+1][2] = dp0[i][1] * 9 + dp0[i][2];
        dp0[i+1][1] = dp0[i][0] * 9 + dp0[i][1];
        dp0[i+1][0] = dp0[i][0];
        dp1[i+1][3] = dp1[i][3];
        dp1[i+1][2] = dp1[i][2];
        dp1[i+1][1] = dp1[i][1];
        dp1[i+1][0] = dp1[i][0];
      }
      else {
        dp0[i+1][3] = dp0[i][2] * 9 + dp0[i][3] + dp1[i][2] * (N.charAt(i+1)-'0'-1) + dp1[i][3];
        dp0[i+1][2] = dp0[i][1] * 9 + dp0[i][2] + dp1[i][1] * (N.charAt(i+1)-'0'-1) + dp1[i][2];
        dp0[i+1][1] = dp0[i][0] * 9 + dp0[i][1] + dp1[i][0] * (N.charAt(i+1)-'0'-1) + dp1[i][1];
        dp0[i+1][0] = dp0[i][0] + dp1[i][0];
        dp1[i+1][3] = dp1[i][2];
        dp1[i+1][2] = dp1[i][1];
        dp1[i+1][1] = dp1[i][0];
        dp1[i+1][0] = dp1[i][0];
      }
    }

    System.out.println(dp0[N.length()-1][K] + dp1[N.length()-1][K]);
  }
}