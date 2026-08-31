import java.util.Scanner;


public class Problem494A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int p = 0;
        int lp = 0;
        int s = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                lp++;
            } else if (c == ')') {
                if (lp == 0) p--;
                else lp--;
                if (p < 0) break;
            } else if (c == '#') {
                if (p == 0 && lp == 0) break;
                s++;
                p += lp;
                lp = 0;
            }
        }

        if (p <= 0 || lp > 0 || s > p) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < s - 1; i++) System.out.println(1);
            System.out.println(p - s + 1);
        }
    }
}
