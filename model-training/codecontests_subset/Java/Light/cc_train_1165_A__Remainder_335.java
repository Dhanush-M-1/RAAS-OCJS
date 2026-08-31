import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        StringBuilder num = new StringBuilder();
        num.append(in.next());

        int count = 0;

        if (num.charAt(n-(x+1)) == '0') {
            // count++;
        }

        if (num.charAt(n-(y+1)) == '0') {
            count++;
        }

        for (int i = 0; i < x; i++) {
            if (i == y)
                continue;
            if (num.charAt(n-(i+1)) == '1') {
                count++;
            }
        }

        System.out.println(count);

    }

}
