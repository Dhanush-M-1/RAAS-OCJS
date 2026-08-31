import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class A132 {

    public static void main(String[] Args) {
        Point start = new Point(si(), si());
        Point end = new Point(si(), si());
        Map<Point, Integer> map = new HashMap<Point, Integer>();
        int n =si();
        for (int i = 0; i < n; i++) {
            int r=si(), a=si(), b=si();
            for (int j = a; j <=b; j++) {
                map.put(new Point(r,j), -1);
            }
        }
        map.put(start, 0);
        map.put(end, -1);
        Queue<Point> q = new LinkedList<Point>();
        q.add(start);
        while(!q.isEmpty()){
            Point now = q.remove();
            for (int i = 0; i < 8; i++) {
                Point to = new Point(now.x+dx[i], now.y+dy[i]);
                if (map.get(to)!=null && map.get(to)==-1){
                    map.put(to, map.get(now)+1);
                    q.add(to);
                }
            }
        }
        System.out.println(map.get(end));
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
        return scan.nextLine();
    }

    static int[] sai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
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
