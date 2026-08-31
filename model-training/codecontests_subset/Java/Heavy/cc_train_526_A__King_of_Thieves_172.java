import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liqiu on 2/2/15.
 */
public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String  s = cin.next();
        for(int i = 0; i < n; ++i){
            for(int step = 1; step <= n; ++step){
                int cont = 0;
                for(int j = i; j < n; j += step ){
                    if( s.charAt(j) == '*' ) cont++;
                    else break;
                }
                if( cont == 5 ){
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
