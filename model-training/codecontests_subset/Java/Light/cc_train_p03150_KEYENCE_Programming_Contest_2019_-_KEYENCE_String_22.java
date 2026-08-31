import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] c = str.toCharArray();
        int n = c.length;
        
        String ans = "NO";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String now = "";
                for (int k = 0; k < i; k++) {
                    now += c[k];
                }
                for (int k = j; k < n; k++) {
                    now += c[k];
                }
                // System.out.println(now);
                if (now.equals("keyence")) {
                    ans = "YES";
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
