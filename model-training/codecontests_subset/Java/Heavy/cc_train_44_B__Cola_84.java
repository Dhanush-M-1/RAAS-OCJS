
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madi
 */
public class Round44B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long count = 0;
        for (int i = 0; i <= c; i++) {
            if (4 * i > 2 * n) {
                break;
            }
            for (int j = 0; j <= b; j++) {
                if (4 * i + 2 * j > 2 * n) {
                    break;
                }
                if ((2 * n - 4 * i - 2 * j) >= 0 && (2 * n - 4 * i - 2 * j) <= a) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
