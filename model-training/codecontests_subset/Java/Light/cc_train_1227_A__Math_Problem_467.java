import java.util.Scanner;

public class A1227 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int minR = Integer.MAX_VALUE;
            int maxL = Integer.MIN_VALUE;
            for (int n=0; n<N; n++) {
                int L = in.nextInt();
                int R = in.nextInt();
                minR = Math.min(minR, R);
                maxL = Math.max(maxL, L);
            }
            int answer = Math.max(0, maxL-minR);
            System.out.println(answer);
        }
    }

}
