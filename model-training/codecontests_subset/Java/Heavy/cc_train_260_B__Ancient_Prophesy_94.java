import java.util.*;
import java.util.regex.*;
import java.lang.Math.*;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private static double EPS = 1e-9;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        solve();
    }

    private int n;

    private void read() {
        n = sc.nextInt();
    }

    private void solve() {
        String line = sc.nextLine();
        parse(line);
    }
    private void parse(String line) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Matcher m = getMatcher(line);

        int max = 0;
        for (int start = 0; m.find(start); start = m.start() + 1) {
            String str = m.group();

            if (isValid(str)) {
                if (map.containsKey(str)) {
                    int count = map.get(str);
                    map.put(str, count + 1);
                    max = Math.max(max, count + 1);
                } else {
                    map.put(str, 1);
                    max = Math.max(max, 1);
                }
            }
        }

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count == max) {
                System.out.println(key);
                return;
            }
        }
    }

    private Matcher getMatcher(String line) {
        String regexp = "\\d\\d-\\d\\d-\\d\\d\\d\\d";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(line);
        return m;
    }
    private boolean isValid(String date) {
        String[] sp = date.split("-");
        int d = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int y = Integer.parseInt(sp[2]);
        return (isValid(d, m, y));
    }
    private boolean isValid(int d, int m, int y) {
        final int[] darray = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((y < 2013) || (2015 < y)) return false;
        if ((m < 1) || (12 < m)) return false;
        if ((d < 1) || (darray[m - 1] < d)) return false;
        return true;
    }
}
