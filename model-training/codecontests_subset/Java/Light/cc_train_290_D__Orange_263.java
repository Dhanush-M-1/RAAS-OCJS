import java.io.*;
import java.math.*;
import java.util.*;

public class d {
  public static void main(String[] args) throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String v27 = in.readLine();
    int v16 = Integer.parseInt(in.readLine());
    v27 = v27.toLowerCase();
    String v4 = "";
    for (int v26 = 0; v26 < v27.length(); v26++) {
      char v19 = v27.charAt(v26);
      if (v19 < v16 + 97) {
        v4 += (char)(v19 - 'a' + 'A');
      } else {
        v4 += v19;
      }
    }
    System.out.println(v4);
  }
}
