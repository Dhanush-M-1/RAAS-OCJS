
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Main {

    static int mx,at;
    static int [] p;
    static List<Integer> [] g;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        
        tk = new StringTokenizer(in.readLine());
        int n = parseInt(tk.nextToken()),m = parseInt(tk.nextToken()),q = parseInt(tk.nextToken());
        int i,j,a,b,t;
        
        p = new int[n];
        g = new List[n];
        for(i=0; i<n; i++) {
            p[i] = i;
            g[i] = new ArrayList<Integer>();
        }
        
        while(m-- > 0) {
            tk = new StringTokenizer(in.readLine());
            a = parseInt(tk.nextToken())-1;
            b = parseInt(tk.nextToken())-1;
            
            g[a].add(b);
            g[b].add(a);
            p[find(a)] = find(b);
        }
        
        int [] len = new int[n];
        
        for(i=0; i<n; i++) 
            if(i == p[i]) 
                len[i] = getLongestPath(i);
            
        
        while(q-- > 0) {
            tk = new StringTokenizer(in.readLine());
            t = parseInt(tk.nextToken());
            a = parseInt(tk.nextToken())-1;
            
            if(t == 1) {
                out.append(len[find(a)]).append("\n");
            } else {
                b = parseInt(tk.nextToken())-1;
                
                a = find(a);
                b = find(b);
                
                if(a == b) continue;
                
               
                len[b] = max(max(len[a],len[b]), (len[a]+1)/2+(len[b]+1)/2+1);
                p[a] = b;
            } 
        }
        
        System.out.print(out);
    }
    
    static int getLongestPath(int u) {
        mx = -1;
        at = 0;
        DFS(u,-1,0);
        mx = -1;
        DFS(at,-1,0);
        return mx;
    }
    
    static void DFS(int u,int p,int cost) {
        if(cost > mx) {
            mx = cost;
            at = u;
        }
        
        for(int w : g[u]) 
            if(w != p)
                DFS(w,u,cost+1);
    }
    
    static int find(int u) {
        if(u == p[u])
            return u;
        return p[u] = find(p[u]);
    }
}
