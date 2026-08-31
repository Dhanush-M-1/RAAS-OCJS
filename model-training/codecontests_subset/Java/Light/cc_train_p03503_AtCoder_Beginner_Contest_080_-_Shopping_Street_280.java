import java.util.*;
 
public class Main{
public static Scanner sc = new Scanner (System.in);
     public static void main(String []args){
        
        int N = sc.nextInt();
        int[][] F = input(N,10);
        int[][] P = input(N,11);
        int ans = 0;
        //System.out.println(Arrays.toString(F[0]));
        for (int b=1;b<(1<<10);b++){
            int cc = 0;
            for (int i=0;i<N;i++){
                int c = 0;
                for(int j=0;j<10;j++)if(((b>>(9-j)&1)==F[i][j])&&F[i][j]==1)c++;
                cc += P[i][c];
            }
            if(b==1)ans=cc;
            ans = Math.max(ans,cc);
        }
        //for(int i=0;i<N;i++)System.out.println(Arrays.toString(F[i]));
        //for(int i=0;i<N;i++)System.out.println(Arrays.toString(P[i]));
        System.out.println(ans);
        
     }
     
     public static int[][] input(int N,int n){
         int[][] a = new int[N][n];
         for (int i=0;i<N;i++) for (int j=0;j<n;j++) a[i][j]=sc.nextInt();
         return a;
     }
}