import java.io.*;
import static java.lang.Character.*;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] s = br.readLine().toCharArray();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < s.length; i++)
      if (isUpperCase(s[i]))
        s[i] = toLowerCase(s[i]);
    for (int i = 0; i < s.length; i++)
      if (s[i] < n + 97)
        s[i] = toUpperCase(s[i]);
    System.out.println(s);
  }
}
