import java.util.*;
import java.io.*;

public class BadTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int A[] = new int[N];

            for(int i = 0; i < N; i++)
                A[i] = sc.nextInt();

            if(A[0] + A[1] <= A[N - 1])
                System.out.println(1 + " " + 2 + " " + N);
            else
                System.out.println(-1);
        }
    }
}
