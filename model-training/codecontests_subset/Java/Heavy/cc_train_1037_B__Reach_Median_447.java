import java.util.Arrays;
import java.util.Scanner;

public class B1037 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        Integer[] A = new Integer[N];
        for (int n=0; n<N; n++) {
            A[n] = in.nextInt();
        }
        Arrays.sort(A);
        long answer = 0;
        for (int n=0; n<N; n++) {
            if (n <= N/2 && A[n] > S) {
                answer += A[n] - S;
            }
            if (n >= N/2 && A[n] < S) {
                answer += S - A[n];
            }
        }
        System.out.println(answer);
    }

}
