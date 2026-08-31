import java.util.*;
import java.io.*;

public class Stones {
    static int[][][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("Stones.out");

        int t = sc.nextInt();
        for(int i = 0; i<t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dp = new int[a+1][b+1][c+1];
            for(int x1 = 0; x1<=a; x1++){
                for(int y1 = 0; y1 <= b; y1++){
                    for(int z1 = 0; z1<= c; z1++){
                        dp[x1][y1][z1] = -1;
                    }
                }
            }
            System.out.println(ans(a,b,c));
        }
    }

    public static int ans(int i, int j, int k){
        if(i < 0 || j < 0 || k < 0)
            return 0;
        if(dp[i][j][k] >= 0){
            return dp[i][j][k];
        }
        if(i < 1){
            if(j < 1 || k < 2){
                return dp[i][j][k] = 0;
            }
            else{
                return dp[i][j][k] = 3 + ans(i, j-1, k-2);
            }
        }
        if(k < 2){
            if(i < 1 || j < 2){
                return dp[i][j][k] = 0;
            }
            else{
                return dp[i][j][k] = 3 + ans(i-1, j-2, k);
            }
        }
        if(j < 1){
            return dp[i][j][k] = 0;
        }
        return dp[i][j][k] = Math.max(3 + ans(i-1,j-2,k), 3 + ans(i,j-1, k-2));
    }
}