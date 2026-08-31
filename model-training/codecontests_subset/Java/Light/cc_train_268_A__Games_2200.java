import java.io.*;
import java.util.*;

public class Games {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(f.readLine());
    int[][] kits = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      kits[i][0] = Integer.parseInt(st.nextToken());
      kits[i][1] = Integer.parseInt(st.nextToken());
    } 
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (kits[i][0] == kits[j][1])
          count++;
      }
    } 
    System.out.println(count);
  }
}