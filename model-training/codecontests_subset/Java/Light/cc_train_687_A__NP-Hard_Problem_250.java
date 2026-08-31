import java.util.*;
public class Hard2{
    static List<Integer>[] graph,res;
    static int[] color;
    static int n,m;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        m=input.nextInt();
        color=new int[n+1];
        graph=new List[n+1];
        res = new List[2];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<2;i++)
            res[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            int u=input.nextInt();
            int v=input.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                if(graph[i].isEmpty())
                    continue;
                if(dfs(i, 2)){
                    System.out.println(-1);
                    return;
                }
            }
        }
        for(int i=0;i<2;i++){
            System.out.println(res[i].size());
            for(int x:res[i])
                System.out.print(x+ " ");
            System.out.println();
                
            
        }
            
    }
    public static boolean dfs(int r,int p){
        color[r]=p;
        res[p-1].add(r);
        for(int child:graph[r]){
            if(color[child]==0 && dfs(child, 3-p))
                return true;
            if(color[child]!=3-p)
                return true;
        }
        return false;
    }
}