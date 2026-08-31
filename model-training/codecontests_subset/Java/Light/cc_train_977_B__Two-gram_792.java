import java.util.*;

public class Solution {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int n = sc.nextInt();
    String s = sc.next();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      map.put(s.substring(i, i + 2), map.getOrDefault(s.substring(i, i + 2), 0) + 1);
    }
    int max = 0;
    String res = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        res = entry.getKey();
      }
    }
    System.out.println(res);
  }

}