/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      String[] s = br.readLine().split(" ");
      long n = Integer.parseInt(s[0]);
      long l = Long.parseLong(s[1]);
      long r = Long.parseLong(s[2]);
      
      if (l==r && l==n*(n-1)+1) {
        sb.append("1\n");
        continue;
      }
      int section = 1;
      long end = 2*(n-section);
      while (l>end) {
        section++;
        end += 2*(n-section);
      }
      long[] ends = new long[(int)n];
      ends[0] = 0;
      for (int i=1; i<n; i++) {
        ends[i] = ends[i-1] + 2*(n-i);
      }
      long upper = r;
      if (r==n*(n-1)+1) {
        upper = r-1;
      }
      for (long i=l; i<=upper; i++) {
        if (i!=l)
          sb.append(" ");
        if (i%2==1) {
          sb.append(section);
        } else {
          long offset = i-ends[section-1];
          sb.append(section + (offset/2));
        }
        if (i==ends[section])
          section++;
      }
      if (r==n*(n-1)+1) {
        sb.append(" 1");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
