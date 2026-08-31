import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i = 0;i < n;i++){
            A[i] = sc.nextInt();
        }

        int minj,tmp,count = 0;
        for(int i = 0;i < n - 1;i++){
            minj = i;
            for(int j = i;j < n;j++){
                if(A[j] < A[minj]){
                    minj = j;
                }
            }
            if(minj != i){
                tmp = A[i];
                A[i] = A[minj];
                A[minj] = tmp;
                count++;
            }
        }
        for(int i = 0;i < n;i++){
            if(i != 0) System.out.print(" ");
            System.out.print(A[i]);
        }
        System.out.println();
        System.out.println(count);

    }
}
