import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int brokenStair;
    int[] stair = new int[n];
    if(n == 1) {
      System.out.println(1);
    } else {
      Arrays.fill(stair, -1);
      stair[n-1] = 1;
      stair[n-2] = 1;
      for(int i = 0; i < m; i++) {
        brokenStair = Integer.parseInt(sc.next());
        stair[brokenStair-1] = 0;
      }
      for(int i = n-3; i >= 0; i--) {
        if(stair[i] == 0) continue;
        stair[i] = (stair[i+1] + stair[i+2]) % 1000000007;
      }
      int answer = (stair[0] + stair[1]) % 1000000007;
      System.out.println(answer);
    }
  }
}
