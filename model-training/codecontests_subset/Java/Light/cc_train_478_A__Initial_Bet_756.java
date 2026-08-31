import java.util.Scanner;

/**
 * Created by sanjayarvind on 08/02/2017 AD.
 */
public class CR294B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int sum=0;
        for (int i = 0; i < 5; i++) {
            sum+=sc.nextInt();
        }
        if (sum%5==0 && sum!=0) System.out.println(sum/5);
        else System.out.println(-1);
    }
}
