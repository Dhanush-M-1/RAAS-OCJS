import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] F = new int[N][10];

        for(int i=0; i<N; i++){
            for(int j=0; j<10; j++){
                F[i][j] = sc.nextInt();
            }
        }

        int[][] P = new int[N][11];
        for(int i=0; i<N; i++){
            for(int j=0; j<11; j++){
                P[i][j] = sc.nextInt();
            }
        }
        int ans = -1 * Integer.MAX_VALUE;
        for(int i=1; i<(1<<10); i++){
            int cost = 0;
            for(int j=0; j<N; j++){
                int c =0;
                for(int k=0; k<10; k++){
                    if((i>>k&1)==1 && F[j][k]==1){
                        c++;
                    }
                }
                cost += P[j][c];
            }
            ans = Math.max(ans, cost);
        }
        System.out.println(ans);
    }
}