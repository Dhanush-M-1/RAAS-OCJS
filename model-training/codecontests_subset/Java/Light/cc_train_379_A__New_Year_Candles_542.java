import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();
        int hours = scanner.nextInt();

        int all = amount;
        int count = 0;

        while (amount / hours != 0) {
            count += amount / hours;
            amount = amount / hours + amount % hours;
        }
        System.out.println(all + count);
    }
}
