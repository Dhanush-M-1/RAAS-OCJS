import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[100];
        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();

        int count = 0;
        for (int i = 0; i < N; i++){
            int minj = i;
            for (int j = i; j < N; j++){
                if(A[j] < A[minj])
                    minj = j;
            }
            if(i != minj){
                int tmp = A[i];
                A[i] = A[minj];
                A[minj] = tmp;
                count++;
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print(A[i]);
            if(i != N-1) System.out.print(" ");
        }
        System.out.println("\n" + count);
    }
}

