import java.util.Scanner;

public class A1398 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = in.nextInt();
            }
            if (A[0] + A[1] <= A[N-1]) {
                System.out.println("1 2 " + N);
            } else {
                System.out.println("-1");
            }
        }
    }

}
