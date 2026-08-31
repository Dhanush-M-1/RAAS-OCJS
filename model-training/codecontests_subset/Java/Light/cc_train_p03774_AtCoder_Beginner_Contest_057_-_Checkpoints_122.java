import java.io.*;
import java.util.*;

class Main {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] coords = new int[n][2];
    int[][] checks = new int[m][2];
    for(int i = 0; i < n; i++) {
      coords[i][0] = sc.nextInt();
      coords[i][1] = sc.nextInt();
    }
    for(int i = 0; i < m; i++) {
      checks[i][0] = sc.nextInt();
      checks[i][1] = sc.nextInt();
    }
    for(int i = 0; i < n; i++) {
      int minDist = 1000000000;
      int minInd = -1;
      for(int j = 0; j < m; j++) {
        int dist = Math.abs(coords[i][0]-checks[j][0]) + Math.abs(coords[i][1]-checks[j][1]);
        if(minDist > dist) {
          minDist = dist;
          minInd = j;
        }
      }
      System.out.println(minInd+1);
    }
  }
}
