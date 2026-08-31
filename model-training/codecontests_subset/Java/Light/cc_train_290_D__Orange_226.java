import java.io.*;
import java.util.*;

public class P290D {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int n = in.nextInt();
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'a') {
        if (c - 'a' + 1 <= n) {
          ans += Character.toUpperCase(c);
        } else {
          ans += c;
        }
      } else {
	if (c - 'A' + 1 <= n) {
	  ans += c;
	} else {
	  ans += Character.toLowerCase(c);
	}
      }
    }
    System.out.println(ans);
  }
}
