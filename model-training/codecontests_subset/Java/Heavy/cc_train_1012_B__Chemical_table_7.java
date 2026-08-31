import java.util.*;
import java.io.*;
public class Waw{
    public static class Node{
        int r,c;
        Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    static class subset 
    { 
        int parent; 
        int rank; 
        public subset(int p,int r){
            parent = p;
            rank = r;
        }
    } 
    static int find(subset [] subsets , int i) { 
        if (subsets[i].parent != i) 
            subsets[i].parent = find(subsets,subsets[i].parent); 
        return subsets[i].parent; 
    }  
  
    static void union(subset [] subsets,int x , int y ) { 
      
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[yroot].rank < subsets[xroot].rank) 
            subsets[yroot].parent = xroot; 
        else
        { 
            subsets[xroot].parent = yroot; 
            subsets[yroot].rank++; 
        } 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Node[] node = new Node[q];
        int r,c;
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            node[i] = new Node(r,c);
        }
        Arrays.sort(node,new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                if(n1.c<n2.c) return -1;
                else if(n1.c>n2.c) return 1;
                else {
                    if(n1.r<n2.r) return -1;
                    else if(n1.r>n2.r) return 1;
                    else return 0;
                }
            }    
        });
        subset [] subsets = new subset[n+1]; 
        for (int v = 0; v < n+1; v++) 
        { 
      
            subsets[v] = new subset(v,0); 
        } 
        int prc = -1;
        int prr = -1;
        int nbc = m;
        for(int i=0;i<q;i++){
            if(prc!=node[i].c) {
                nbc--;
                prc = node[i].c;
                prr = -1;
            }
            if(prr==-1) prr = node[i].r;
            else{
                union(subsets,prr,node[i].r);
            }
        }
        int nb = -1;
        for(int i=1;i<=n;i++){
            if(subsets[i].parent==i) nb++;
        }
        nb += nbc;
        
        System.out.println(nb);
    }
}