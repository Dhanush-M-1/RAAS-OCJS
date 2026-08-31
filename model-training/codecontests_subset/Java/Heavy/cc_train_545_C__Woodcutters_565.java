import java.io.*;
import java.util.*;

public class C {

  static int N;
  static Tree[] tree;

  static int fellTrees() {
    int[] r = new int[N];
    int result = 0;

    // Always fell first tree to the left.
    result++;
    r[0] = tree[0].x;

    for (int i=1; i<N; i++) {
      // Try felling to the left.
      if (tree[i].x - tree[i].h > r[i-1]) {
        result++; 
        r[i] = tree[i].x;
      } else if (tree[i].x + tree[i].h < tree[i+1].x) {  // Try right.
        result++;
        r[i] = tree[i].x + tree[i].h;
      } else { // Cannot fell this tree.
        r[i] = tree[i].x;
      }
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    tree = new Tree[N+1];

    for (int i=0; i<N; i++) {
      String s = br.readLine();
      StringTokenizer tok = new StringTokenizer(s);
      int x = Integer.parseInt(tok.nextToken());
      int h = Integer.parseInt(tok.nextToken());
      tree[i] = new Tree(x, h);
    }
    tree[N] = new Tree(Integer.MAX_VALUE, 0);  // Dummy tree.
    System.out.println(fellTrees());
  }
}

class Tree {
  int x, h;

  public Tree(int x, int h) {
    this.x = x;
    this.h = h;
  }
}
