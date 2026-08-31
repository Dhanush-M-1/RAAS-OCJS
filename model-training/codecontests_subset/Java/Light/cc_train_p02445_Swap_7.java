import java.util.*;

class Main{
    static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0;i < n;i++){
            A[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        for(int i = 0;i < q;i++){
            int b = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();
            int tmp = 0;

            for(int k = 0;k < (e - b);k++){
                tmp = A[b + k];
                A[b + k] = A[t + k];
                A[t + k] = tmp;            
            }
        }

        for(int i = 0;i < n;i++){
            if(i != 0)  System.out.print(" ");
            System.out.print(A[i]);
        }
        System.out.println();
    }
}
