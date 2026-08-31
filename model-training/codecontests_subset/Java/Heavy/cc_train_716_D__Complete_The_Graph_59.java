import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public final class Solution {
    static int eid[][]=new int[1100][1100];
    static int prev[] =new int[1010];   
    public static void main(String args[] ) throws Exception {
        Arrays.fill(prev, -1);
        
        I r = new I();
        int n,m,l,st,en,i,j,k,p,q;
        
        n=r.in_i();
        m=r.in_i();
        l=r.in_i();
        st=r.in_i();
        en=r.in_i();
        List<edge> adj[]=new ArrayList[n];
        List<edge> aux[] = new ArrayList[n];
        
        for(i=0; i<n; i++){
            adj[i]=new ArrayList<edge>(30);
         aux[i]=new ArrayList<edge>(30);
        }
        int eu[]=new int[m], ev[]=new int[m], eweigh[] =new int[m];
        
        for(i=0; i<n; i++) for(j=0; j<n; j++) eid[i][j]=-1;
        
        for(i=0; i<m; i++){
            eu[i]=r.in_i();
            ev[i]=r.in_i();
            eweigh[i]=r.in_i();
            p = q= eweigh[i];
            if(p==0) {
                p=1;
                q=l+2;
                eid[eu[i]][ev[i]]=i;
                eid[ev[i]][eu[i]]=i;               
            }
            aux[eu[i]].add(new edge(ev[i],q));
            aux[ev[i]].add(new edge(eu[i],q));
            
            adj[eu[i]].add(new edge(ev[i],p));
            adj[ev[i]].add(new edge(eu[i],p));
        }
        
        long sum=0, d2 = dijikstra(aux,st,n,en); 
        Arrays.fill(prev, -1);
        long d = dijikstra(adj, st, n, en); 
        if(d > l ||  d2 < l) {
            System.out.print("NO");
            return ;
        }
        while(true){
            boolean f=false ;
           k=en;
           while(prev[k]!=-1){
               p = prev[k];
               if(eid[p][k]!=-1 && eweigh[eid[p][k]] == 0)
               {
                   f=true;
                   eweigh[eid[p][k]] = 1+l-(int)d;
                   for(j=0; j<adj[p].size(); j++){
                       if(adj[p].get(j).to==k){
                           adj[p].get(j).wt += l-(int)d;
                          break;
                       }
                   }
                   for(j=0; j<adj[k].size(); j++){
                       if(adj[k].get(j).to==p){
                           adj[k].get(j).wt += l-(int)d;
                           break;
                       }
                   }
                   break;
               }
               k = p;
           }
            if(!f)
                break;
            Arrays.fill(prev,-1);
           d = dijikstra(adj,st,n,en);
          //  System.out.println("Bug");
        }
       
       StringBuilder sb=new StringBuilder(10000);
        sb.append("YES\n");
        for(i=0; i<m; i++){
            sb.append(eu[i]).append(' ').append(ev[i]).append(' ');
            if(eweigh[i]==0) sb.append(l+5);
            else
                sb.append(eweigh[i]);
            sb.append('\n');
        }
        System.out.print(sb);
        
    }
    
    
    static long dijikstra(List<edge> adj[],int s, int V, int t){
        long inf = (long)1e12;
        long d[] = new long[V];
       // int prev[] =new int[V];   
         Arrays.fill(d, inf);
        
        boolean solved[] = new boolean[V+1];
        d[s]=0;
           prev[s] = -1;
        MinHeap mh = new MinHeap(2*V);
        mh.insert(new node(s,0));    
        
        while(!mh.isEmpty()){
            
            int u=mh.extract().id;
            solved[u]=true;
            if(u==t)
                return d[u];
            int l=adj[u].size();
            for(int pos=0; pos<l; pos++){
                
                edge ne=adj[u].get(pos);
                int neigh = ne.to;
                if(!solved[neigh] &&
                     d[u] + ne.wt < d[neigh]){
                   
                    if(!mh.isPresent(neigh))
                        mh.insert(new node(neigh, d[u] + ne.wt));                        
                     else
                        mh.decrease(neigh, d[u] + ne.wt);
                    
                    d[neigh] = d[u] + ne.wt;
                    prev[neigh] = u;
                }
                    
            }            
         }
           return d[t];
       }
           


static class edge{
    int to,wt;
    edge(int x, int y){
        to=x;
        wt=y;
    }
}

static class node{

    int id;
    long key;
    node(int i, long j){
        id= i; key=j;
    }
}


static class MinHeap{

    node heap[];
    int len;
    int cap;
    int pos[];
 
    //private static final int FRONT = 1;
 
    public MinHeap(int maxsize)
    {
        cap = maxsize;
        len = 0;
        heap = new node[cap + 1];
        heap[0] = null;
        pos = new int[cap+1];
        Arrays.fill(pos,-1);
    }

    void insert (node n)
    {
    len = len + 1;
    heap[len]=n; pos[n.id] = len;
    int i=len,j;
  //  change(len, n.key);
    while( i > 1 && heap[ (j=i>>1) ].key > heap[ i ].key)
        {
        swap(j,i);
        i = j;
        }
    }

    void decrease(int id, long val)
    {    
    int i = pos[id],j;
    heap[i].key = val;
     while( i > 1 && heap[ (j=i>>1) ].key > heap[ i ].key)
        {
        swap(j,i);
        i = j;
        }
    }
    
    boolean isEmpty(){
        return len==0;
    }

    void min_heapify (int i)
    {
    int left = i<<1, least;          
    int right = 2*i +1;          //right child
    if(left<= len && heap[left].key < heap[i].key )
          least = left;
    else
         least = i;
    if(right <= len && heap[right].key < heap[least].key)
        least = right;
    if(least != i )
    {
        swap (i, least);
        min_heapify(least);
    } 
    }

    void swap(int i, int j) {
        pos[heap[i].id] = j;
        pos[heap[j].id] = i;
        node temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp; 

    }

    node extract()
    {
    node min = heap[1];
    heap[1] = heap[len];
    pos[heap[len].id] = 1;
    pos[min.id] = len;
    len = len -1;
    min_heapify(1);
    return min;
    }

    boolean isPresent(int id){
        if(pos[id] > len || pos[id] == -1)
            return false;
        return true;
    }
 
}
    
static class I{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public I() {
                this.stream = System.in;
        }
        
        public int read() {
                if (numChars == -1) {
                        throw new InputMismatchException();
                }
                if (curChar >= numChars) {
                        curChar = 0;
                        try {
                                numChars = stream.read(buf);
                        } catch (IOException e) {
                                throw new InputMismatchException();
                        }
                        if (numChars <= 0) {
                                return -1;
                        }
                }
                return buf[curChar++];
        }
        
        public int in_i() {
                int c = read();
                while (isSpaceChar(c)) {
                        c = read();
                }
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                int res = 0;
                do {
                        if (c < '0' || c > '9') {
                                throw new InputMismatchException();
                        }
                        res *= 10;
                        res += c - '0';
                        c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public String readString() {
                int c = read();
                while (isSpaceChar(c)) {
                        c = read();
                }
                StringBuilder res = new StringBuilder();
                do {
                        res.appendCodePoint(c);
                        c = read();
                } while (!isSpaceChar(c));
                return res.toString();
        }
        
        public double in_d() {
                int c = read();
                while (isSpaceChar(c)) {
                        c = read();
                }
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                double res = 0;
                while (!isSpaceChar(c) && c != '.') {
                        if (c == 'e' || c == 'E') {
                                return res * Math.pow(10, in_i());
                        }
                        if (c < '0' || c > '9') {
                                throw new InputMismatchException();
                        }
                        res *= 10;
                        res += c - '0';
                        c = read();
                }
                if (c == '.') {
                        c = read();
                        double m = 1;
                        while (!isSpaceChar(c)) {
                                if (c == 'e' || c == 'E') {
                                        return res * Math.pow(10, in_i());
                                }
                                if (c < '0' || c > '9') {
                                        throw new InputMismatchException();
                                }
                                m /= 10;
                                res += (c - '0') * m;
                                c = read();
                        }
                }
                return res * sgn;
        }
        
        public long in_l() {
                int c = read();
                while (isSpaceChar(c)) {
                        c = read();
                }
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                long res = 0;
                do {
                        if (c < '0' || c > '9') {
                                throw new InputMismatchException();
                        }
                        res *= 10;
                        res += c - '0';
                        c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public boolean isSpaceChar(int c) {
                if (filter != null) {
                        return filter.isSpaceChar(c);
                }
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        public String next() {
                return readString();
        }
        
        public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
        }
}


}

