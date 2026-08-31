import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyDivide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int counter = 0;
            int check = 0;
            ArrayList<Integer> list = new ArrayList<>();

            int pos = 0;
            while (true) {
                if (n == 1) {
                    System.out.println(counter);

                    break;
                }
                if (n % 6 == 0) {
                    check = 0;
                    n /= 6;
                } else {
                    if (check > 3) {
                        System.out.println("-1");
                        break;
                    }
                    n *= 2;
                    check++;
                }
                if (list.contains(n)){
                    System.out.println("-1");
                    break;
                }
                list.add(pos, n);
                if (pos >= 6) {
                    pos=0;
                } else {
                    pos++;
                }

                counter++;
            }
        }
    }
}