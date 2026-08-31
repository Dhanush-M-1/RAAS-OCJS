
import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n; i++) {
                int cur = 0;
                int j = i;
                while (j < n && str.charAt(j) == '*') {
                    cur++;
                    j += len;
                }
                
                if (cur >= 5) {
                    System.out.printf("%s", "yes");
                    return;
                } 
            }
        }
        System.out.printf("%s", "no");
    }
}
