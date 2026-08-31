import java.util.*;

public class Solve{
    static ArrayList<Integer>[] gr;
    static int[] vis1,vis2;
    static int a,b;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
             a=sc.nextInt();
             b=sc.nextInt();
            gr=new ArrayList[n+1];
            vis1=new int[n+1];
            vis2=new int[n+1];
            for(int i=0;i<=n;i++){
                gr[i]=new ArrayList<>();
            }
            for(int i=0;i<m;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                gr[u].add(v);
                gr[v].add(u);
            }
            dfs1(a);
            dfs2(b);
            int d1=0;
            int d2=0;
            for(int i=1;i<=n;i++){
                if(vis1[i]==0)d1++;
                if(vis2[i]==0)d2++;
            }
            sb.append(1L*d1*d2+"\n");
            
        }
        System.out.println(sb);
    }
    static void dfs1(int n)
    {
        vis1[n]=1;
        if(n==b)return ;
        for(int child:gr[n]){
            if(vis1[child]==0)dfs1(child);
        }
    }
      static void  dfs2(int n)
    {
        vis2[n]=1;
        if(n==a)return ;
        for(int child:gr[n]){
            if(vis2[child]==0)dfs2(child);
        }
    }
    
}