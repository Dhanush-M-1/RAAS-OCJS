import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] ans = new char[s.length()];
        int pos = 0;
        int l = 0, r = 1;
        char ch = s.charAt(0);
        while (r < s.length()) {
            while (r < s.length() && ch == s.charAt(r)) {
                r++;
            }
            int sz = r - l;
            if (sz == 2 && (ch == 'e' || ch == 'o')) {
                ans[pos++] = ch;
                ans[pos++] = ch;
            } else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                ans[pos++] = ch;
            } else {
                for (int j = l; j < r; j++) {
                    ans[pos++] = ch;
                }
            }
            l = r;
            r = l + 1;
            if (l < s.length()) {
                ch = s.charAt(l);
            }
        }
        if (l < s.length()) {
            ans[pos++] = s.charAt(l);
        }
        char[] anss = new char[pos];
        System.arraycopy(ans, 0, anss, 0, pos);
        System.out.println(anss);
    }
}
