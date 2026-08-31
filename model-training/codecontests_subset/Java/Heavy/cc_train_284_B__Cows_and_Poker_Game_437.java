import com.sun.javafx.scene.layout.region.Margins;

import java.io.*;
import java.util.*;
import java.math.*;

public class GGWPLivaem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        StringBuilder s = new StringBuilder(in.next());
        int cnt = 0;
        int cntt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'I') {
                ++cnt;
            }
            if (s.charAt(i) == 'F') {
                ++cntt;
            }
        }
        //out.println(cnt);
        if (cnt == 1) {
            out.println(1);
        }
        if (cnt > 1) {
            out.println(0);
        }
        if (cnt < 1) {
            out.println(n - cntt);
        }
        out.close();
    }
}