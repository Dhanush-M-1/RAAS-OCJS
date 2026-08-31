import java.util.*;
import java.io.*;

public class PerformTheCombo {
    public static int next(int A[], long target) {
        int start = 0, end = A.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String s = sc.next();
            int K[] = new int[M + 1];

            for(int i = 0; i < M; i++)
                K[i] = sc.nextInt();
            K[M] = N;
            Arrays.sort(K);

            int A[] = new int[26];
            for(int i = 0; i < N; i++) {
                int x = s.charAt(i) - 97;
                int index = next(K, i + 1);
                A[x] += (M + 1 - index);
            }

            for(int i = 0; i < 26; i++)
                System.out.print(A[i] + " ");

            System.out.println();
        }
    }
}
