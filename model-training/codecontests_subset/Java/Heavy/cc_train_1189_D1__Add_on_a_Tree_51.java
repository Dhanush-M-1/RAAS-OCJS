import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/contest/1189/problem/D1

// 只要有一个顶点的度为 2，那么就一定有无法满足的情况，输出 NO

public class Main {
  static List<List<Integer>> node = new ArrayList<List<Integer>>();
  
  static void addList(int from, int to) {
    node.get(from).add(to);
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for (int i = 0; i < n+1; i++) {
      node.add(new LinkedList<Integer>());
    }
    for (int i = 0; i < n-1; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      addList(a, b);
      addList(b, a);
    }
    scanner.close();
    // 点的标号是从 1 开始的
    for (int i = 1; i < n+1; i++) {
      if (node.get(i).size() == 2) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
