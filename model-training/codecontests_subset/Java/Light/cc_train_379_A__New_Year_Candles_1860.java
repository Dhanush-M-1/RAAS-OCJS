import java.util.Scanner;

public class NewYearCandles {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int total = SCANNER.nextInt();
        int create = SCANNER.nextInt();

        int ans = total;
        while (true) {
            ans += (total / create);
            total = total / create + total % create;

            if (total < create)
                break;
        }

        System.out.print(ans);
    }
}
