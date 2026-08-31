
import java.util.Scanner;

/**
 *
 * @author AdminHP-262
 */
public class WizardsandDemonstration {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int req = (int) Math.ceil(n * (y / 100.0));
        if (req - x > 0) {
            System.out.println(req - x);
        } else {
            System.out.println("0");
        }
    }
}
