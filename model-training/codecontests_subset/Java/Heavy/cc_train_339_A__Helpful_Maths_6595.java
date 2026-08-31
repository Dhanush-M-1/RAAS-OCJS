import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.nextLine();
        char[] charArr = new char[arr.length() /2 + 1];
        char[] sortedArr = new char[arr.length()];

        for (int i = 0, j = 0; i <= arr.length() && j <= charArr.length; i += 2, j++) {
            charArr[j] = arr.charAt(i);
        }



        Arrays.sort(charArr);





        for (int i = 0, j = 0; i < arr.length() && j < charArr.length; i += 2, j++) {
            sortedArr[i] = charArr[j];
        }
        for (int i = 1; i < sortedArr.length; i += 2) {
            sortedArr[i] = '+';
        }

        System.out.println(sortedArr);

    }
}
