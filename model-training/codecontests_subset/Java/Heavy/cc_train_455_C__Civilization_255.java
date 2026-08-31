import java.io.*;
import java.util.*;


public class p71 {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    
    static boolean[] visited;
    static int longest;
    static ArrayList<Integer>[] graph;
    
    static int find(int x, int[] par){
        if(x==par[x])
            return x;
        return par[x] = find(par[x], par);
    }

    static int dfs(int u, int p){
        visited[u] = true;

        if(p!=-1 && graph[u].size()==1)
            return 0;
        if(p==-1 && graph[u].size()==0)
            return 0;

        int max1=-1, max2=-1;
        for(int i=0, s=graph[u].size(); i<s; i++){
            int v = graph[u].get(i);
            if(!visited[v]){
                int cur = dfs(v, u);
                // System.out.println("-- "+v+" "+cur);
                if(cur>max1){
                    max2 = max1;
                    max1 = cur;
                }else if(cur>max2){
                    max2 = cur;
                }
            }
        }

        if(max1!=-1 && max2!=-1)
            longest = Math.max(longest, max1+2+max2);
        if(max1!=-1 || max2!=-1)
            longest = Math.max(longest, Math.max(max1,max2)+1);
        
        return Math.max(max1,max2)+1;
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            graph[i] = new ArrayList<Integer>();
        
        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        int[] par = new int[n+1];
        for(int i=0;i<=n;i++)
            par[i] = i;
        
        int[] dist = new int[n+1];

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
            int pa = find(a, par);
            int pb = find(b, par);
            if(pa!=pb)
                par[pa] = pb;
        }

        for(int i=1;i<=n;i++)
            if(!visited[i]){
                longest = 0;
                dfs(i, -1);
                dist[find(i, par)] = longest;
            }
        
        // for(int i=0;i<=n;i++)
        //     System.out.print(dist[i]+ " ");
        // System.out.println("");    
        
        while(q-->0){
            int t = sc.nextInt();
            if(t==1){
                int x = sc.nextInt();
                out.println(dist[find(x, par)]);
            }else{
                int x = sc.nextInt(), y=sc.nextInt();
                int px = find(x, par);
                int py = find(y, par);
                if(px!=py){
                    int d = Math.max(dist[px], Math.max(dist[py], (dist[px]+1)/2+(dist[py]+1)/2+1));
                    par[px] = py;
                    dist[py] = d;
                }
            }
        }
        out.close();
        // System.out.println(ans);
    }
}