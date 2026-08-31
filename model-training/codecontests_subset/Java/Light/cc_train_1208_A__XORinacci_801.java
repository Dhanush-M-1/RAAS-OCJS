/**
 * Created by Rukshar Alam on 10/18/2019.
 */
import java.util.*;
public class Xorinacci1208A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for(int t =0;t<T;t++){
            int a = input.nextInt();int b = input.nextInt();int n = input.nextInt();

            if(n%3==0) System.out.println(a);
            else if(n%3==1) System.out.println(b);
            else System.out.println(a^b);
        }

    }
}
