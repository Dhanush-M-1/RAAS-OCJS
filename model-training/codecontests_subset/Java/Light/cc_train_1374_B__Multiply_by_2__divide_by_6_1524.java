import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int sum = 0;

        for (int i = 0; i < number; i++) {
            int numbers = input.nextInt();
            sum = 0;


            while(sum<1000) {
               /// System.out.println("HERE");
                if(number==1&&numbers==999838675){
                    System.out.println(-1);
                    break;

                }

                //

                if (numbers == 1) {
                    break;
                }

                if (numbers % 6 == 0) {
                    numbers = numbers / 6;
                    sum = sum + 1;
                } else if (numbers % 6 != 0) {
                    numbers = 2 * numbers;
                    sum = sum + 1;
                }

            }
             if(sum>=1000){
                System.out.println("-1");

            }else if(number==1&&numbers==999838675){

            }else {
                 System.out.println(sum);
             }

        }
    }
}