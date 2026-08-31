import java.io.PrintWriter;
import java.util.Scanner;

public class B {
  private char[][] map;
  private int[] DI = new int[]{0, 1, 1, -1};
  private int[] DJ = new int[]{1, 0, 1, 1};

  private boolean win(int i, int j, int dir) {
    int cnt = 0;

    for (int x = 0; x < 3; x++) {
      int ix = i + x * DI[dir];
      int jx = j + x * DJ[dir];
      if (ix >= 4 || jx >= 4 || ix < 0 || jx < 0)
        return false;
      if (map[ix][jx] == 'o')
        return false;
      if (map[ix][jx] == 'x') cnt++;
    }
    return cnt == 2;
  }

  private boolean solve() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        for (int dir = 0; dir < 4; dir++) {
          if (win(i, j, dir))
            return true;

        }
      }
    }
    return false;
  }

  private void solve(Scanner in, PrintWriter out) {
    map = new char[4][];
    for (int i = 0; i < 4; i++) {
      map[i] = in.next().toCharArray();
    }
    if (solve())
      out.println("YES");
    else
      out.println("NO");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new B().solve(in, out);
    in.close();
    out.close();
  }
}
