import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] c = s.toCharArray();
        boolean is = false;
        int i = 0, j = 0;
        o:
        for (; i < n - 1; i++) {
            if (c[i] <= c[i + 1]) continue;
            int k = (int) c[i];
            while (k-- > 97)
                if (s.substring(i + 1).contains("" + (char) k)) {
                    is = true;
                    j = s.lastIndexOf((char) k);
                    break o;
                }
        }
        System.out.println(is ? "YES\n" + (i + 1) + " " + (j + 1) : "NO");
    }
}