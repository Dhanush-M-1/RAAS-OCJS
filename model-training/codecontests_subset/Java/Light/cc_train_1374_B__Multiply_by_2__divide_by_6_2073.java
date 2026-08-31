import java.util.Scanner;

public class _14MutiplyBy2DivideBy6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ////
            int original = n;
            int res = 0;
            while (n != 1 && n > 1) {
                if (n % 6 == 0) {
                    n /= 6;
                    res++;
                } else if (n%3 == 0){
                    n *= 2;
                    res++;
                } else {
                    res = -1;
                    break;
                }
            }
            System.out.println(res);
            ////
            t--;
        }
    }
}
