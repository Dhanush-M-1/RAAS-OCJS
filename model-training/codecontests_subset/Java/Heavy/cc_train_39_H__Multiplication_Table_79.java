
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madi
 */
public class Round39H {
    public static void main(String[] args) {
        int k = new Scanner(System.in).nextInt();
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                System.out.print(convert(i * j, k) + " ");
            }
            System.out.println();
        }
    }

    private static String convert(int a, int k) {
        String res = "";
        while(a > 0) {
            res = a % k + res;
            a = a / k;
        }
        return res;
    }
}
