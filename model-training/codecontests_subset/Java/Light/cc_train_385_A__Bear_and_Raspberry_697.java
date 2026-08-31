import java.util.*;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int c = sc.nextInt();
        int pre = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            max = Math.max(max, pre - cur - c);
            pre = cur;
        }
        
        System.out.println(max+"");
    }
}