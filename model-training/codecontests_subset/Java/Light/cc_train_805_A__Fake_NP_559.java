import java.util.Scanner;

/**
 * Created by aaabdulh on 05/05/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long l = input.nextLong();
        long r = input.nextLong();

        if (l == r && l % 2 != 0) {
            System.out.println(l);
        } else {
            System.out.println(2);
        }
    }
}
