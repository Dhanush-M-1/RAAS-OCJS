import java.io.*;
import java.util.*;
public class Main
{
  public static void main (String args[]) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();


    List<String> out = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(line, "+");

    while (st.hasMoreTokens()) {
      out.add(st.nextToken());
    }

    Collections.sort(out);
    int x = out.size();

    for (String s: out) {
      System.out.print(s);
      if (x!=1) {
        System.out.print("+");
      }
      x--;
    }
  }
}
