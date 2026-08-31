import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] F =new int[N+1];
        HashMap<Integer,Integer> dic = new HashMap<>();
        for(int i=0;i<=1024;i++){
            int j=i;
            int cnt = 0;
            while(j>0){
                cnt += j&1;
                j = j>>1;
            }
            dic.put(i,cnt);
        }
        for(int i=1;i<=N;i++){
            for(int j=0; j<9; j++){
                int cur = sc.nextInt();
                F[i] += cur;
                F[i] *= 2;
            }
            F[i] += sc.nextInt();
        }
        int[][] P = new int[N+1][11];
        for(int i=1;i<=N;i++){
            for(int j=0; j<= 10; j++){
                P[i][j] = sc.nextInt();
            }
        }
        long ans = Long.MIN_VALUE;
        for(int i=1;i<1024;i++){
            long cur = 0;
            for(int j=1;j<=N;j++){
                int together = i&F[j];
                int temp = P[j][dic.get(together)];
                cur += temp;
            }
            ans = Math.max(ans,cur);
        }
        System.out.println(ans);
    }
}