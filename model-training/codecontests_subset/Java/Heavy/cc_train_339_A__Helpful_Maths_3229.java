
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String numbers;
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.next();
        orderNumbers(numbers);
        scanner.close();
    }

    public static void orderNumbers(String numbers) {
        String result;
        String replaceArr = numbers.replace("+", "");
        char[] arr = replaceArr.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i == 0 ? "" : "+") + arr[i]);
        }
    }
}
