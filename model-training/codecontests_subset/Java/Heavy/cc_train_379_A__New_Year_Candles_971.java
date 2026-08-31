import java.util.Scanner;

public class NewYearCandles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();

        int sum = a;

        int left = a / b;
        int remainder = a % b;

        while (true) {
            if (left != 0) {
                sum += left;
                remainder += left % b;
                left = left / b;
                if (remainder >= b) {
                    left++;
                    remainder -= b;
                }
            } else {
                break;
            }
        }
        System.out.println(sum);
    }
}
