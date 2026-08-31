import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskB solver = new TaskB();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskB {

    public String sortString(String inputString) {
      char tempArray[] = inputString.toCharArray();
      Arrays.sort(tempArray);
      return new String(tempArray);
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int count = in.nextInt();
      String s = in.next();
      Map<String, Integer> map = new HashMap<String, Integer>();
      int maxCount = 0;
      String res = "";
      for (int i = 0; i < count - 1; i++) {
        String curr = String.valueOf(s.charAt(i) + "" + s.charAt(i + 1));
        String sorted = sortString(curr);
        int c = 0;
        if (map.containsKey(sorted)) {
          c = map.get(sorted);
        }
        map.put(sorted, c + 1);
        int currCount = map.get(sorted);
        if (currCount > maxCount) {
          maxCount = currCount;
          res = curr;
        }
      }
      out.println(res);
    }

  }
}

