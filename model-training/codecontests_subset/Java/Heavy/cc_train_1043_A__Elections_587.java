import java.util.*;
import java.io.*;

public final class Solution {
  public static int max(int a, int b) {
    return ((a > b) ? a : b);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = in.readLine();
    int n = Integer.parseInt(line);
    int ans = Integer.MIN_VALUE;
    String[] votesS = in.readLine().split(" ");
    int[] votes = new int[n];
    int sum = 0;
    for (int i = 0; i < votes.length; i++) {
      votes[i] = Integer.parseInt(votesS[i]);
      ans = max(ans, votes[i]);
      sum += votes[i];
    }
    ans = max(ans, ((2 * sum)/n + 1));
    System.out.println(ans);
  }
}
