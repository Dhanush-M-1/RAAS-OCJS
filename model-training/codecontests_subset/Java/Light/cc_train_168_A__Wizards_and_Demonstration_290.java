import java.util.Scanner;

public class WizardsAndDemonstration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int p = scanner.nextInt();

        int required = (n * p) / 100;;
        if ((n * p) % 100 != 0) {
            required++;
        }

        System.out.println(Math.max(0, required - w));
    }
}
