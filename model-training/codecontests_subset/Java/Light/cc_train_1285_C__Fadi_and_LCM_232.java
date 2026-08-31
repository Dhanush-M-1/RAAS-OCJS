import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class FadiLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        maxLCM(num);
//        System.out.println(getGCD(6,7));
    }

    public static void maxLCM(long number){
        int sqrRoot = (int) Math.sqrt(number);
        for (long i = sqrRoot; i >= 1 ; i--) {

            if(number % i == 0){
                long pair = number / i;
                if(getGCD(pair, i) == 1){
                    System.out.println(i + " " + pair);
                    return;
                }
            }
        }
    }

    private static long getGCD(long pair, long number){
        return (number == 0) ? pair: getGCD(number, pair % number);
    }

}
