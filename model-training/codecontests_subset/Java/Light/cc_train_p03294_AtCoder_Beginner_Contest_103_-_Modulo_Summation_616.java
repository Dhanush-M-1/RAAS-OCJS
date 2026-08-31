import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int[] A = new int[N];
        int ans = 0;
        for(int i = 0;i < N;i++){
            a[i] = sc.nextInt();
            A[i] = a[i] - 1;
            ans += A[i];
        }
        System.out.println(ans);
    }
}