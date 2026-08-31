import java.util.Scanner;

/**
 * Created by user on 2017-03-08.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int i = 0;
        int num1 = 0, num2 = 0, num3 = 0;
        while (i < numStr.length()) {
            switch (numStr.charAt(i)) {
                case '1':
                    num1++;
                    break;
                case '2':
                    num2++;
                    break;
                case '3':
                    num3++;
                    break;
                default:
                    break;
            }
            i++;
        }

        while (num1 != 0) {
            System.out.print("1");
            num1--;
            if (0 == num1 + num2 + num3)
                break;
            System.out.print("+");
        }

        while (num2 != 0) {
            System.out.print("2");
            num2--;
            if (0 ==  num2 + num3)
                break;
            System.out.print("+");
        }
        while (num3 != 0) {
            System.out.print("3");
            num3--;
            if (num3 != 0)
                System.out.print("+");
        }
    }
}
