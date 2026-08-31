import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i < A.length;i++){
            A[i] = sc.nextInt();
        }
        int count = 0;
        int minj;
        for(int i = 0;i < N;i++){
            minj = i;
            for(int j = i;j < N;j++){
                if(A[j] < A[minj]){
                    minj = j;
                }
            }
            int tmp = A[i];
            A[i] = A[minj];
            A[minj] = tmp;
            if(A[i] != A[minj]) count++;
        }
        for (int i = 0;i < A.length-1;i++){
            System.out.printf("%d ",A[i]);
        }
        System.out.println(A[N-1]);
        System.out.println(count);
    }
}

