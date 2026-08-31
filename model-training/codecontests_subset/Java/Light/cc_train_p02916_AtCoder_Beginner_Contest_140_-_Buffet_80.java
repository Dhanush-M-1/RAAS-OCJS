import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N+1];
        int[] C = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 1; i <= N; i++) B[i] = sc.nextInt();
        for (int i = 1; i < N; i++) C[i] = sc.nextInt();
        
        for (int i = 0; i < N-1; i++) {
            count += B[A[i]];
            if (A[i+1] == A[i]+1) count += C[A[i]];
        }

        count += B[A[N-1]];
        System.out.println(count);
    }
}
