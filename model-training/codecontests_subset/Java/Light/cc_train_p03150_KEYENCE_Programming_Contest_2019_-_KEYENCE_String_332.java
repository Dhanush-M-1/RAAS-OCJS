import java.util.*;
 
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        for (int i = 0; i < S.length()-1; i++) {
            for (int j = i; j < S.length(); j++) {
                String s = S.substring(0, i) + S.substring(j, S.length());
                if (s.equals("keyence")) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
