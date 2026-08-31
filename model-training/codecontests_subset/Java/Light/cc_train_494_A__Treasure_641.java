import java.util.Scanner;

public class Template {

    public void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int cur = 0, k = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') cur++;
            if (i == '#') k++;
            if (i == ')') cur--;
            if (cur < 0) {
                System.out.print(-1);
                return;
            }
        }
        cur -= k;

        int j = s.length() - 1;
        while (s.charAt(j) != '#' && j>=0) {
            j--;
        }

        if (cur < 0) {
            System.out.print(-1);
            return;
        }
        String s1 = s.replace('#', ')');
        int c = cur;
        cur = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (i == j) cur -= c;
            if (s1.charAt(i) == '(') cur++;
            if (s1.charAt(i) == ')') cur--;
            if (cur < 0) {
                System.out.print(-1);
                return;
            }
        }
        for (int i = 1; i < k; i++) {
            System.out.println(1);
        }
        System.out.println(c + 1);

    }

    public static void main(String[] arg) {
        new Template().solve();

    }
}
