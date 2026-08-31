import java.util.*;


public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        int[] wt = new int[N + 1];
        int[] reqd = new int[M];
        for(int i = 1; i <= N; i++)
            wt[i] = sc.nextInt();
        for(int i = 0; i < M; i++)
            reqd[i] = sc.nextInt();
        boolean[] vis = new boolean[N + 1];
        int[] order = new int[N];
        int x = 0;
        for(int i = 0; i < M; i++){
            if(!vis[reqd[i]]) order[x++] = reqd[i];
            vis[reqd[i]] = true;
        }
        int ans = 0;
        for(int i = 0; i < M; i++){
            int pos = -1;
            for(int j = 0; j < N; j++){
                if(order[j] == reqd[i]){
                    pos = j;
                    break;
                }
                ans += wt[order[j]];
            }
            for(int j = pos - 1; j >= 0; j--)
                order[j + 1] = order[j];
            order[0] = reqd[i];
        }
        System.out.println(ans);
    }
}