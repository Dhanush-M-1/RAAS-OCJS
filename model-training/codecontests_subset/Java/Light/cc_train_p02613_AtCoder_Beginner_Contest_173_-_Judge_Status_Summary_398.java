import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] c = new String[n];
    String[] results = { "AC", "WA", "TLE", "RE" };
    int[] resultCnt = { 0, 0, 0, 0 };
    for (int cnt = 0; cnt < n; cnt++) {
      c[cnt] = sc.next();
      for (int cntj = 0; cntj < 4; cntj++) {
        if (c[cnt].equals(results[cntj])) {
          resultCnt[cntj] += 1;
        }
      }
    }
    for (int cnt = 0; cnt < 4; cnt++) {
      System.out.println(results[cnt] + " x " + resultCnt[cnt]);
    }
    sc.close();
  }
}