import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Arkady on 16.05.2019.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        String s = in.nextLine();
        s = in.nextLine();
        int ans = 0;
        for(int i = n-1;i>=n-x;i--) {
            if(s.charAt(i) == '1') {
                ans++;
            }
        }
        if(s.charAt(n-y-1)=='1') {
            ans--;
        } else {
            ans++;
        }
        System.out.println(ans);
    }
}
