import java.util.Scanner;


public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ret = 0;
        for (int A = 0; A <= a; A+=2) {
            for (int B = 0; B <= b; B++) {
                int cnt = A/2  + B;
                int rem = n - cnt;
                if (rem >= 0 && (rem % 2 == 0) && (rem/2<=c) ) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }

}
