import java.util.Scanner;
import java.lang.Math;

public class Robot {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt() - 1;
        
        int a = (int) (Math.floor((Math.sqrt(1+8*(long)k) - 1)/2));
        a = (int)(k - ((long)a*(a+1)/2));
        for (int i = 0; i < a; i++) {
            in.nextInt();
        }
        int ans = in.nextInt();
        System.out.println(ans);
        in.close();
    }
    
}