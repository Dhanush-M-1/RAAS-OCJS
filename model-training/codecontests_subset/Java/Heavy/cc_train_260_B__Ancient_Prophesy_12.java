import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {

    static Map<Point, Integer> map = new HashMap<Point, Integer>();
    static Point end;

    public static void main(String[] Args) {
        int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String s = ss();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int month = 1; month <= 12; month++) {
            for (int i = 1; i <= day[month - 1]; i++) {
                for (int year = 2013; year <= 2015; year++) {
                    String d = i < 10 ? "0" + i : i + "";
                    String m = month < 10 ? "0" + month : month + "";
                    String y = year + "";
                    String date = String.format("%s-%s-%s", d, m, y);
                    // System.out.println(date);
                    map.put(date, 0);
                }
            }
        }

        for (int i = 0; i + 10 <= s.length(); i++) {
            String d = s.substring(i, i + 10);
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);

            }
        }
        int m = -1;
        String ans = "";
        for (String key : map.keySet()) {
            if ( map.get(key)> m){
                ans = key;
                m = map.get(key);
            }
        }
        System.out.println(ans);
    }

    static int toi(Object s) {
        return Integer.parseInt(s.toString());
    }

    // ----------------------- Library ------------------------
    static int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 }, dy = { 1, 1, 1, 0, 0, -1,
            -1, -1 };
    static Scanner scan = new Scanner(System.in);
    static int INF = 2147483647;

    // finds GCD of a and b using Euclidian algorithm
    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static List<String> toList(String[] a) {
        return Arrays.asList(a);
    }

    static String[] toArray(List<String> a) {
        String[] o = new String[a.size()];
        a.toArray(o);
        return o;
    }

    static int[] pair(int... a) {
        return a;
    }

    static int si() {
        return scan.nextInt();
    }

    static String ss() {
        return scan.next();
    }

    static int[] sai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = si();

        return a;
    }

    static int[] sai_(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = si();

        return a;
    }

    static String[] sas(int n) {
        String[] a = new String[n];
        for (int i = 0; i < a.length; i++)
            a[i] = ss();
        return a;
    }

    static Object[][] _sm1(int r, int c) {
        Object[][] a = new Object[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = scan.next();
        return a;
    }

    static Object[][] _sm2(int r) {
        Object[][] a = new Object[r][3];
        for (int i = 0; i < r; i++)
            a[i] = new Object[] { ss(), ss(), ss() };
        return a;
    }
}