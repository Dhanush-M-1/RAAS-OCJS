import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String []arg) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []check = new int[m+1];

        for(int i = 0 ; i < n;++i) {
            ++check[sc.nextInt()];
        }

        int sum =0;
        int result =0 ;
        for(int i = m ; i >=1;--i) {
            result+=check[i]*sum;
            sum+=check[i];

        }
        System.out.print(result);
    }
}
