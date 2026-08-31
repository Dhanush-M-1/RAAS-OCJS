import java.util.Arrays;
import java.util.Scanner;

public class B990 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Integer[] A = new Integer[N];
        for (int n=0; n<N; n++) {
            A[n] = in.nextInt();
        }
        Arrays.sort(A);
        int answer = 0;
        int count = 1;
        int idx = 1;
        while (idx < N) {
            if (A[idx].equals(A[idx-1])) {
                count++;
            } else {
                if  (A[idx-1] + K < A[idx]) {
                    answer += count;
                }
                count = 1;
            }
            idx++;
        }
        answer += count;
        System.out.println(answer);
    }

}
