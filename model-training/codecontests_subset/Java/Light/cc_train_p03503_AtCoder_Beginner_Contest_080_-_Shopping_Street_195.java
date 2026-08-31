import java.io.*;
import java.util.*;
 
 
public class Main implements Runnable {
 
  public static final int MOD = 1000000007;

  public void run() {
    BetterScanner scanner = new BetterScanner(System.in);

    int n = scanner.nextInt();
    int[][][] ff = new int[n][5][2];
    for (int i = 0 ; i < n ; i ++) {
      for (int j = 0 ; j < 5 ; j ++) {
        for (int k = 0 ; k < 2 ; k ++) {
          ff[i][j][k] = scanner.nextInt();
        }
      }
    }
    long[][] pp = new long[n][11];
    for (int i = 0 ; i < n ; i ++) {
      for (int j = 0 ; j <= 10 ; j ++) {
        pp[i][j] = scanner.nextLong();
      }
    }

    long max = Long.MIN_VALUE;
    for (int x = 1 ; x < 1024 ; x ++) {
      long score = 0;
      for (int i = 0 ; i < n ; i ++) {
        int count = 0;
        for (int j = 0 ; j < 5 ; j ++) {
          for (int k = 0 ; k < 2 ; k ++) {
            boolean open = (x & (1 << (j + k * 5))) != 0;
            if (open && ff[i][j][k] == 1) {
              count ++;
            }
          }
        }
        score += pp[i][count];
      }
      if (score > max) {
        max = score;
      }
    }
    
    System.out.println(max);
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.run();
  }

  public static class UnionFind {

    private int[] parents;
    private int[] ranks;

    public UnionFind(int max) {
      parents = new int[max];
      ranks = new int[max];
      for (int i = 0 ; i < max; i ++) {
        parents[i] = i;
      }
    }

    public int find(int i) {
      int parent = parents[i];
      if (i == parent) {
        return i;
      } else {
        parents[i] = find(parent);
        return parents[i];
      }
    }

    public void unite(int i, int j) {
      int iRoot = find(i);
      int jRoot = find(j);
      if (iRoot == jRoot) {
        return;
      } else {
        if (ranks[iRoot] > ranks[jRoot]) {
          parents[jRoot] = iRoot;
        } else if (ranks[jRoot] > ranks[iRoot]) {
          parents[iRoot] = jRoot;
        } else {
          parents[jRoot] = iRoot;
          ranks[iRoot] ++;
        }
      }
    }

    public boolean isConnected(int i, int j) {
      return find(i) == find(j);
    }

  }
 
  // scanner slightly faster than usual ones
  public static class BetterScanner {
 
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int pointer = 0;
    private int bufferLength = 0;
 
    public BetterScanner(InputStream stream) {
      this.stream = stream;
    }
 
    private boolean updateBuffer() {
      if (pointer >= bufferLength) {
        pointer = 0;
        try {
          bufferLength = stream.read(buffer);
        } catch (IOException exception) {
          exception.printStackTrace();
        }
        return bufferLength > 0;
      } else {
        return true;
      }
    }
 
    private int read() {
      if (updateBuffer()) {
        return buffer[pointer ++];
      } else {
        return -1;
      }
    }
 
    public boolean hasNext() {
      skipUnprintable();
      return updateBuffer();
    }
 
    private void skipUnprintable() { 
      while (updateBuffer() && !isPrintableChar(buffer[pointer])) {
        pointer ++;
      }
    }
 
    public String next() {
      if (hasNext()) {
        StringBuilder builder = new StringBuilder();
        int codePoint = read();
        while (isPrintableChar(codePoint)) {
          builder.appendCodePoint(codePoint);
          codePoint = read();
        }
        return builder.toString();
      } else {
        throw new NoSuchElementException();
      }
    }
 
    public long nextLong() {
      if (hasNext()) {
        long number = 0;
        boolean minus = false;
        int codePoint = read();
        if (codePoint == '-') {
          minus = true;
          codePoint = read();
        }
        if (codePoint >= '0' && codePoint <= '9') {
          while (true) {
            if (codePoint >= '0' && codePoint <= '9') {
              number *= 10;
              number += codePoint - '0';
            } else if (codePoint < 0 || !isPrintableChar(codePoint)) {
              return (minus) ? -number : number;
            } else {
              throw new NumberFormatException();
            }
            codePoint = read();
          }
        } else {
          throw new NumberFormatException();
        }
      } else {
        throw new NoSuchElementException();
      }
    }
 
    public int nextInt() {
      long number = nextLong();
      if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
        return (int)number;
      } else {
        throw new NumberFormatException();
      }
    }
 
    private boolean isPrintableChar(int codePoint) {
      return codePoint >= 33 && codePoint <= 126;
    }
 
  }
 
}