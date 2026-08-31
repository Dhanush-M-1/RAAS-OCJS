/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int n = Integer.parseInt(br.readLine());
    int[][] rowSums = new int[n][n];
    int[][] recSums = new int[n][n];
    int[][] map = new int[][]{
    {0,0,0,0},
    {0,0,0,1},
    {0,0,1,0},
    {0,0,1,1},
    {0,1,0,0},
    {0,1,0,1},
    {0,1,1,0},
    {0,1,1,1},
    {1,0,0,0},
    {1,0,0,1},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {987654321,987654321,987654321,987654321},
    {1,0,1,0},
    {1,0,1,1},
    {1,1,0,0},
    {1,1,0,1},
    {1,1,1,0},
    {1,1,1,1}
    };
    for (int i=0; i<n; i++) {
      char[] seq = br.readLine().toCharArray();
      int seqLen = seq.length;
      for (int j=0; j<seqLen; j++) {
        for (int k=0; k<4; k++) {
          if (j==0 && k==0) {
            rowSums[i][4*j+k] = map[seq[j]-'0'][k];
            if (i==0) {
              recSums[i][4*j+k] = rowSums[i][4*j+k];
            } else {
              recSums[i][4*j+k] = recSums[i-1][4*j+k] + rowSums[i][4*j+k];
            }
          } else {
            rowSums[i][4*j+k] = rowSums[i][4*j+k-1] + map[seq[j]-'0'][k];
            if (i==0) {
              recSums[i][4*j+k] = rowSums[i][4*j+k];
            } else {
              recSums[i][4*j+k] = recSums[i-1][4*j+k] + rowSums[i][4*j+k];
            }
          }
        }
      }
    }
    int limit = (int)Math.sqrt(n);
    HashSet<Integer> divs = new HashSet<>();
    for (int i=2; i<=limit; i++) {
      if (n%i==0) {
        divs.add(i);
        divs.add(n/i);
      }
    }
    divs.add(1);
    int[] arr = new int[divs.size()];
    int index = 0;
    for (int div:divs) {
      arr[index] = div;
      index++;
    }
    Arrays.sort(arr);
    for (int pos=0; pos<arr.length; pos++) {
      int div = arr[pos];
      int sz = n/div;
      int szSq = sz*sz;
      boolean goodSize = true;
      for (int i=0; i<div; i++) {
        for (int j=0; j<div; j++) {
          int blockSum = sum(recSums, i*sz, j*sz, sz);
          if (!(blockSum==0 || blockSum==szSq)) {
            goodSize = false;
            break;
          }
        }
        if (!goodSize)
          break;
      }
      if (goodSize) {
        System.out.println(sz);
        return;
      }
    }
    System.out.println(1);
  }
  static int sum(int[][] recSums, int r, int c, int sz) {
    if (r==0 && c==0) {
      return recSums[r+sz-1][c+sz-1];
    } else if (r==0) {
      return recSums[r+sz-1][c+sz-1] - recSums[r+sz-1][c-1];
    } else if (c==0) {
      return recSums[r+sz-1][c+sz-1] - recSums[r-1][c+sz-1];
    } else {
      return recSums[r+sz-1][c+sz-1] - recSums[r-1][c+sz-1] - recSums[r+sz-1][c-1] + recSums[r-1][c-1];
    }
  }
}
