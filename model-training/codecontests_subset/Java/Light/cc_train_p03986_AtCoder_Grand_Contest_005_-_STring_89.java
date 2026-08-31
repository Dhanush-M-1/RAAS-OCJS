import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]$) {
        char[] x = scanner.next().toCharArray();
        int ans = 0, c = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 'S') {
                c++;
            } else if (c == 0) {
                ans++;
            } else {
                c--;
            }
        }
        System.out.println(ans * 2);
    }
}