import java.util.Scanner;

public class FadiLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        getLCMPair(input);
    }

    public static void getLCMPair(long number){
        int sqr = (int) Math.sqrt(number);
        for (int i = sqr; i >= 1 ; i--) {
            if(number % i == 0){
                //i is a factor
                long pair = number / i;
                if(getGCD(pair, i) == 1){
                    System.out.println( i + " " + pair);
                    return;
                }
            }
        }


    }


    public static long getGCD(long num1, long num2){
        if(num2 == 0)  return num1;
        return getGCD(num2, num1 % num2);
    }
}
