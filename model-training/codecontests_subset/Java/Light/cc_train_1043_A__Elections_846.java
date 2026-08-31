import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        int res = (int) Math.ceil((2.0 * (float) sum + 1) / n);
//        System.out.println(Math.max(max,res));
        if (res < max) {
            res = max;
        }
        System.out.println(res);
    }
}
