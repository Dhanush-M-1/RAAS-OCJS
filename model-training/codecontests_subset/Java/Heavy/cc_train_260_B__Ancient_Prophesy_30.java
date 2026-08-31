import java.io.*;
import java.util.*;

public class nB {

    Scanner in;
    PrintWriter out;

    class Date implements Comparable<Date> {
        int d;
        int m;
        int y;

        Date(int d, int m, int y) {
            this.d = d;
            this.m = m;
            this.y = y;
        }

        int col;

        @Override
        public int compareTo(Date other) {
            if (this.d == other.d && this.m == other.m && this.y == other.y) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    void solve() {
        String s = in.nextLine();
        int days[] = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        TreeSet<Date> set = new TreeSet<Date>();
        for (int i = 0; i < s.length() - 9; i++) {
            String r = s.substring(i, i + 10);
            if ('0' <= r.charAt(0) && r.charAt(0) <= '9' && '0' <= r.charAt(1) && r.charAt(1) <= '9' && '0' <= r.charAt(3) && r.charAt(3) <= '9'
                    && '0' <= r.charAt(4) && r.charAt(4) <= '9' && '0' <= r.charAt(6) && r.charAt(6) <= '9' && '0' <= r.charAt(7) && r.charAt(7) <= '9'
                    && '0' <= r.charAt(8) && r.charAt(8) <= '9' && '0' <= r.charAt(9) && r.charAt(9) <= '9') {
                int d = Integer.parseInt(r.substring(0, 2));
                int m = Integer.parseInt(r.substring(3, 5));
                int y = Integer.parseInt(r.substring(6));
                if (r.charAt(2) == '-' && r.charAt(5) == '-' && 1 <= m && m <= 12 && 2013 <= y && y <= 2015 && 1 <= d && d <= days[m - 1]) {
                    Date curDate = new Date(d, m, y);
                    boolean find = false;
                    for (Date x : set) {
                        if (x.compareTo(curDate) == 0) {
                            x.col++;
                            find = true;
                        }
                    }
                    if (!find) {
                        curDate.col = 1;
                        set.add(curDate);
                    }
                }
            }
        }
        int max = set.first().col;
        Date maxx = set.first();
        for (Date x : set) {
            if (x.col >= max) {
                max = x.col;
                maxx = x;
            }
        }
        int ansd = maxx.d;
        int ansm = maxx.m;
        int ansy = maxx.y;
        if (0 <= ansd && ansd <= 9) {
            out.print("0");
            out.print(ansd);
        }else{
            out.print(ansd);
        }
        out.print("-");
        if (0 <= ansm && ansm <= 9) {
            out.print("0");
            out.print(ansm);
        }else{
            out.print(ansm);
        }
        out.print("-");
        out.print(ansy);
    }

    void run() {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        try {
            solve();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new nB().run();
    }
}
