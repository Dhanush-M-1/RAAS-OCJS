import java.awt.Point;
import java.util.*;

public class Roads2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    ArrayList<ArrayList<Integer>> forest = new ArrayList<ArrayList<Integer>>();
    ArrayList<Point> extra = new ArrayList<Point>();
    int[] nodeSet = new int[n];
    for(int i = 0; i < n; i++) {
      ArrayList<Integer> s = new ArrayList<Integer>();
      s.add(i);
      forest.add(s);
      nodeSet[i] = i;
    }
    for(int i = 1; i < n; i++) {
      int a = scan.nextInt() - 1;
      int b = scan.nextInt() - 1;
      if(nodeSet[a] != nodeSet[b]) {
        forest.get(nodeSet[a]).addAll(forest.get(nodeSet[b]));
        b = nodeSet[b];
        for(int x : forest.get(b)) {
          nodeSet[x] = nodeSet[a];
        }
        forest.set(b, null);
      } else {
        extra.add(new Point(a, b));
      }
    }
    System.out.println(extra.size());
    for(int i = 0; i < extra.size(); i++) {
      Point e = extra.get(i);
      System.out.print((e.x+1) + " " + (e.y+1) + " ");
      int x = 0+0; while(forest.get(x) == null) x++;
      int y = x+1; while(forest.get(y) == null) y++;
      System.out.print((forest.get(x).get(0)+1) + " ");
      System.out.println((forest.get(y).get(0)+1));
      forest.get(x).addAll(forest.get(y));
      forest.set(y, null);
    }
  }
}
