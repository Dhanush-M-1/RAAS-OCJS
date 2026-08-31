/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int nTests = Integer.parseInt(br.readLine());
    for (int t=0; t<nTests; t++) {
      String[] s = br.readLine().split(" ");
      long a = Long.parseLong(s[0]);
      long b = Long.parseLong(s[1]);
      long c = Long.parseLong(s[2]);
      long d = Long.parseLong(s[3]);
      if (a<b) {
        sb.append("No\n");
      } else {
        if (d<b) {
          sb.append("No\n");
        } else {
          d = d%b;
          if (d==0) {
            if (a%b>c) {
              sb.append("No\n");
            } else {
              sb.append("Yes\n");
            }
          } else {
            if (c+1>b-1) {
              sb.append("Yes\n");
            } else {
              d += b;
              long div = gcd(b,d);
              long badLo = (c+1);
              long badHi = b-1;
              if (badHi-badLo+1>=div) {
                sb.append("No\n");
              } else {
                long mBadLo = badLo%div;
                long mBadHi = badHi%div;
                if (mBadLo>mBadHi) {
                  mBadHi += div;
                }
                long mA = a%div;
                if (mA>=mBadLo && mA<=mBadHi) {
                  sb.append("No\n");
                } else {
                  sb.append("Yes\n");
                }
              }
            }
          }
        }
      }
    }
    System.out.print(sb);
  }
  static long gcd(long a, long b) {
    return (b==0 ? a : gcd(b, a%b));
  }
}
