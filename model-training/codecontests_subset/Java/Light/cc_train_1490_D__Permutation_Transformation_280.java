// package cf;

import java.util.Scanner;

public class D {
    
    static int[] a;
    static int[] d;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while(T-->0){
            int N = in.nextInt();
            a = new int[N+1];
            d = new int[N+1];

            for(int i = 1; i <= N; ++i){
                a[i] = in.nextInt();                
            }
            
            solve(1, N, 0);

            for(int i = 1; i <= N; ++i){
                System.out.print(d[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void solve(int i, int j, int dep){
        if(i <= j){
            int idx = j;
            for(int k = i; k < j; ++k){
                if(a[k] > a[idx]){
                    idx = k;
                }
            }
            
            d[idx] = dep;
            solve(i, idx-1, dep+1);
            solve(idx+1, j, dep+1);
        }
    }
}
