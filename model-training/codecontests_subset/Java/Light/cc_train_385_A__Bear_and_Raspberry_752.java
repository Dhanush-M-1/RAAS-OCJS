import java.util.*;

public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] ori = new int[n];
        int ans = 0;
        for (int i = 0; i < ori.length; i++) ori[i] = sc.nextInt();
        for (int i = 0; i < ori.length - 1; i++) {
            if (ori[i] - ori[i + 1] > ans) {
                ans = ori[i] - ori[i + 1];
            }
        }
        if (ans - c < 0) {
            System.out.println(0);
        } else {
            System.out.println(ans - c);
        }
        
    }
}
