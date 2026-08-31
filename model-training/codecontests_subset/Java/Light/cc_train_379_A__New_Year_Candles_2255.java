import java.util.Scanner;

public class A379 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int candles = a;
        input.close();
        int left = 0;
        while(a!=0){
            left+=(a % b);
            a/=b;
            if(left >= b){
                a+=(left/b);
                left%=b;
            }
            candles+=a;
        }
        System.out.println(candles);
    }
}
