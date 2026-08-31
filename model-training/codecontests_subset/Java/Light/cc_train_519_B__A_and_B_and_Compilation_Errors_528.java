
import java.util.Scanner;

/**
 * Created by 3ale2 on 7/11/17.
 */
public class B519_ABCompilationErrors {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for(int i = 0 ; i < n ; i++){
            sum1 += sc.nextInt();
        }

        for(int i = 0 ; i < n-1 ; i++){
            sum2 += sc.nextInt();
        }

        System.out.println(sum1-sum2);

        for(int i = 0 ; i < n-2 ; i++){
            sum3 += sc.nextInt();
        }

        System.out.println(sum2-sum3);

    }
}
