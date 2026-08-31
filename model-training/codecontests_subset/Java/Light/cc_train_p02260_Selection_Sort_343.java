import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++) A[i] = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < N; i++){
            int minj = i;
            for(int j = i; j < N; j++){
                if(A[j] < A[minj]){
                    minj = j;
                }
            }
            if(A[i] > A[minj]){
                int m = A[i];
                A[i] = A[minj];
                A[minj] = m;
                sum++;
            }
        }
        
        for(int i = 0; i < N; i++){
            System.out.print(A[i]);
            if(i != N - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println(sum);

        sc.close();
    }
}
