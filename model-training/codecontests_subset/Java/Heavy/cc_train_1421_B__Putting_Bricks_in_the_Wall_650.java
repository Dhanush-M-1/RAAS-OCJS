import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class B {
  int USE_FILE = 1;
  int HAS_TESTCASES = 1;
  String INPUT = "1 2 6 7";
  void solve(int caseNr) {
    int n = in.nextInt();
    char[][] grid = new char[n][];
    for (int i = 0; i < n; i++) {
      grid[i] = in.next().toCharArray();
    }
    int s1 = grid[1][0] - '0';
    int s2 = grid[0][1] - '0';
    int f1 = grid[n - 1][n - 2] - '0';
    int f2 = grid[n - 2][n - 1] - '0';
    String s1_cell = "2 1";
    String s2_cell = "1 2";
    String f1_cell = (n) + " " + (n - 1);
    String f2_cell = (n - 1) + " " + (n);
    int count = 0;
    if (s1 == 0 && s2 == 0) {
      if (f1 == 0)
        count++;
      if (f2 == 0)
        count++;
      System.out.println(count);
      if (f1 == 0)
        System.out.println(f1_cell);
      if (f2 == 0)
        System.out.println(f2_cell);
      return;
    }
    if (s1 == 1 && s2 == 1) {
      if (f1 == 1)
        count++;
      if (f2 == 1)
        count++;
      System.out.println(count);
      if (f1 == 1)
        System.out.println(f1_cell);
      if (f2 == 1)
        System.out.println(f2_cell);
      return;
    }
    if (f1 == 0 && f2 == 0) {
      if (s1 == 0)
        count++;
      if (s2 == 0)
        count++;
      System.out.println(count);
      if (s1 == 0)
        System.out.println(s1_cell);
      if (s2 == 0)
        System.out.println(s2_cell);
      return;
    }
    if (f1 == 1 && f2 == 1) {
      if (s1 == 1)
        count++;
      if (s2 == 1)
        count++;
      System.out.println(count);
      if (s1 == 1)
        System.out.println(s1_cell);
      if (s2 == 1)
        System.out.println(s2_cell);
      return;
    }
    System.out.println(2);
    if (s1 == 1)
      System.out.println(s1_cell);
    if (s2 == 1)
      System.out.println(s2_cell);
    if (f1 == 0)
      System.out.println(f1_cell);
    if (f2 == 0)
      System.out.println(f2_cell);
  }
  private int inf = Integer.MAX_VALUE;
  private int MOD = (int) 1e9 + 7;
  static boolean LOCAL = java.lang.System.getProperty("ONLINE_JUDGE") == null;
  static Scanner in;
  static PrintWriter output_writer = new PrintWriter(java.lang.System.out);
  static class System {
    static PrintWriter out = null;
  }
  void setup() throws Exception {
    System.out = output_writer;
    if (LOCAL && USE_FILE == 0) {
      java.lang.System.setIn(new ByteArrayInputStream(INPUT.getBytes()));
      in = new Scanner(java.lang.System.in);
    }
    if (LOCAL && USE_FILE > 0) {
      String filename = String.format("in/cf%d.txt", USE_FILE);
      File inputFile = new File(filename);
      in = new Scanner(inputFile);
      System.out.printf("[%s]\n", filename);
    }
    if (!LOCAL) {
      in = new Scanner(java.lang.System.in);
    }
    long startTime = java.lang.System.currentTimeMillis();
    int t = HAS_TESTCASES > 0 ? in.nextInt() : 1;
    for (int i = 1; i <= t; i++) {
      solve(i);
    }
    in.close();
    if (LOCAL) {
      System.out.printf("[%dms]\n", java.lang.System.currentTimeMillis() - startTime);
    }
    output_writer.flush();
  }
  public static void main(String[] args) throws Exception {
    new B().setup();
  }
}
