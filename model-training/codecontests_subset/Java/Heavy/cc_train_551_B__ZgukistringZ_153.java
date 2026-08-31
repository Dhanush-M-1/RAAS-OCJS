import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author ivoryxiong
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();

        int [] ca = new int[26];
        int [] cb = new int[26];
        int [] cc = new int[26];

        for (int i = 0; i < b.length(); i ++) {
            cb[b.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < c.length(); i ++) {
            cc[c.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < a.length(); i ++) {
            ca[a.charAt(i) - 'a'] ++;
        }

        boolean res = true;
        int maxAns = a.length() / Math.min(b.length(), c.length());
        for (int i=0; i <26; i ++) {
            if (ca[i] < cb[i] && ca[i] < cc[i]) {
                res = false;
            }
        }
        if (!res) {
            out.println(a);
            return;
        }

        int na = 0, nb = 0;
        boolean can = false;
        do {
           for (na = 0; na <= maxAns; na ++) {
               nb = maxAns - na;
               boolean ok = true;
               boolean allno = false;
               for (int i=0; i < 26 ; i++) {
                   if (ca[i] < cb[i] * na + cc[i] * nb) {
                       ok = false;
                       allno = cb[i] >= cc[i];
                       break;
                   }
               }
               if (ok) {
                   can = true;
                   break;
               }
               if (allno) {
                   break;
               }
           }
            --maxAns;
        } while(!can && maxAns > 0);


        for (int i=0; i<na; i ++) {
            out.print(b);
        }
        for (int i=0; i <nb; i ++) {
            out.print(c);
        }
        for (int i=0; i < 26; i ++) {
            int num = ca[i] - na * cb[i] - nb * cc[i];
            for( int j=0; j < num; j ++) {
                out.print((char)('a'+i));
            }
        }
        out.println();
    }
}
