import java.util.*;
import java.io.*;

public class C {

  static char[] s;

  static int[] compute() {
    int diff = 0;
    int hashCnt = 0;
    int lastPos = -1;
    for (int i=0; i<s.length; i++) {
      char c = s[i];
      if (c == '(') {
        diff++;
      } else {
        diff--;
      }
      if (c == '#') {
        hashCnt++;
        lastPos = i;
      }
      if (diff < 0) { 
        return new int[]{-1};
      }
    }
    // Construct and validate result
    int finalHash = diff+1;
    int[] result = new int[hashCnt];
    diff = 0;
    hashCnt = 0;
    for (int i=0; i<s.length; i++) {
      char c = s[i];
      if (c == '(') {
        diff++;
      } else if (c == ')') {
        diff--;
      } else if (i != lastPos) {
        result[hashCnt++] = 1;
        diff--;
      } else {
        diff = diff - finalHash;
        result[hashCnt++] = finalHash;
      }
      if (diff < 0) { 
        return new int[]{-1};
      } 
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    s = input.toCharArray();
    int[] result = compute();
    for (int i:result) {
      System.out.println(i);
    }
  }
}
