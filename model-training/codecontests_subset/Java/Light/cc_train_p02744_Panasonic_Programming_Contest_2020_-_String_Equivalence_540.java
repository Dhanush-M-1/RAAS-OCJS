import java.util.*;
import java.math.*;
 
public class Main {
  private static int n;
  private static List<String> res = new LinkedList<String>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dfs(new StringBuffer(), 0);
    Collections.sort(res, new Comparator<String> () {
      public int compare(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for(int i = 0; i < len; ++i) {
          if(a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
        }
        return a.length() - b.length();
      }
    });
    for(String s : res) {
      System.out.println(s);
    }
  }
  
  private static void dfs(StringBuffer cur, int used) {
    if(cur.length() >= n) {
      res.add(cur.toString());
      return;
    }
    for(int i = 0; i <= Math.min(cur.length(), used); ++i) {
      cur.append((char)('a' + i));
      int next = used;
      if(i >= used) next = i + 1;
      dfs(cur, next);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}
