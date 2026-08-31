import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    
    static Subset[] subsets;
    
    static class Node{
        int id;
        HashSet<Integer> forbiden = new HashSet<Integer>();
        Node(int id){
            this.id = id;
        }
    }
    
    static Node[] node;
    static int n;
    
    static TreeSet<Integer> ts = new TreeSet<Integer>();
    
    static void dfs(int nod){
        
        int i = ts.higher(0);
        while(i!=n+1){
            if(!node[nod].forbiden.contains(i)){
                
                ts.remove(i);
                union(nod,i);
                dfs(i);
                
            }
            i = ts.higher(i);
        }
        
    }
    
    static class Subset{
        int parent;
        int rank;
        public Subset(int p,int r){
            parent = p;
            rank = r;
        }
    }
    
    static int find(int i){
        if(subsets[i].parent!=i) subsets[i].parent = find(subsets[i].parent);
        return subsets[i].parent;
    }
    
    static void union(int x,int y){
        int xroot = find(x);
        int yroot = find(y);
        if(subsets[xroot].rank<subsets[yroot].rank) subsets[xroot].parent = yroot;
        else if(subsets[xroot].rank>subsets[yroot].rank) subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }
    
    public static void main(String[] args)throws IOException{
                
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PrintWriter out = new PrintWriter(System.out);
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        subsets = new Subset[n+1];
        for(int i=1;i<=n;i++){
            subsets[i] = new Subset(i,0);
        }
        
        node = new Node[n+1];
        for(int i=1;i<=n;i++) node[i] = new Node(i);
        
        for(int i=1;i<=n+1;i++) ts.add(i);
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x].forbiden.add(y);
            node[y].forbiden.add(x);
        }
        
        for(int i=1;i<=n;i++){
            
            if(ts.contains(i)){
                ts.remove(i);
                dfs(i);
            }
            
        }
        
        int[] nb = new int[n+1];
        for(int i=1;i<=n;i++) nb[find(i)]++;
        int k = 0;
        
        for(int i=1;i<=n;i++){
            if(nb[i]!=0) k++;
        }
        
        out.println(k);
        int[] g = new int[k];
        int pos = 0;
        for(int i=1;i<=n;i++){
            if(nb[i]!=0) {
                g[pos] = nb[i];
                pos++;
            }
        }
        
        Arrays.sort(g);
        for(int i=0;i<k;i++) out.print(g[i]+" ");
        out.println("");

        out.flush();
        
    }
    
}