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
            for (int j = i; j < n; j++) {
                String tmp1 = str.substring(0, i);
                String tmp2 = str.substring(j, n);
                
                String tmp = tmp1 + tmp2;
                if (tmp.equals("keyence")) ok = true;
            }
        }
        
        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
