import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
 
        int scnt = 0;
        int tcnt = 0;
        String s = sc.next();
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (s.charAt(i) == 'S') {
                ++scnt;
            } else if (scnt > 0 && s.charAt(i) == 'T') {
                --scnt;
            } else {
                ++tcnt;
            }
        }
 
        out.println((scnt + tcnt));
        out.flush();
    }
}