import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main{

    static class Edge{
        int to,dis;
        Edge(int to,int dis){
            this.to = to;
            this.dis = dis;
        }
    }
    static int used[];
    static List<Edge> edgeList[];

    static boolean dfs(int v,int pos){
        if(used[v] > Integer.MIN_VALUE)return used[v] == pos;
        used[v] = pos;
        for(Edge e : edgeList[v]){
            if(!dfs(e.to,pos+e.dis))return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        edgeList = new ArrayList[N+1];
        for(int i=1;i<=N;++i)edgeList[i]=new ArrayList<>();
        used = new int[N+1];
        Arrays.fill(used,Integer.MIN_VALUE);
        for(int i=0;i<M;++i){
            int L = scan.nextInt();
            int R = scan.nextInt();
            int D = scan.nextInt();
            edgeList[L].add(new Edge(R,D));
            edgeList[R].add(new Edge(L,-D));
        }

        for(int i=1;i<=N;++i){
            if(used[i] > Integer.MIN_VALUE)continue;
            if(!dfs(i,0)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");


    }
}