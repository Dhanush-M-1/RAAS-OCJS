
import java.util.Scanner;

public class HelpfullMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        char[] numbers = new char[(str.length() / 2) + 1];
        char[] plus = new char[str.length() / 2];
        int plusCounter = 0;
        int numbersCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c[i] >= '1' && c[i] <= '3') {
                numbers[numbersCounter++] = c[i];
            }
            else
                plus[plusCounter++] = c[i];
        }

        //Sort numbers
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]){
                    char temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }

            }

        }

        for (int i = 0; i < numbers.length; i++) {
            if (i != numbers.length - 1) {
                System.out.print(numbers[i]);
                System.out.print(plus[i]);
            }
            else
                System.out.print(numbers[i]);

        }
    }



}
