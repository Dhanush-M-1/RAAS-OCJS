import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] c = str.toCharArray();
        int n = c.length;
        
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < i; j++) {
                tmp += c[j];
            }
            for (int j = i; j < n; j++) {
                String tmp2 = "";
                for (int k = j; k < n; k++) {
                    tmp2 += c[k];
                }
                
                String tmp3 = tmp + tmp2;
                // System.out.println(tmp3);
                if (tmp3.equals("keyence")) {
                    ok = true;
                }
            }
        }
        
        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}