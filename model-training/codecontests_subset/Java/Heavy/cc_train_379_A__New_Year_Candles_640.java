import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class JavaApplication12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int o = input.nextInt();
        int h = o;
        int a = input.nextInt();
        int repo = 0;
        int sum = 0;
        boolean r = true;
        while (r) {
            if (o % a == 0) {
                sum += o / a;
                o /= a;
            } else if (o > a) {
                while (o % a != 0) {
                    o--;
                    repo++;
                }
            } else if (o < a) {
                if (o % a != 0 && repo > 0) {
                    while (o % a != 0 && repo > 0) {
                        o++;
                        repo--;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(sum + h);
    }
}
