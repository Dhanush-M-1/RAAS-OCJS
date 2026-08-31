
import java.util.Scanner;

public class A {

    public static void main(String[] ar) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        char[] digits = sc.nextLine().toCharArray();

        int n8 = 0;
        for (char digit : digits) {
            if (digit == '8') n8++;
        }

        System.out.println(Math.min(n8, n / 11));
    }


}
