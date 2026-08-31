import java.io.*;
import java.util.*;
import java.math.*;

public class B {

  public PrintWriter run() {
    int t = sc.nextInt();
    int m = sc.nextInt();
    int [] mem = new int [m];
    int id = 1;

    for (int ii = 0; ii < t; ii++) {
      String cmd = sc.next();
      if (cmd.equals("alloc")) {
        int size = sc.nextInt();

        int a;
        boolean ok = false;
        for (a = 0; a < m - size + 1; a++) {
          if (mem[a] == 0) {
            ok = true;
            for (int l = a + 1; l < a + size; l++) {
              if (mem[l] != 0) { ok = false; break; }
            }

            if (ok) { break; }
          }
        }

        if (!ok) {
          pw.println("NULL");
          continue;
        }
        for (int aa = a; aa < a + size; aa++) { mem[aa] = id; }

        pw.println(id);

        id++;
      } else if (cmd.equals("erase")) {
        int eid = sc.nextInt();

        boolean ok = false;
        if (eid > 0) {
          for (int a = 0; a < m; a++) {
            if (mem[a] == eid) {
              ok = true;
              mem[a] = 0;
            }
          }
        }

        if (!ok) {
          pw.println("ILLEGAL_ERASE_ARGUMENT");
        }
      } else { //defrag
        int na;
        for (na = 0; na < m; na++) {
          if (mem[na] == 0) { break; }
        }
        
        for (int a = na + 1; a < m; a++) {
          if (mem[a] != 0) {
            mem[na] = mem[a];
            na++;
            mem[a] = 0;
          }
        }
      }
    }

    return pw;
  }

  private Scanner sc = new Scanner(new BufferedInputStream(System.in));
  private PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

  public static void main(String... args) throws Exception {
    new B().run().close();
  }
}
