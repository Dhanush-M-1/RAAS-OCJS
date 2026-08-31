
import java.util.Scanner;

public class Main {

    static class Seg {

        Seg(int f, int s, int id) {
            this.id = id;
            first = f;
            second = s;
        }
        int id;
        int first;
        int second;
    }

    static int m;
    static int segs;
    static int ids;
    static Seg[] s;

    public static void main(String[] args) {
        segs = 0;
        s = new Seg[100];

        Scanner cin = new Scanner(System.in);
        String[] line = cin.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            String[] ss = cin.nextLine().split(" ");
            if (ss[0].compareTo("alloc") == 0) {
                if (ss.length == 2) {
                    System.out.println(alloc(Integer.parseInt(ss[1])));
                } else {
                    System.out.println(allocp(Integer.parseInt(ss[1]), Integer.parseInt(ss[2])));
                }
            } else if (ss[0].compareTo("erase") == 0) {
                if (!erase(Integer.parseInt(ss[1]))) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else if (ss[0].compareTo("defragment") == 0) {
                defragment();
            }
        }
    }

    private static void sort() {
        for (int i = 0; i < segs - 1; i++) {
            for (int j = segs - 2; j >= i; j--) {
                if (s[j].first > s[j + 1].first) {
                    Seg t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                }
            }
        }
    }

    private static String alloc(int n) {
        if (segs > 0 && s[0].first > n) {
            s[segs++] = new Seg(1, n, ++ids);
            sort();
            return String.valueOf(ids);
        }
        for (int i = 0; i < segs - 1; i++) {
            if (s[i + 1].first - s[i].second > n) {
                //System.out.println("case1");
                s[segs++] = new Seg(s[i].second + 1, s[i].second + n, ++ids);
                sort();
                return String.valueOf(ids);
            }
        }
        if (segs > 0 && m - s[segs - 1].second >= n) {
            //System.out.printf("case2, allocating %d to %d for %d\n", s[segs - 1].second + 1, s[segs - 1].second + n, segs + 1);
            s[segs] = new Seg(s[segs - 1].second + 1, s[segs - 1].second + n, ++ids);
            segs++;
            return String.valueOf(ids);
        }
        if (segs == 0 && n <= m) {
            //System.out.printf("case3, allocating %d to %d for %d\n", 1, n, 1);
            s[segs] = new Seg(1, n, ++ids);
            segs++;
            return String.valueOf(ids);
        }
        //System.out.println("case4");
        return "NULL";
    }

    private static String allocp(int parseInt, int parseInt0) {
        return "NULL";
    }

    private static boolean erase(int idd) {
        for (int i = 0; i < segs; i++) {
            //System.out.printf("finding s[i].id = %d, idd = %d\n", s[i].id, idd);
            if (s[i].id == idd) {
                s[i].first = 2147483647;
                s[i].second = 2147483647;
                sort();
                segs--;
                return true;
            }
        }
        return false;
    }

    private static void defragment() {
        sort();
        int idx = 1;
        for (int i = 0; i < segs; i++) {
            int d = s[i].second - s[i].first;
            s[i].first = idx;
            s[i].second = idx + d;
            idx += d + 1;
        }
    }
}
