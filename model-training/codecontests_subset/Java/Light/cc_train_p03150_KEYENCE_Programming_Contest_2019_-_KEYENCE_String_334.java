import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String keyence = "keyence";
        String ans = "YES";
        if (-1 < S.indexOf("keyence")) {
            if (!S.substring(0, 7).equals("keyence") && !S.substring(S.length()-7, S.length()).equals("keyence")) {
                ans = "NO";
            }
        } else {
            boolean order = true;
            for (int i = 0; i < 7; i++) {
                if (S.charAt(i) == keyence.charAt(i) && order) {
                    continue;
                } else {
                    order = false;
                    if (S.charAt(S.length()-7+i) == keyence.charAt(i)) {
                        continue;
                    } else {
                        ans = "NO";
                    }
                }
            }
        }
        System.out.println(ans);
    }
}