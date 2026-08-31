import java.util.*;

public class E {

   public static void main (String [] args) {
   
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      String s = sc.next();
      int [][] dp = new int[26][N+1];
      
      for (int a=0; a<26; a++) {
         char c = (char)(97+a);       
         int [] psum = new int[N+1];
         for (int i=1; i<=s.length(); i++) {
            if (s.charAt(i-1)==c)  
               psum[i]++;
            psum[i]+=psum[i-1];
         }
         for (int i=1; i<=N; i++)
            for (int j=i; j<=N; j++) {
               int numc = psum[j]-psum[i-1];
               dp[a][j-i+1-numc]=Math.max(dp[a][j-i+1-numc], j-i+1);
            }
         for (int i=1; i<=N; i++)
            dp[a][i]=Math.max(dp[a][i], dp[a][i-1]);
      }
      //System.out.println(Arrays.toString(dp[0]));
      int Q = sc.nextInt();
      for (int k=0; k<Q; k++) {
         int i = sc.nextInt();
         System.out.println(dp[sc.next().charAt(0)-97][i]);
      }
   }
}