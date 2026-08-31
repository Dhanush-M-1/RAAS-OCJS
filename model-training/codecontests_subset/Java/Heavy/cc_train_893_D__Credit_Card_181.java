import java.util.Scanner;

/**
 * D. Кредитная карта
 * http://codeforces.com/problemset/problem/893/D
 */
public class Task1_893D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long days = scanner.nextLong();
        long d = scanner.nextLong();
        long max = 0; //min balance after check day
        long min = 0; //max balance after check day
        long result = 0;
        for (int i=0; i<days; i++) {
            long a = scanner.nextLong();
            if (a != 0) {
                min += a;
                max += a;
                if (min > d) {
                    result = -1;
                    break;
                }
                max = Math.min(max, d);
            } else {
                if (max >= 0) {
                    min = Math.max(min, 0);
                } else {
                    result++;
                    min = 0;
                    max = d;
                }
            }
        }
        System.out.println(result);
    }
}
