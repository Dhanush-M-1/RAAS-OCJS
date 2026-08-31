import java.util.*;
import java.io.*;
import static java.lang.System.in;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] id,maxLen;
    public static void main(String[] args)throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String[] buf = reader.readLine().split(" ");
        int n = Integer.parseInt(buf[0]), m = Integer.parseInt(buf[1]), q = Integer.parseInt(buf[2]);
        id = new int[n+1]; maxLen = new int[n+1];
        for(int i=0;i<=n;i++) id[i] = i;
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            buf = reader.readLine().split(" ");
            int a = Integer.parseInt(buf[0]), b = Integer.parseInt(buf[1]);
            graph[a].add(b);
            graph[b].add(a);
            union(a,b);
        }
        // calculate the initial max length of each region
        boolean[] vis = new boolean[n+1];
        Arrays.fill(maxLen,0);
        for(int i=1;i<=n;i++){
            int root = find(i);
            if(vis[root]) continue;
            int[] cur = dfs2(root,-1);
            maxLen[root] = cur[1];
            vis[root] = true;
        }
        PrintWriter out = new PrintWriter(System.out);
        for(int i=0;i<q;i++){
            buf = reader.readLine().split(" ");
            if(buf.length==2){
                int tar = Integer.parseInt(buf[1]);
                int cur = maxLen[find(tar)];
                out.println(cur);
            }else{
                int a = Integer.parseInt(buf[1]), b = Integer.parseInt(buf[2]);
                unite(a,b);
            }
        }
        out.flush();
    }
    // for stage 2
    static void unite(int p, int q){
        int i = find(p), j = find(q);
        if(i==j) return;
        int newLen = (maxLen[i]+1)/2+(maxLen[j]+1)/2+1;
        id[j] = i;
        maxLen[i] = Math.max(newLen,Math.max(maxLen[i],maxLen[j]));
    }
    static int[] dfs2(int cur, int from){ // used to find maxLen
        int[] ans = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(10,Collections.reverseOrder());
        ArrayList<Integer> que = new ArrayList<>(3);
        for(int w:graph[cur]){
            if(w==from) continue;
            int[] now = dfs2(w,cur);
            int toAppend = now[0]+1;
            if(que.size()==0) que.add(toAppend);
            else if(que.size()==1){
                int idx = que.get(0)>toAppend?1:0;
                que.add(idx,toAppend);
            }else{
                if(now[0]+1>=que.get(0)) que.add(0,toAppend);
                else if(now[0]+1>=que.get(1)) que.add(1,toAppend);
            }
            if(que.size()>2) que.remove(2);
            ans[1] = Math.max(ans[1],now[1]);
        }
        if(que.size()==0) return ans;
        if(que.size()==1){
            ans[0] = que.get(0);
            ans[1] = Math.max(ans[1],ans[0]);
        }else{
            ans[0] = que.get(0);
            int can = ans[0]+que.get(1);
            ans[1] = Math.max(ans[1],Math.max(ans[0],can));
        }
        return ans;
    }
    static int find(int p){
        while(id[p]!=p){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    // used in the stage 1
    static void union(int p, int q){
        int i=find(p),j=find(q);
        if(i==j) return;
        id[j] = i;
    }
}