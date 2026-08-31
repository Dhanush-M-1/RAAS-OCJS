import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
        String s = scanner.nextLine();
        s = scanner.nextLine();
        int wrong = 0;
        for(int i = s.length() - x; i < s.length(); ++i) {
            if((i == s.length() - y - 1 && s.charAt(i) == '0')
                    || (i != s.length() - y - 1 && s.charAt(i) == '1')) {
                wrong++;
            }
        }
        System.out.println(wrong);
    }
}
