import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int maxA = 0;
        for (int n=0; n<N; n++) {
            int a = in.nextInt();
            if (K%a == 0) {
                maxA = Math.max(maxA, a);
            }
        }
        System.out.println(K/maxA);
    }

}