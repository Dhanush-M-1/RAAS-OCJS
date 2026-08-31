import java.util.*;
import java.io.*;

public class C{

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean hasAns = true;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1000000000;
            dp[i][1] = 0;
        }
        int[][] input = new int[m][4];
        for(int i = 0; i < m; i++){
            int mode = input[i][0] = in.nextInt();
            if(mode == 1){
                int l = input[i][1] = in.nextInt() - 1;
                int r = input[i][2] = in.nextInt() - 1;
                int val = input[i][3] = in.nextInt();
                for(int j = l; j <= r; j++){
                    dp[j][1] += val;
                }
            } else if(mode == 2){
                int l = input[i][1] = in.nextInt() - 1;
                int r = input[i][2] = in.nextInt() - 1;
                int val = input[i][3] = in.nextInt();
                boolean free = false;
                for(int j = l; j <= r; j++){
                    if((dp[j][0] + dp[j][1]) >= val){
                        free = true;
                        dp[j][0] = val - dp[j][1];
                    }
                }
                if(!free){
                    hasAns = false;
                }
            }
        }
        for(int i = 0; i < n; i++){
            dp[i][1] = 0;
        }
        for(int i = 0; i < m; i++){
            if(input[i][0] == 2){
                boolean ok = false;
                for(int j = input[i][1]; j <= input[i][2]; j++){
                    if(dp[j][0] + dp[j][1] == input[i][3]){
                        ok = true;
                    }
                }
                if(!ok){
                    hasAns = false;
                }
            } else{
                for(int j = input[i][1]; j <= input[i][2]; j++){
                    dp[j][1] += input[i][3];
                }
            }
        }
        if(hasAns){
            out.println("YES");
            out.print(dp[0][0]);
            for(int i = 1; i < n; i++){
                out.print(" " + dp[i][0]);
            }
        } else{
            out.println("NO");
        }
        out.close();
    }
}
