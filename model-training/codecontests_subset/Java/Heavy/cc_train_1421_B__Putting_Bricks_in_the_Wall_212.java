import java.util.*;

public class p1421B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), c = 0;
            String s = "", s2 = "";
            char a[][] = new char[n][n];
            for (int i = 0; i < n; i++)
                a[i] = sc.next().toCharArray();
            char x = a[1][0];
            if (a[1][0] != a[0][1]) {
                c++;
                if (a[0][1] == a[n - 1][n - 2]) {
                    s = "1 2";
                    x = a[1][0];
                } else if (a[1][0] == a[n - 1][n - 2]) {
                    s = "2 1";
                    x = a[0][1];
                }
            }
            if (a[0][1] == a[1][0] && a[n - 1][n - 2] == a[n - 2][n - 1] && a[n - 1][n - 2] == a[0][1]) {
                c = 2;
                s2 = n + " " + (n - 1);
                s = (n - 1) + " " + n;
            } else if (a[n - 1][n - 2] != a[n - 2][n - 1]) {
                c++;
                if (a[n - 1][n - 2] == x) {
                    s2 = n + " " + (n - 1);
                } else if (a[n - 2][n - 1] == x) {
                    s2 = (n - 1) + " " + n;
                }
            }
            System.out.println(c);
            if (s != "")
                System.out.println(s);
            if (s2 != "")
                System.out.println(s2);
        }
    }
}
