import java.math.*;
import java.util.Scanner;

import static java.lang.Math.min;

public class ex12 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);

        int b = in.nextInt();
        BigInteger x = in.nextBigInteger();
        int[] a = new int[b];

        for(int i = 0; i < b; i++){
            BigInteger q = x.mod(BigInteger.valueOf(10));
            a[i] = q.intValue();
            x = x.divide(BigInteger.valueOf(10));
        }

        int z = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] == 8) {
                z++;
            }
        }

        if (b / 11 == z) System.out.println(z);
        else System.out.println(min(z, b / 11));


    }
}
