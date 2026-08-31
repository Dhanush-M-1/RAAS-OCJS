import java.io.*;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int tc = in.nextInt();
        int k = 0;
        while (k < tc) {
            System.out.println(solve1());
            k++;
        }
    }

    public static void solve2() {
        int n = in.nextInt();
        String str = in.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')' && count > 0) {
                count--;
            }
            if (str.charAt(i) == '(') {
                count = count + 1;
            }

        }
        System.out.println(count);

    }

    public static int solve1() {
        int x = in.nextInt();
        int two = 0;
        int three = 0;
        while (!(x % 2 != 0)) {
            x = x / 2;
            two++;
        }
        // System.out.println(two);
        while (!(x % 3 != 0)) {
            x = x / 3;
            three++;
        }
        // System.out.println(three);

        if (x != 1 || two > three) {
            return -1;
        } else {
            return 2 * three - two;
        }
    }
}
