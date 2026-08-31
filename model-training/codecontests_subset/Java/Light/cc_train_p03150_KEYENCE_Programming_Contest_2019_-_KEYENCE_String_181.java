import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String S = scan.next();
        String keyence = "keyence";
        if (keyence.equals(S)) {
            System.out.println("YES");
            return;
        }
        int length = S.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                StringBuilder sb = new StringBuilder(S);
                String target = sb.delete(i, j).toString();
                if (keyence.equals(target)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
