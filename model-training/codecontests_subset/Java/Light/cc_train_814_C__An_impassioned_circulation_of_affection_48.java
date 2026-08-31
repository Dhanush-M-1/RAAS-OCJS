import java.util.*;
public class A{
       public static void main(String args[]){
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              String S = sc.next();
              int dp[][] = new int[26][n+1];
              for(int c = 0; c < 26; c++){
                     for(int i = 0; i < S.length(); i++){
                            int rep_cnt = 0;
                            for(int j = i; j < S.length(); j++){
                                   if((S.charAt(j) - 'a') != c)
                                          rep_cnt++;
                                   dp[c][rep_cnt] = Math.max(dp[c][rep_cnt], j - i + 1);
                            }
                     }
                     for(int i = 1; i <= n; i++)
                            dp[c][i] = Math.max(dp[c][i], dp[c][i-1]);
              }
              int q = sc.nextInt();
              for(int i = 0; i < q; i++){
                     int m = sc.nextInt();
                     int c = sc.next().charAt(0) - 'a';
                     System.out.println(dp[c][m]);
              }
       }
}