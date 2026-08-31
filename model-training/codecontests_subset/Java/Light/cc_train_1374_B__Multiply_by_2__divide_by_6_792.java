import java.util.*;
public class Mul_Div {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int number = sc.nextInt();
            int count = 0;
            while(number > 1) {
                if(number == 2) {
                    count = -1;
                    break;
                }
                if(number <= 1) {
                    break;
                }
                if(number % 6 == 0) {
                    number /= 6;
                    count++;
                }
                else {
                    number *= 2;
                    count++;
                }
            }
            if(count >= 0 && number == 1) {
                System.out.println(count);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}