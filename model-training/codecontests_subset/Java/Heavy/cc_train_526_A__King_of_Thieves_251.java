import java.util.*;
import java.io.*;
public class Zeptolab_a {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        Scanner scr = new Scanner(isr);
        int n = scr.nextInt();
        String s = scr.next();
        char [] c = s.toCharArray();
        int t = 0;
        int k = 0;
        f: for (int i = 0; i < n; i++) {
            if (c[i] != '*') continue;
                for (int r = 1; r+i < n; r++) {
                    t = 0;
                    k = 1;
                    while (i+r*k < n) {
                        if (c[i+r*k] == '*') {
                            t++;
                            k++;
                        } else break;
                        if (t == 4) {
                            break f;
                        }
                    }
                }
        }
        PrintWriter pw = new PrintWriter(System.out);
        if (t == 4) {
            pw.print("yes");
        } else pw.print("no");
        pw.flush();
        pw.close();
    }
}