import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test > 0)
        {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int n3 = scanner.nextInt();
            int stones = 0;
            while (n3 >= 2 && n2 >= 1)
            {
                n3 -= 2;
                n2 -= 1;
                stones += 3;
            }
            while (n1 >= 1 && n2 >= 2)
            {
                n1 -= 1;
                n2 -= 2;
                stones += 3;
            }
            System.out.println(stones);
            test--;
        }
    }
}