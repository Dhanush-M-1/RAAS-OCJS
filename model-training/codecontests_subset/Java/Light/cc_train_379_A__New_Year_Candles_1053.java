
import java.util.Scanner;

/**
 * Created by dtnha on 10/13/2017.
 */
public class NewYearCandles {

    public static void main(String []args){

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int recycleCandles = 0;
        int a1 = a;
        while (a1 >= b){
               recycleCandles = recycleCandles + a1/b;
               a1 = a1/b + a1%b;
        }
        System.out.println(a+recycleCandles);
    }
}
