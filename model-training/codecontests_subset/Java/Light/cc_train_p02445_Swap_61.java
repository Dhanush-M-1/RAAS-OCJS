import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] A = new long[n];
        for(int i=0;i<n;i++) A[i] = sc.nextLong();
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            int b = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();
            for(int j=0;j<e-b;j++){
                long num = A[b+j];
                A[b+j] = A[t+j];
                A[t+j] = num;
            }
        }
        System.out.print(A[0]);
        for(int j=1;j<n;j++) System.out.print(" "+A[j]);
        System.out.println();
    }
}
