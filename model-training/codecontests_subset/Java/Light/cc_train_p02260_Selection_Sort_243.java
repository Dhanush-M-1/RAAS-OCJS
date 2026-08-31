import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int A[] = new int[N];
        int minj, tmp, count = 0;

        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        for(int i = 0; i < N; i++) {
            minj = i;
            for (int j = i; j < N; j++) {
                if (A[j] < A[minj])
                    minj = j;
            }
            if (i != minj) {
                tmp = A[i];
                A[i] = A[minj];
                A[minj] = tmp;
                count++;
            }
        }
        System.out.print(A[0]);
        for(int i = 1; i < N; i++)
            System.out.print(" " + A[i]);
        System.out.println();
        System.out.println(count);
        sc.close();
    }
}

