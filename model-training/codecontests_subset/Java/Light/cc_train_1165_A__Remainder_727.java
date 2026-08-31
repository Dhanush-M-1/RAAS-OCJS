
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int y = scan.nextInt();
        int x = scan.nextInt();
        String str = scan.next();
        int counter = 0;
        for (int i = 0; i < y; i++) {
            if (i != x) {
                if (str.charAt(str.length() - i - 1) == '1') {
                    counter++;
                }
            }
            if (i == x) {
                if (str.charAt(str.length() - i - 1) == '0') {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
