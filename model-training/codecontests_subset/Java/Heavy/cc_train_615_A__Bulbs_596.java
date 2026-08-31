import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pallavi on 8/1/16.
 */
public class A615 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        boolean[] ch = new boolean[m+1];
        for (int i = 0; i < n; i++) {
            s = reader.readLine().split(" ");
            for (int j = 1; j < s.length; j++) {
                ch[Integer.parseInt(s[j])] = true;
            }
        }
        boolean fl = true;
        for (int i = 1; i < m+1; i++) {
            if (!ch[i]) {
                fl = false;
                System.out.println("NO");
                break;
            }
        }
        if (fl) {
            System.out.println("YES");
        }
    }
}
