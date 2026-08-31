import java.util.*;
import java.io.*;

public class sol {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static boolean floodfill(char[][] grid, int i, int j) {
    //everything must match char at i,j
    char start = grid[i][j];
    boolean[][] visited = new boolean[grid.length][grid.length];
    Stack<int[]> s = new Stack<>();
    visited[i][j] = true;
    s.push(new int[] {i,j});
    while(!s.isEmpty()) {
      int[] nextpoint = s.pop();
      int x = nextpoint[0];
      int y = nextpoint[1];
      if(x < grid.length - 1 && (grid[x + 1][y] == start || grid[x + 1][y] == 'S' || grid[x + 1][y] == 'F') && !visited[x + 1][y]) {
        s.push(new int[] {x + 1, y});
        visited[x + 1][y] = true;
      }
      if(x > 0 && (grid[x - 1][y] == start || grid[x - 1][y] == 'S' || grid[x - 1][y] == 'F') && !visited[x - 1][y]) {
        s.push(new int[] {x - 1, y});
        visited[x - 1][y] = true;
      }
      if(y > 0 && (grid[x][y - 1] == start || grid[x][y - 1] == 'S' || grid[x][y - 1] == 'F') && !visited[x][y - 1]) {
        s.push(new int[] {x, y - 1});
        visited[x][y - 1] = true;
      }
      if(y < grid.length - 1 && (grid[x][y + 1] == start || grid[x][y + 1] == 'S' || grid[x][y + 1] == 'F') && !visited[x][y + 1]) {
        s.push(new int[] {x, y + 1});
        visited[x][y + 1] = true;
      }
    }
    if(visited[0][0] && visited[grid.length - 1][grid.length - 1]) return true;
    return false;
  }
  public static boolean simSwitch(char[][] grid, int[] a, int[] b) {
    char oldA = grid[a[0]][a[1]];
    char oldB = grid[b[0]][b[1]];
    if(grid[a[0]][a[1]] == '1') grid[a[0]][a[1]] = '0';
    else grid[a[0]][a[1]] = '1';
    if(grid[b[0]][b[1]] == '1') grid[b[0]][b[1]] = '0';
    else grid[b[0]][b[1]] = '1';
    boolean f1 = floodfill(grid, 0, 1);
    boolean f2 = floodfill(grid, 1, 0);
    grid[a[0]][a[1]] = oldA;
    grid[b[0]][b[1]] = oldB;
    if(!f1 && !f2) return true;
    return false;
  }
  public static boolean simSwtich1(char[][] grid, int[] a) {
    char oldA = grid[a[0]][a[1]];
    if(grid[a[0]][a[1]] == '1') grid[a[0]][a[1]] = '0';
    else grid[a[0]][a[1]] = '1';
    boolean f1 = floodfill(grid, 0, 1);
    boolean f2 = floodfill(grid, 1, 0);
    grid[a[0]][a[1]] = oldA;
    if(!f1 && !f2) return true;
    return false;
  }
  public static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine());
    char[][] grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      char[] temp = br.readLine().toCharArray();
      for (int j = 0; j < n; j++) grid[i][j] = temp[j];
    }
    ArrayList<int[]> poss = new ArrayList<>();
    poss.add(new int[] {0,1});
    poss.add(new int[] {1,0});
    poss.add(new int[] {n - 1, n - 2});
    poss.add(new int[] {n - 2, n - 1});
    boolean init1 = floodfill(grid, 0, 1);
    boolean init2 = floodfill(grid, 1, 0);
    if(!init1 && !init2) {
      System.out.println(0);
      return;
    }
    for (int[] a : poss) {
      if(simSwtich1(grid, a)) {
        System.out.println(1);
        System.out.println((a[0] + 1) + " " + (a[1] + 1));
        return;
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = i + 1; j < 4; j++) {
        if(simSwitch(grid, poss.get(i), poss.get(j))) {
          System.out.println(2);
          System.out.println((poss.get(i)[0] + 1) + " " + (poss.get(i)[1] + 1));
          System.out.println((poss.get(j)[0] + 1) + " " + (poss.get(j)[1] + 1));
          return;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) solve();
  }
}
