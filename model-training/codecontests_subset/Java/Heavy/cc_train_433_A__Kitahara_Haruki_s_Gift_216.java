import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Himalay(himalayjoriwal@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int a = 0, b = 0;
        int tot;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 200)
                b++;
            else if (x == 100) {
                a++;
            }
        }

        tot = a + 2*b;

        if (tot % 2 == 0) {
            tot = tot/2;

           while (tot > 0) {
               if (tot%2 == 1 && a > 0) {
                   tot--; a--;
               }else {
                   if (tot > 1 && b > 0) {
                       tot -= 2;
                       b--;
                   } else if (tot > 0 && a > 0) {
                       tot--;
                       a--;
                   }else {
                       break;
                   }
               }

           }
            if (tot == 0)
                out.println("YES");
            else
                out.println("NO");
        }else {
            out.println("NO");
        }

    }
}

