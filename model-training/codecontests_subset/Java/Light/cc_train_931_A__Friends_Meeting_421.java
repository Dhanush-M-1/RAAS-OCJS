import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        int max = Math.max(first, second);
        int min = Math.min(first, second);
        int difference = max - min;
        if (difference % 2 == 0) {
            difference /= 2;
            System.out.println(difference * (difference + 1));
        } else {
            difference /= 2;
            long result = difference * (difference + 1);
            result += difference + 1;
            System.out.println(result);
        }
    }
}
