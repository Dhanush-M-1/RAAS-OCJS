
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextInt();

        char[] input = in.next().toCharArray();

        int zeroCount = 0, oneCount = 0;
        for (char ch: input) {
            if (ch == '0') ++zeroCount;
            else ++oneCount;
        }

        if (zeroCount != oneCount) {
            System.out.println(1);
            System.out.println(input);
        } else {
            System.out.println(2);
            System.out.println(input[0] + " " + String.valueOf(input).substring(1));
        }
    }
}
