import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M + 1];
        if(M==0){
            a[0] = 0;
        }
        else{
            a[0] = sc.nextInt();
        }

        for(int i=1; i<M; i++){
            a[i] = sc.nextInt();
            if(a[i]==a[i-1]+1){
                System.out.println(0);
                return;
            }
        }

        int[] ans = new int[N + 1];
        ans[0] = 1;
        int x = 0;
        if(a[0]==1){
            ans[1] = 0;
            x += 1;
        }
        else{
            ans[1] = 1;
        }
        for(int i=2; i<=N; i++){
            if(i==a[x]){
                ans[i] = 0;
                x += 1;
            }
            else{
                ans[i] = (ans[i - 1] + ans[i - 2]) % 1000000007;
            }
        }
        System.out.println(ans[N]);
    }
}