import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Saul
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskD {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    String text = in.next(); int num = in.nextInt();
    StringBuilder ans = new StringBuilder();
    text = text.toLowerCase();
    for ( char c : text.toCharArray() ){
      if ( c < num + 97 ){
        ans.append((char)('A' + Character.toLowerCase(c) - 'a'));
      }else{
        ans.append(Character.toLowerCase(c));
      }
    }
    out.print(ans.toString());
  }
}
